// Room.java - Room class using composition
package oops;

import java.util.ArrayList;
import java.util.List;

// COMPOSITION: Room HAS-A controller and devices
public class Room {
    private String roomName;
    private DeviceController controller;
    private List<SmartDevice> devices;
    
    public Room(String roomName, String controllerId) {
        this.roomName = roomName;
        this.controller = new LivingRoomController(controllerId);
        this.devices = new ArrayList<>();
    }
    
    public void addDevice(SmartDevice device) {
        devices.add(device);
        controller.addDevice(device);
        System.out.println("Added " + device.getDeviceName() + " to " + roomName);
    }
    
    public void displayRoomStatus() {
        System.out.println("\n=== " + roomName.toUpperCase() + " STATUS ===");
        System.out.println("Total devices: " + devices.size());
        System.out.println("Total power usage: " + controller.getTotalPowerUsage() + "W");
        
        for(SmartDevice device : devices) {
            System.out.println("  - " + device.getStatus());
        }
    }
    
    public void activateSmartMode() {
        System.out.println("\n💡 Activating smart mode in " + roomName);
        controller.performAutoAction();
    }
    
    public double getPowerUsage() {
        return controller.getTotalPowerUsage();
    }
}