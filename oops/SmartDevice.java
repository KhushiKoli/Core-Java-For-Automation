package oops;

//SmartDevice.java - Base class and device implementations


public abstract class SmartDevice {
 // ENCAPSULATION: Private fields
 private String deviceId;
 private String deviceName;
 private boolean isPoweredOn;
 private double powerConsumption;
 
 // Constructor
 public SmartDevice(String deviceId, String deviceName, double powerConsumption) {
     this.deviceId = deviceId;
     this.deviceName = deviceName;
     this.powerConsumption = powerConsumption;
     this.isPoweredOn = false;
 }
 
 // ENCAPSULATION: Controlled access
 public String getDeviceId() { return deviceId; }
 public String getDeviceName() { return deviceName; }
 public boolean isPoweredOn() { return isPoweredOn; }
 
 public void togglePower() {
     isPoweredOn = !isPoweredOn;
     System.out.println(deviceName + " turned " + (isPoweredOn ? "ON" : "OFF"));
 }
 
 public double getPowerUsage() {
     return isPoweredOn ? powerConsumption : 0;
 }
 
 // POLYMORPHISM: To be overridden
 public String getStatus() {
     return deviceName + " [" + deviceId + "]: " + 
            (isPoweredOn ? "ON" : "OFF") + " (" + getPowerUsage() + "W)";
 }
}

//INHERITANCE: SmartLight extends SmartDevice
class SmartLight extends SmartDevice {
 private int brightness; // 0-100%
 private String color;
 
 public SmartLight(String deviceId, String name) {
     super(deviceId, name, 15.0);
     this.brightness = 50;
     this.color = "White";
 }
 
 // POLYMORPHISM: Override parent method
 @Override
 public String getStatus() {
     return super.getStatus() + 
            " | Brightness: " + brightness + "% | Color: " + color;
 }
 
 public void setBrightness(int level) {
     if(level >= 0 && level <= 100) {
         brightness = level;
         System.out.println(getDeviceName() + " brightness set to " + level + "%");
     }
 }
 
 public void setColor(String newColor) {
     color = newColor;
     System.out.println(getDeviceName() + " color changed to " + newColor);
 }
}

//INHERITANCE: SmartThermostat extends SmartDevice
class SmartThermostat extends SmartDevice {
 private double currentTemp;
 private double targetTemp;
 
 public SmartThermostat(String deviceId, String name) {
     super(deviceId, name, 50.0);
     this.currentTemp = 22.0;
     this.targetTemp = 22.0;
 }
 
 @Override
 public String getStatus() {
     return super.getStatus() + 
            " | Current: " + currentTemp + "°C | Target: " + targetTemp + "°C";
 }
 
 public void setTemperature(double temp) {
     targetTemp = temp;
     System.out.println("Thermostat target set to " + temp + "°C");
     
     if(targetTemp > currentTemp) {
         System.out.println("🔥 Heating...");
     } else if(targetTemp < currentTemp) {
         System.out.println("❄️ Cooling...");
     }
     currentTemp = targetTemp;
 }
}
