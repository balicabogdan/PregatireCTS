package cts.nume.prenume.gNrGrupa.singleton;

import cts.nume.prenume.gNrGrupa.factory.IVehicle;

public interface IFleetManager {
    void startRide(IVehicle vehicle) throws Exception;
    void endRide(IVehicle vehicle) throws Exception;
    int getActiveRidesCount();
    int getMaxAllowedRides();
    void displayFleetHistory();
}