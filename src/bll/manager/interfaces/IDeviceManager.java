package bll.manager.interfaces;

import bll.be.Device;

import java.util.List;

public interface IDeviceManager {
    List<Device> getAllDevicesForProject(String refNumber);
    Device getDeviceByID(String refNumber, int id);
    Device getDeviceByName(String refNumber, String name);
    Boolean createDevice(Device device);
    Boolean updateDevice(Device device);
    Boolean removeDevice(int id);
}
