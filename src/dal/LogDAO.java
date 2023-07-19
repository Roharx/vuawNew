package dal;

import bll.be.Log;
import dal.connector.MSSQLConnector;
import dal.interfaces.ILogDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

public class LogDAO implements ILogDAO {
    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public LogDAO(){
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Log> getAllLogs() {
        return null;
    }

    @Override
    public List<Log> getLogsByDate(String date) {
        return null;
    }

    @Override
    public List<Log> getLogsForProject(String refNumber) {
        return null;
    }

    @Override
    public List<Log> getLogsForAccount(int id) {
        return null;
    }

    @Override
    public Log getLogByID(int id) {
        return null;
    }

    @Override
    public Boolean createLog(Log log) {
        return null;
    }

    @Override
    public Boolean removeLog(int id) {
        return null;
    }
}
