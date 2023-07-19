package dal;

import bll.be.Device;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import dal.connector.MSSQLConnector;
import dal.interfaces.IDeviceDAO;
import dal.mapper.DeviceMapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        DeviceMapper mapper = new DeviceMapper();
        List<Device> allDevices = new ArrayList<>();

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Devices";
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                mapper.mapDevice(rs);
                allDevices.add(mapper.getDevice());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allDevices;
    }

    @Override
    public Device getDeviceByID(String refNumber, int id) { //TODO don't need refNumber
        DeviceMapper mapper = new DeviceMapper();
        Device device = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Devices WHERE id=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                mapper.mapDevice(rs);
                device = mapper.getDevice();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return device;
    }

    @Override
    public Device getDeviceByName(String refNumber, String name) { //TODO check the DB
        DeviceMapper mapper = new DeviceMapper();
        Device device = null;

        try {
            Connection conn = mssqlConnector.createConnection();
            String sql = "SELECT * FROM Devices WHERE refNumber=?, name=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, refNumber);
            preparedStatement.setString(2, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                mapper.mapDevice(rs);
                device = mapper.getDevice();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return device;
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
