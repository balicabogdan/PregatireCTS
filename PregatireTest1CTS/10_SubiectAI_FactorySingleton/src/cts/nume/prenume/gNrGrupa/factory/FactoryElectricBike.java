package cts.nume.prenume.gNrGrupa.factory;

public class FactoryElectricBike implements IVehicleFactory{
    @Override
    public IVehicle createVehicle() {
        return new ElectricBike();
    }
}
