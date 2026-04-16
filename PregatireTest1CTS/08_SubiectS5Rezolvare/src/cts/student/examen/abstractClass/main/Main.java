package cts.student.examen.abstractClass.main;

import cts.student.examen.abstractClass.prototype.AbstractProductionItem;
import cts.student.examen.abstractClass.prototype.ProdusTableta;
import cts.student.examen.abstractClass.prototype.ProdusTelefon;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TESTARE PROTOTYPE (Cu Clasă Abstractă) ===");

        // 1. Crearea prototipurilor inițiale (Se va afișa mesajul de încărcare din BD) [9]
        AbstractProductionItem prototipTelefon = new ProdusTelefon();
        AbstractProductionItem prototipTableta = new ProdusTableta();

        // 2. Clonarea prototipului (Aici NU se va mai afișa mesajul de încărcare) [9]
        AbstractProductionItem clonaTelefon1 = (AbstractProductionItem) prototipTelefon.clone();
        AbstractProductionItem clonaTelefon2 = (AbstractProductionItem) prototipTelefon.clone();

        // 3. Particularizarea clonei [8]
        clonaTelefon1.setSerialCode("SN-TEL-001");
        clonaTelefon1.setBatchLabel("Lot-A");
        clonaTelefon1.addComponenta("Folie Sticla"); // Adăugăm doar la clona 1

        clonaTelefon2.setSerialCode("SN-TEL-002");
        clonaTelefon2.setBatchLabel("Lot-B");

        // 4. Afisarea demonstrează că prototipul original NU are folie de sticlă
        System.out.println("\nPrototipul original a ramas intact:");
        prototipTelefon.displayInfo();

        System.out.println("\nClonele particularizate:");
        clonaTelefon1.displayInfo();
        clonaTelefon2.displayInfo();
    }
}
