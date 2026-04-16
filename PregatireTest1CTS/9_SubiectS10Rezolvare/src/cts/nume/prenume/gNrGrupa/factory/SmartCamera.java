package cts.nume.prenume.gNrGrupa.factory;

public class SmartCamera implements ISmartDevice {
    private boolean active = false;

    @Override public String getDeviceName() { return "Cameră Exterior"; }
    @Override public String getDeviceType() { return "Securitate"; }
    @Override public float getPowerConsumption() { return 10000.0f; } // Consumă 3000W
    @Override public boolean isActive() { return active; }

    @Override public void turnOn() { this.active = true; }
    @Override public void turnOff() { this.active = false; }
    @Override public void executeSpecificFunction() { System.out.println("SmartCamera: Începe înregistrarea de noapte."); }
}
