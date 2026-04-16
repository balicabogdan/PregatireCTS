package cts.student.examen.g1092.main;

import cts.student.examen.g1092.builder.RobotBatteryPack;
import cts.student.examen.g1092.prototype.DeliveryRobot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTARE PROTOTYPE (Roboti) ===");

        // 1. Definirea a cel putin 2 prototipuri diferite (Cerinta testare)
        DeliveryRobot prototipUrban = new DeliveryRobot("Model-Urban");
        prototipUrban.addStandardRoute("Ruta Centru");
        prototipUrban.addStandardRoute("Ruta Nord");

        DeliveryRobot prototipRural = new DeliveryRobot("Model-Rural");
        prototipRural.addStandardRoute("Ruta Sat");

        // 2. Clonarea unui prototip de cel putin 2 ori
        DeliveryRobot clona1 = (DeliveryRobot) prototipUrban.clone();
        DeliveryRobot clona2 = (DeliveryRobot) prototipUrban.clone();

        // 3. Particularizarea unei clone
        clona1.setModel("Model-Urban-Personalizat");
        clona1.addStandardRoute("Ruta Speciala VIP");

        // 4. Demonstrarea faptului că prototipul inițial rămâne nemodificat (Deep Copy a funcționat)
        System.out.println("\nPrototipul original a ramas:");
        prototipUrban.displayRobotInfo();
        System.out.println("Clona 1 modificata este:");
        clona1.displayRobotInfo();


        System.out.println("\n=== TESTARE BUILDER (Baterii) ===");

        // 1. Un pachet configurat minimal (doar cele obligatorii)
        RobotBatteryPack baterieSimpla = new RobotBatteryPack.BatteryBuilder("Bat-Basic", 5000, 12.0f)
                .build();

        // 2. Un pachet cu exact 2 opțiuni suplimentare
        RobotBatteryPack baterieMedie = new RobotBatteryPack.BatteryBuilder("Bat-Medium", 7500, 24.0f)
                .setFastCharge(true)
                .setCooling(true)
                .build();

        // 3. Un pachet cu numărul maxim permis de opțiuni suplimentare
        RobotBatteryPack bateriePremium = new RobotBatteryPack.BatteryBuilder("Bat-Ultra", 10000, 48.0f)
                .setFastCharge(true)
                .setCooling(true)
                .setShockProtection(true)
                .setWireless(true)
                .setExtendedWarranty(true)
                .build();

        System.out.println(baterieSimpla);
        System.out.println(baterieMedie);
        System.out.println(bateriePremium);
    }
}
