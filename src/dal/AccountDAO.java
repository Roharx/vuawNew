package dal;

import bll.be.Account;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.MSSQLConnector;
import dal.interfaces.IAccountDAO;
import dal.mapper.AccountMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements IAccountDAO {
    //due to multiple reasons, it'd be unwise to make the DAO a singleton
    //my reasons: Dependency Injection (could lead to high coupling), testability, flexibility & maintainability
    //this comment applies to all my DAOs

    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public AccountDAO(){
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Account> getAllAccounts() {
        AccountMapper mapper = new AccountMapper();
        List<Account> allAccounts = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Accounts";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                mapper.mapAccount(rs);
                allAccounts.add(mapper.getAccount());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allAccounts;
    }

    @Override
    public Account getAccountByID(int id) {
        AccountMapper mapper = new AccountMapper();
        Account result = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Account WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                mapper.mapAccount(rs);
                result = mapper.getAccount();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Account getAccountByName(String name) {
        AccountMapper mapper = new AccountMapper();
        Account result = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Account WHERE uName=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                mapper.mapAccount(rs);
                result = mapper.getAccount();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Boolean createAccount(Account account) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "INSERT INTO Account (uName, uPassword, uType) VALUES (?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, 0);//TODO edit enum to get number from type
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean removeAccount(int id) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "DELETE FROM Account WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Boolean updateAccount(Account account) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "UPDATE Account (uName, uPassword, uType) VALUES (?,?,?) WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setInt(3, 0);//TODO edit enum to get number from type
            preparedStatement.setInt(4, account.getId());
            preparedStatement.executeUpdate();

            return true;

        } catch (SQLException e) {
            return false;
        }
    }
}
