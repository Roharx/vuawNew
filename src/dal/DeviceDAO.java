package dal;

import bll.be.Device;
import dal.connector.MSSQLConnector;
import dal.interfaces.IDeviceDAO;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

public class DeviceDAO implements IDeviceDAO {
    private final MSSQLConnector mssqlConnector;
    private PreparedStatement preparedStatement;

    public DeviceDAO(){
        try {
            mssqlConnector = new MSSQLConnector();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Device> getAllDevicesForProject(String refNumber) {
        return null;
    }

    @Override
    public Device getDeviceByID(String refNumber, int id) {
        return null;
    }

    @Override
    public Device getDeviceByName(String refNumber, String name) {
        return null;
    }

    @Override
    public Boolean createDevice(Device device) {
        return null;
    }

    @Override
    public Boolean updateDevice(Device device) {
        return null;
    }

    @Override
    public Boolean removeDevice(int id) {
        return null;
    }
}
