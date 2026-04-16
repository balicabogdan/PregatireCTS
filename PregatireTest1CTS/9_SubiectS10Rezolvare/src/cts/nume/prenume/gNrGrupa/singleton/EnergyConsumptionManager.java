package cts.nume.prenume.gNrGrupa.singleton;

import cts.nume.prenume.gNrGrupa.factory.ISmartDevice;

import java.util.ArrayList;
import java.util.List;

public class EnergyConsumptionManager implements IEnergyConsumptionManager{
    private static final EnergyConsumptionManager uniqueInstance = new EnergyConsumptionManager();

    private float currentConsumption;
    private float maxAllowedConsumption;
    private List<String> operationHistory;

    private EnergyConsumptionManager(){
        this.currentConsumption = 0f;
        this.maxAllowedConsumption = 400f;
        this.operationHistory = new ArrayList<>();
    }

    public static EnergyConsumptionManager getInstance(){
        return uniqueInstance;
    }

    @Override
    public void addDevice(ISmartDevice device) throws Exception {
        // Ieșire rapidă prin excepție dacă pragul este depășit
        if (this.currentConsumption + device.getPowerConsumption() > this.maxAllowedConsumption) {
            throw new Exception("EROARE CRITICĂ: Activarea dispozitivului " + device.getDeviceName() + " depășește pragul maxim de " + maxAllowedConsumption + "W!");
        }

        device.turnOn();
        this.currentConsumption += device.getPowerConsumption();
        this.operationHistory.add("ACTIVARE: " + device.getDeviceName() + " (" + device.getPowerConsumption() + "W)");
    }

    @Override
    public void removeDevice(ISmartDevice device) throws Exception {
        if (!device.isActive()) {
            throw new Exception("Dispozitivul " + device.getDeviceName() + " este deja oprit!");
        }

        device.turnOff();
        this.currentConsumption -= device.getPowerConsumption();
        this.operationHistory.add("DEZACTIVARE: " + device.getDeviceName());
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
        System.out.println("=== ISTORIC OPERAȚIUNI SMART HOME ===");
        for (String op : operationHistory) {
            System.out.println(op);
        }
    }
}
