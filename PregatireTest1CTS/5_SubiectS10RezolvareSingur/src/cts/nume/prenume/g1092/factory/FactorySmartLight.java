package cts.nume.prenume.g1092.factory;

public class FactorySmartLight implements ISmartDeviceFactory{
    @Override
    public ISmartDevice createDevice() {
        return new SmartLight();
    }
}
