package cts.nume.prenume.gNrGrupa.factory;

public class SmartThermostat implements ISmartDevice {
    private boolean active = false;

    @Override public String getDeviceName() { return "Termostat Centrală"; }
    @Override public String getDeviceType() { return "Climatizare"; }
    @Override public float getPowerConsumption() { return 200.0f; } // Consumă 2500W
    @Override public boolean isActive() { return active; }

    @Override public void turnOn() { this.active = true; }
    @Override public void turnOff() { this.active = false; }
    @Override public void executeSpecificFunction() { System.out.println("SmartThermostat: Setează temperatura la 22 de grade."); }
}