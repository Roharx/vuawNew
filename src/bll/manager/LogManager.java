package bll.manager;

import bll.be.Log;
import bll.manager.interfaces.ILogManager;
import dal.LogDAO;
import dal.interfaces.ILogDAO;

import java.util.List;

public class LogManager implements ILogManager {
    private ILogDAO logDAO;
    public LogManager(){
        logDAO = new LogDAO();
    }
    @Override
    public List<Log> getAllLogs() {
        return logDAO.getAllLogs();
    }

    @Override
    public List<Log> getLogsByDate(String date) {
        return logDAO.getLogsByDate(date);
    }

    @Override
    public List<Log> getLogsForProject(String refNumber) {
        return logDAO.getLogsForProject(refNumber);
    }

    @Override
    public List<Log> getLogsForAccount(int id) {
        return logDAO.getLogsForAccount(id);
    }

    @Override
    public Log getLogByID(int id) {
        return logDAO.getLogByID(id);
    }

    @Override
    public Boolean createLog(Log log) {
        return logDAO.createLog(log);
    }

    @Override
    public Boolean removeLog(int id) {
        return logDAO.removeLog(id);
    }
}
