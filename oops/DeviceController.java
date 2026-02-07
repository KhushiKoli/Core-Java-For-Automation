package oops;

//DeviceController.java - Abstract controller and concrete implementation

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

//ABSTRACTION: Abstract controller
public abstract class DeviceController {
 protected String controllerId;
 protected List<SmartDevice> connectedDevices;
 
 public DeviceController(String controllerId) {
     this.controllerId = controllerId;
     this.connectedDevices = new ArrayList<>();
 }
 
 // Abstract method - must be implemented
 public abstract void performAutoAction();
 
 public void addDevice(SmartDevice device) {
     connectedDevices.add(device);
     System.out.println("Added device: " + device.getDeviceName());
 }
 
 public double getTotalPowerUsage() {
     double total = 0;
     for(SmartDevice device : connectedDevices) {
         total += device.getPowerUsage();
     }
     return total;
 }
 
 public void displayConnectedDevices() {
     System.out.println("Devices connected to " + controllerId + ":");
     for(SmartDevice device : connectedDevices) {
         System.out.println("  - " + device.getStatus());
     }
 }
}

//Concrete implementation
class LivingRoomController extends DeviceController {
 public LivingRoomController(String controllerId) {
     super(controllerId);
 }
 
 @Override
 public void performAutoAction() {
     System.out.println("🔄 " + controllerId + ": Performing smart actions...");
     
     Calendar calendar = Calendar.getInstance();
     int hour = calendar.get(Calendar.HOUR_OF_DAY);
     
     if(hour >= 18 && hour <= 22) {
         System.out.println("Evening mode: Adjusting lights for relaxation...");
         for(SmartDevice device : connectedDevices) {
             if(device instanceof SmartLight) {
                 SmartLight light = (SmartLight) device;
                 light.setBrightness(30);
                 light.setColor("Warm White");
             }
         }
     } else if(hour >= 6 && hour <= 9) {
         System.out.println("Morning mode: Bright lights for energy...");
         for(SmartDevice device : connectedDevices) {
             if(device instanceof SmartLight) {
                 SmartLight light = (SmartLight) device;
                 light.setBrightness(100);
                 light.setColor("Daylight");
             }
         }
     }
 }
}
