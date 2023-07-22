package pl.model;

import bll.be.Device;
import bll.manager.DeviceManager;

import java.util.ArrayList;
import java.util.List;

public class DeviceModel {
    //TODO  createDevices, etc.
    private List<Device> newDevices;
    private DeviceManager deviceManager;

    public DeviceModel() {
        deviceManager = new DeviceManager();
        newDevices = new ArrayList<>();
    }

    List<Device> getAllDevicesForProject(String refNumber) {
        return deviceManager.getAllDevicesForProject(refNumber);
    }

    Device getDeviceByID(String refNumber, int id) {
        return deviceManager.getDeviceByID(refNumber, id);
    }

    Device getDeviceByName(String refNumber, String name) {
        return deviceManager.getDeviceByName(refNumber, name);
    }

    Boolean createDevice(Device device) {
        return deviceManager.createDevice(device);
    }

    Boolean updateDevice(Device device) {
        return updateDevice(device);
    }

    Boolean removeDevice(int id) {
        return deviceManager.removeDevice(id);
    }
}
