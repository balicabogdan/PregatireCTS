package factory;

public class SmartLight implements ISmartDevice{
    @Override
    public String getDeviceName() {
        return "";
    }

    @Override
    public String getDeviceType() {
        return "";
    }

    @Override
    public float getPowerConsumption() {
        return 0;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }

    @Override
    public void executeSpecificFunction() {

    }
}
