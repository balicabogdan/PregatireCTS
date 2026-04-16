package cts.nume.prenume.g1092.predefinit;

import cts.nume.prenume.g1092.factory.*;
import cts.nume.prenume.g1092.singleton.EnergyConsumptionManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            // 1. Obținem Managerul Unic (Singleton)
            EnergyConsumptionManager manager = EnergyConsumptionManager.getInstance();
            System.out.println("Prag maxim: " + manager.getMaxAllowedConsumption() + "W");

            // 2. Creăm cele 3 dispozitive folosind FACTORY METHOD
            ISmartDeviceFactory factoryBec = new FactorySmartLight();
            ISmartDevice bec = factoryBec.createDevice();

            ISmartDeviceFactory factoryTermostat = new FactorySmartThermostat();
            ISmartDevice termostat = factoryTermostat.createDevice();

            ISmartDeviceFactory factoryCamera = new FactorySmartCamera();
            ISmartDevice camera = factoryCamera.createDevice();

            // 3. Apelăm funcții specifice (Cerință testare)
            bec.executeSpecificFunction();
            termostat.executeSpecificFunction();

            // 4. Integrăm cel puțin 2 dispozitive în manager
            manager.addDevice(bec);
            manager.addDevice(termostat);

            System.out.println("Consum total curent: " + manager.getCurrentConsumption() + "W");

            // 5. Afișăm istoricul (Cerință testare)
            manager.displayOperationHistory();

            // 6. Generăm o excepție intenționat: Adăugăm un dispozitiv care consumă imens
            // Presupunem că am face o clasă care consumă 6000W, peste limita de 5000W.
            // manager.addDevice(dispozitivUrias);


            /*
            //            -----------------TESTARE FARA FACTORY--------------
            EnergyConsumptionManager manager = EnergyConsumptionManager.getInstance();
            ISmartDevice cam = new SmartCamera();
            manager.addDevice(cam);

            ISmartDevice light = new SmartLight();
            manager.addDevice(light);

            System.out.println(manager.getCurrentConsumption());
//            -----------------TESTARE FACTORY--------------
            ISmartDeviceFactory factoryBec = new FactorySmartLight();
            ISmartDevice bec = factoryBec.createDevice();

            bec.executeSpecificFunction();
            manager.addDevice(bec);

            System.out.println("CONSUM: " + manager.getCurrentConsumption());
            manager.displayOperationHistory();
             */

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}