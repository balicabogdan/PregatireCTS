package cts.student.examen.g1092.main;

import cts.student.examen.g1092.prototype.Item;
import cts.student.examen.g1092.singleton.ProductionLine;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTARE SINGLETON (Control Linie Productie) ===");
        try {
            ProductionLine manager = ProductionLine.getInstance();

            // 1. Angajatul 1 initiază sesiunea [2]
            manager.startLine("EMP-001");

            // 2. Angajatul 1 face 2 modificări valide
            manager.setWorkingSpeed("EMP-001", 150);
            manager.setOperatingMode("EMP-001", "Automat");

            // 3. Un AL DOILEA angajat încearcă să modifice linia rezervată (forțăm excepția!) [2]
            System.out.println("\n-- Angajatul 2 incearca o modificare (Asteptam eroare) --");
            manager.setWorkingSpeed("EMP-002", 200); // Va arunca exceptie aici!

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // La final, Angajatul 1 eliberează linia (într-un bloc try separat ca să continue programul)
        try {
            ProductionLine.getInstance().stopLine("EMP-001");
        } catch (Exception e) {}


        System.out.println("\n=== TESTARE PROTOTYPE (Clonare Produse) ===");

        // 1. Definirea a 2 prototipuri diferite (Cerinta testare) [3]
        Item prototipTelefon = new Item("Telefon-Basic");
        prototipTelefon.addComponenta("Ecran LED");
        prototipTelefon.addComponenta("Baterie 3000mAh");

        Item prototipTableta = new Item("Tableta-Pro");
        prototipTableta.addComponenta("Ecran 10 inch");

        // 2. Clonarea unui prototip de cel putin 2 ori [3]
        Item clona1 = (Item) prototipTelefon.clone();
        Item clona2 = (Item) prototipTelefon.clone();

        // 3. Particularizarea clonei 1 și 2 [3]
        clona1.setSerialCode("SN-TEL-001");
        clona1.setBatchLabel("Lot-A");
        clona1.setPackagingType("Cutie Premium");
        clona1.addComponenta("Folie Sticla"); // Adaugam doar la clona 1

        clona2.setSerialCode("SN-TEL-002");
        clona2.setBatchLabel("Lot-B");
        clona2.setPackagingType("Cutie Standard");

        // 4. Demonstrarea faptului că prototipul inițial rămâne nemodificat (Deep Copy a funcționat) [3]
        System.out.println("\nPrototipul original a ramas (fara serial si folie):");
        prototipTelefon.displayInfo();

        System.out.println("\nClonele particularizate sunt:");
        clona1.displayInfo();
        clona2.displayInfo();
    }
}
