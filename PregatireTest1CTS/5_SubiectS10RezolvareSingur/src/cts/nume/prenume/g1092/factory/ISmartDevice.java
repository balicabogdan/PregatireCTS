package cts.nume.prenume.g1092.factory;

public interface ISmartDevice {
    String getDeviceName();
    String getDeviceType();
    float getPowerConsumption();
    boolean isActive();
    void turnOn();
    void turnOff();
    void executeSpecificFunction();
}