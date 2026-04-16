package cts.nume.prenume.g1092.factory;

public class FactorySmartThermostat implements ISmartDeviceFactory {
    @Override
    public ISmartDevice createDevice() {
        return new SmartThermostat();
    }
}
