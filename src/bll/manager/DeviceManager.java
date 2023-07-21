package bll.manager;

import bll.be.Device;
import bll.manager.interfaces.IDeviceManager;
import dal.DeviceDAO;
import dal.interfaces.IDeviceDAO;
import dal.mapper.DeviceMapper;

import java.util.List;

public class DeviceManager implements IDeviceManager {
    private IDeviceDAO deviceDAO;
    public DeviceManager(){
        deviceDAO = new DeviceDAO();
    }
    @Override
    public List<Device> getAllDevicesForProject(String refNumber) {
        return deviceDAO.getAllDevicesForProject(refNumber);
    }

    @Override
    public Device getDeviceByID(String refNumber, int id) {
        return deviceDAO.getDeviceByID(refNumber, id);
    }

    @Override
    public Device getDeviceByName(String refNumber, String name) {
        return deviceDAO.getDeviceByName(refNumber, name);
    }

    @Override
    public Boolean createDevice(Device device) {
        return deviceDAO.createDevice(device);
    }

    @Override
    public Boolean updateDevice(Device device) {
        return deviceDAO.updateDevice(device);
    }

    @Override
    public Boolean removeDevice(int id) {
        return deviceDAO.removeDevice(id);
    }
}
