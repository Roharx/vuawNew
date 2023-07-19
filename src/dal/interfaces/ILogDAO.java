package dal.interfaces;

import bll.be.Log;

import java.util.List;

public interface ILogDAO {
    List<Log> getAllLogs();
    List<Log> getLogsByDate(String date);
    List<Log> getLogsForProject(String refNumber);
    List<Log> getLogsForAccount(int id);
    Log getLogByID(int id);
    Boolean createLog(Log log);
    Boolean removeLog(int id);
}
