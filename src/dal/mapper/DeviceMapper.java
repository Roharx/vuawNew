package dal.mapper;

import bll.be.Device;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceMapper {
    private Device device;
    public DeviceMapper(){this.device = null;}

    public void mapDevice(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("deviceName");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String refNumber = rs.getString("refNumber");
        this.device = new Device(id, name, username, password, refNumber);
    }

    public Device getDevice(){
        return this.device;
    }
}
