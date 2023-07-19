package dal.mapper;

import bll.be.Log;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogMapper {
    private Log log;
    public LogMapper(){this.log = null;}
    public void mapLog(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int accountID = rs.getInt("accountID");
        String refNumber = rs.getString("refNumber");
        String date = rs.getString("date");
        this.log = new Log(id, accountID, refNumber, date);
    }
    public Log getLog(){
        return this.log;
    }
}
