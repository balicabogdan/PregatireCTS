package cts.nume.prenume.gNrGrupa.factory;

public class SmartLight implements ISmartDevice{
    private boolean active = false;

    @Override public String getDeviceName() { return "Bec Living"; }
    @Override public String getDeviceType() { return "Iluminat"; }
    @Override public float getPowerConsumption() { return 100.0f; } // Consumă 100W
    @Override public boolean isActive() { return active; }

    @Override public void turnOn() { this.active = true; }
    @Override public void turnOff() { this.active = false; }
    @Override public void executeSpecificFunction() { System.out.println("SmartLight: Schimbă culoarea ambientală."); }
}
