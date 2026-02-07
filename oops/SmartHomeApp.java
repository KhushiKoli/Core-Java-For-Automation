// SmartHomeApp.java - Main application with utilities
package oops;

// Custom Exception
class DeviceNotFoundException extends Exception {
    public DeviceNotFoundException(String message) {
        super(message);
    }
}

// Static Utility Class
class HomeUtils {
    public static final double ELECTRICITY_RATE = 0.15; // $ per kWh
    private static int totalDevices = 0;
    
    public static void incrementDeviceCount() {
        totalDevices++;
    }
    
    public static int getTotalDevices() {
        return totalDevices;
    }
    
    public static double calculateCost(double watts, int hours) {
        double kWh = (watts * hours) / 1000;
        return kWh * ELECTRICITY_RATE;
    }
}

// MAIN APPLICATION
public class SmartHomeApp {
    public static void main(String[] args) {
        System.out.println("=== 🏠 SMART HOME SYSTEM ===\n");
        
        // Create rooms
        Room livingRoom = new Room("Living Room", "CTRL-LIVING");
        Room bedroom = new Room("Bedroom", "CTRL-BED");
        
        // Create devices
        SmartLight mainLight = new SmartLight("LIGHT-001", "Main Light");
        SmartLight readingLamp = new SmartLight("LIGHT-002", "Reading Lamp");
        SmartThermostat thermostat = new SmartThermostat("THERM-001", "Thermostat");
        
        HomeUtils.incrementDeviceCount();
        HomeUtils.incrementDeviceCount();
        HomeUtils.incrementDeviceCount();
        
        // Add devices to rooms
        livingRoom.addDevice(mainLight);
        livingRoom.addDevice(thermostat);
        bedroom.addDevice(readingLamp);
        
        // Control devices
        System.out.println("\n=== CONTROLLING DEVICES ===");
        mainLight.togglePower();
        mainLight.setBrightness(80);
        mainLight.setColor("Daylight");
        
        thermostat.togglePower();
        thermostat.setTemperature(24.5);
        
        readingLamp.togglePower();
        readingLamp.setBrightness(60);
        
        // Display status
        System.out.println("\n=== ROOM STATUS ===");
        livingRoom.displayRoomStatus();
        bedroom.displayRoomStatus();
        
        // Smart automation
        System.out.println("\n=== SMART AUTOMATION ===");
        livingRoom.activateSmartMode();
        bedroom.activateSmartMode();
        
        // Energy calculations
        System.out.println("\n=== ENERGY REPORT ===");
        double totalWatts = livingRoom.getPowerUsage() + bedroom.getPowerUsage();
        System.out.println("Total power consumption: " + totalWatts + "W");
        
        double dailyCost = HomeUtils.calculateCost(totalWatts, 24);
        System.out.println("Estimated daily cost: $" + String.format("%.2f", dailyCost));
        
        // Exception handling demo
        System.out.println("\n=== SYSTEM CHECK ===");
        try {
            checkDevice(mainLight);
            checkDevice(readingLamp);
            System.out.println("✅ All devices operational");
        } catch (DeviceNotFoundException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
        
        // Summary
        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total smart devices: " + HomeUtils.getTotalDevices());
        System.out.println("Rooms configured: 2");
        System.out.println("System status: ACTIVE 🟢");
    }
    
    // Exception handling method
    static void checkDevice(SmartDevice device) throws DeviceNotFoundException {
        if(!device.isPoweredOn()) {
            throw new DeviceNotFoundException(
                device.getDeviceName() + " is offline - please check");
        }
    }
}