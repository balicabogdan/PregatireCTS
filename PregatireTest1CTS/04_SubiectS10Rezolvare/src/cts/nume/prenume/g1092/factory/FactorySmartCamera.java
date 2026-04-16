package cts.nume.prenume.g1092.factory;

public class FactorySmartCamera implements ISmartDeviceFactory {
    @Override
    public ISmartDevice createDevice() {
        return new SmartCamera();
    }
}
