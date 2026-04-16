package factory;

public class SmartLightFactory implements ISmartDeviceFactory{
    @Override
    public ISmartDevice createDevice() {
        return new SmartLight();
    }
}
