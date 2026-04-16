package cts.nume.prenume.gNrGrupa.singleton;

import cts.nume.prenume.gNrGrupa.factory.IVehicle;

import java.util.ArrayList;
import java.util.List;

public class FleetManager implements IFleetManager{
    private static FleetManager instantaUnica = new FleetManager();

    private int activeRidesCount;
    private List<String> operationHistory;
    private int maxAllowedRides;


    private FleetManager() {
        this.activeRidesCount = 0; // Pornim cu 0 curse active
        this.operationHistory = new ArrayList<>();
        this.maxAllowedRides = 2;
    }

    public static FleetManager getInstance(){
        return instantaUnica;
    }

    @Override
    public void startRide(IVehicle vehicle) throws Exception {
        if (activeRidesCount >= maxAllowedRides) {
            throw new Exception("EROARE: Prag maxim atins!");
        }
        if (vehicle.isInUse()) {
            throw new Exception("EROARE: Vehiculul este deja în cursă!");
        }

        vehicle.unlockVehicle();

        // Doar creștem contorul
        activeRidesCount++;
        operationHistory.add("START: " + vehicle.getVehicleType());
    }

    @Override
    public void endRide(IVehicle vehicle) throws Exception {
        if (!vehicle.isInUse()) {
            throw new Exception("EROARE: Vehiculul nu este într-o cursă activă!");
        }

        vehicle.lockVehicle();

        // Doar scădem contorul
        activeRidesCount--;
        operationHistory.add("STOP: " + vehicle.getVehicleType());
    }

    @Override
    public int getActiveRidesCount() {
        // Returnăm direct numărul, fără să mai facem .size() pe vreo listă
        return activeRidesCount;
    }

    @Override
    public int getMaxAllowedRides() {
        return maxAllowedRides;
    }

    @Override
    public void displayFleetHistory() {
        System.out.println("\n=== ISTORIC OPERAȚIUNI FLOTĂ ===");
        for (String op : operationHistory) {
            System.out.println(op);
        }
    }
}
