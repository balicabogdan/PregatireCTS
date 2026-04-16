package cts.nume.prenume.gNrGrupa.main;

import cts.nume.prenume.gNrGrupa.factory.*;
import cts.nume.prenume.gNrGrupa.singleton.EnergyConsumptionManager;

public class Main {
    public static void main(String[] args) {
        ISmartDeviceFactory factorybec = new SmartLightFactory();
        ISmartDevice bec = factorybec.createDevice();

        ISmartDeviceFactory factoryterm = new FactorySmartThermostat();
        ISmartDevice term = factoryterm.createDevice();

        ISmartDeviceFactory factorycam = new FactorySmartCamera();
        ISmartDevice cam = factorycam.createDevice();

        bec.executeSpecificFunction();
        term.executeSpecificFunction();
        cam.executeSpecificFunction();

        System.out.println("SINGLETON");
        try{
            EnergyConsumptionManager manager = EnergyConsumptionManager.getInstance();
            System.out.println(manager.getMaxAllowedConsumption());

            manager.addDevice(bec);
            manager.addDevice(term);
            manager.removeDevice(bec);
            System.out.println(manager.getCurrentConsumption());

            manager.addDevice(cam);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            EnergyConsumptionManager.getInstance().displayOperationHistory();
            System.out.println(EnergyConsumptionManager.getInstance().getCurrentConsumption());

        }


    }
}