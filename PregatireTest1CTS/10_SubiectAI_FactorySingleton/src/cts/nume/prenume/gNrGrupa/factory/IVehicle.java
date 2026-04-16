package cts.nume.prenume.gNrGrupa.factory;

public interface IVehicle {
    String getVehicleId();
    String getVehicleType();
    int getBatteryLevel();
    boolean isInUse();
    void unlockVehicle();
    void lockVehicle();
    void executeSpecificFunction();
}