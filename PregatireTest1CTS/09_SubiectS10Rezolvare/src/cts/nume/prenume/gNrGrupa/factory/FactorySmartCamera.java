package cts.nume.prenume.gNrGrupa.factory;

public class FactorySmartCamera implements ISmartDeviceFactory {
    @Override
    public ISmartDevice createDevice() {
        return new SmartCamera();
    }
}
