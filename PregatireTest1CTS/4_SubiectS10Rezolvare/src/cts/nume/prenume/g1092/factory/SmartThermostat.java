package cts.nume.prenume.g1092.factory;

public class SmartThermostat implements ISmartDevice {
    private boolean active = false;

    @Override
    public String getDeviceName() { return "Term Living"; }

    @Override
    public String getDeviceType() { return "Iluminat"; }

    @Override
    public float getPowerConsumption() { return 20f; } // Consumă 15.5 Wați

    @Override
    public boolean isActive() { return active; }

    @Override
    public void turnOn() { this.active = true; }

    @Override
    public void turnOff() { this.active = false; }

    @Override
    public void executeSpecificFunction() {
        System.out.println("Term și-a schimbat culoarea în albastru.");
    }
}
