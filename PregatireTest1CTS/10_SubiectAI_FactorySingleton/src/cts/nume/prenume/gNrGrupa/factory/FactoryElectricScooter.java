package cts.nume.prenume.gNrGrupa.factory;

public class FactoryElectricScooter implements IVehicleFactory{
    @Override
    public IVehicle createVehicle() {
        return new ElectricScooter();
    }
}
