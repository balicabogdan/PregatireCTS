package cts.nume.prenume.g1092.factory;

public class SmartCamera implements ISmartDevice {
    private boolean active = false;

    @Override
    public String getDeviceName() { return "Cam Living"; }

    @Override
    public String getDeviceType() { return "Iluminat"; }

    @Override
    public float getPowerConsumption() { return 5.7f; } // Consumă 15.5 Wați

    @Override
    public boolean isActive() { return active; }

    @Override
    public void turnOn() { this.active = true; }

    @Override
    public void turnOff() { this.active = false; }

    @Override
    public void executeSpecificFunction() {
        System.out.println("Cam și-a schimbat culoarea în albastru.");
    }
}
