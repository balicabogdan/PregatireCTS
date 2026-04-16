package cts.nume.prenume.g1092.singleton;

import cts.nume.prenume.g1092.factory.ISmartDevice;

import java.util.ArrayList;
import java.util.List;

public class EnergyConsumptionManager implements IEnergyConsumptionManager{
    private static final EnergyConsumptionManager instantaUnica = new EnergyConsumptionManager();

    private float maxAllowedConsumption;
    private float currentConsumption;
    private List<String> operationHistory; // Istoricul operațiilor
    private List<ISmartDevice> activeDevices;


    private EnergyConsumptionManager() {
        this.maxAllowedConsumption = 5000.0f; // Un prag maxim ales de noi
        this.currentConsumption = 0.0f;
        this.operationHistory = new ArrayList<>();
        this.activeDevices = new ArrayList<>();
    }

    public static EnergyConsumptionManager getInstance(){
        return  instantaUnica;
    }

    @Override
    public void addDevice(ISmartDevice device) throws Exception {
        // Validăm dacă se depășește consumul [1]
        if (this.currentConsumption + device.getPowerConsumption() > this.maxAllowedConsumption) {
            throw new Exception("Eroare: Adăugarea dispozitivului depășește pragul maxim de consum!");
        }

        // Dacă e ok, îl adăugăm și actualizăm istoricul
        activeDevices.add(device);
        this.currentConsumption += device.getPowerConsumption();
        device.turnOn(); // Îl activăm logic

        operationHistory.add("ACTIVARE: " + device.getDeviceName() + " (Consum: " + device.getPowerConsumption() + "W)");
    }

    @Override
    public void removeDevice(ISmartDevice device) throws Exception {
        if (activeDevices.contains(device)) {
            activeDevices.remove(device);
            this.currentConsumption -= device.getPowerConsumption();
            device.turnOff();

            operationHistory.add("DEZACTIVARE: " + device.getDeviceName());
        } else {
            throw new Exception("Dispozitivul nu este activ!");
        }
    }

    @Override
    public float getCurrentConsumption() {
        return this.currentConsumption;
    }

    @Override
    public float getMaxAllowedConsumption() {
        return this.maxAllowedConsumption;
    }

    @Override
    public void displayOperationHistory() {
        System.out.println("--- Istoric Operatii ---");
        for (String op : operationHistory) {
            System.out.println(op);
        }
    }
}
