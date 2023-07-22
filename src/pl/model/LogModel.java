package pl.model;

import bll.be.Log;
import bll.manager.LogManager;

import java.util.List;

public class LogModel {
    //TODO LogManager
    private LogManager logManager;
    public LogModel(){
        logManager = new LogManager();
    }

    List<Log> getAllLogs() {
        return logManager.getAllLogs();
    }
    List<Log> getLogsByDate(String date) {
        return logManager.getLogsByDate(date);
    }
    List<Log> getLogsForProject(String refNumber){
        return logManager.getLogsForProject(refNumber);
    }
    List<Log> getLogsForAccount(int id){
        return logManager.getLogsForAccount(id);
    }
    Log getLogByID(int id){
        return logManager.getLogByID(id);
    }
    Boolean createLog(Log log){
        return logManager.createLog(log);
    }
    Boolean removeLog(int id){
        return logManager.removeLog(id);
    }
}
