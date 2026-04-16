package cts.nume.prenume.gNrGrupa.factory;

public interface ISmartDevice {
    String getDeviceName();
    String getDeviceType();
    float getPowerConsumption();
    boolean isActive();
    void turnOn();
    void turnOff();
    void executeSpecificFunction();
}