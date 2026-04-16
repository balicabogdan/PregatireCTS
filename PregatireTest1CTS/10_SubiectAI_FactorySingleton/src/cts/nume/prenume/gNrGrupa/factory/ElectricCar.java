package cts.nume.prenume.gNrGrupa.factory;

public class ElectricCar implements IVehicle{
    @Override
    public String getVehicleId() {
        return "";
    }

    @Override
    public String getVehicleType() {
        return "car";
    }

    @Override
    public int getBatteryLevel() {
        return 0;
    }

    @Override
    public boolean isInUse() {
        return false;
    }

    @Override
    public void unlockVehicle() {

    }

    @Override
    public void lockVehicle() {

    }

    @Override
    public void executeSpecificFunction() {
        System.out.println("vroom  car");

    }
}
