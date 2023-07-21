package dal;

import bll.be.Log;
import dal.connector.MSSQLConnector;
import dal.interfaces.ILogDAO;
import dal.mapper.LogMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogDAO implements ILogDAO {
    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public LogDAO() {
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Log> getAllLogs() {
        LogMapper mapper = new LogMapper();
        List<Log> allLogs = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Logs";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapLog(rs);
                allLogs.add(mapper.getLog());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allLogs;
    }

    @Override
    public List<Log> getLogsByDate(String date) {
        LogMapper mapper = new LogMapper();
        List<Log> allLogs = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Logs WHERE logDate=?";//TODO look up the column names
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapLog(rs);
                allLogs.add(mapper.getLog());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allLogs;
    }

    @Override
    public List<Log> getLogsForProject(String refNumber) {
        LogMapper mapper = new LogMapper();
        List<Log> allLogs = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Logs WHERE refNumber=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, refNumber);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapLog(rs);
                allLogs.add(mapper.getLog());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allLogs;
    }

    @Override
    public List<Log> getLogsForAccount(int id) {
        LogMapper mapper = new LogMapper();
        List<Log> allLogs = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Logs WHERE accountID=?";//TODO look up the column names
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                mapper.mapLog(rs);
                allLogs.add(mapper.getLog());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allLogs;
    }

    @Override
    public Log getLogByID(int id) {
        LogMapper mapper = new LogMapper();
        Log log = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Logs WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                mapper.mapLog(rs);
                log = mapper.getLog();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return log;
    }

    @Override
    public Boolean createLog(Log log) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "INSERT INTO Logs (id, accountID, refNumber, logDate) VALUES (?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, log.getId());
            preparedStatement.setInt(2, log.getAccountID());
            preparedStatement.setString(3, log.getRefNumber());
            preparedStatement.setString(4, log.getDate());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Boolean removeLog(int id) {
        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "DELETE FROM Devices WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}