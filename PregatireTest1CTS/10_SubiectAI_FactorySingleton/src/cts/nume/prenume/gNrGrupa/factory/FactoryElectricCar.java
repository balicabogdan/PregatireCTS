package cts.nume.prenume.gNrGrupa.factory;

public class FactoryElectricCar implements IVehicleFactory{
    @Override
    public IVehicle createVehicle() {
        return new ElectricCar();
    }
}
