package cts.nume.prenume.g1092.singleton;

import cts.nume.prenume.g1092.factory.ISmartDevice;

public interface IEnergyConsumptionManager {
    void addDevice(ISmartDevice device) throws Exception;
    void removeDevice(ISmartDevice device) throws Exception;
    float getCurrentConsumption(); //sum of all powerConsumptions if device is active
    float getMaxAllowedConsumption();
    void displayOperationHistory();
}