package cts.nume.prenume.gNrGrupa.factory;

public class FactorySmartThermostat implements ISmartDeviceFactory {
    @Override
    public ISmartDevice createDevice() {
        return new SmartThermostat();
    }
}