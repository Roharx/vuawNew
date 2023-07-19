package dal.mapper;

import bll.be.Account;
import bll.be.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper {
    private Account account;

    public AccountMapper(){this.account = null;}

    public void mapAccount(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("uName");
        String password = rs.getString("uPassword");
        UserType userType = UserType.Admin;//TODO edit enum to convert int to return type
        this.account = new Account(id, username, password, userType);
    }

    public Account getAccount(){
        return this.account;
    }
}
