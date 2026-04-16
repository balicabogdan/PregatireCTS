package cts.nume.prenume.gNrGrupa.main;

import cts.nume.prenume.gNrGrupa.factory.*;
import cts.nume.prenume.gNrGrupa.singleton.FleetManager;

public class Main {
    public static void main(String[] args) {
        IVehicleFactory bikeFac = new FactoryElectricBike();
        IVehicle bike = bikeFac.createVehicle();


        IVehicleFactory fabricaMasini = new FactoryElectricCar();
        IVehicle masina = fabricaMasini.createVehicle();

        // 2. Apelarea funcțiilor specifice (demonstrează polimorfismul)
        bike.executeSpecificFunction();
        masina.executeSpecificFunction();

        try{
            FleetManager manager = FleetManager.getInstance();
            manager.startRide(bike);
            manager.startRide(masina);
            manager.endRide(bike);
            manager.startRide(masina);
            System.out.println(manager.getActiveRidesCount() + " din " + manager.getMaxAllowedRides());
            manager.startRide(masina);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        FleetManager.getInstance().displayFleetHistory();
    }
}