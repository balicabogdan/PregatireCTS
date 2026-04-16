package cts.student.examen.abstractClass.prototype;

import cts.student.examen.abstractClass.prototype.AbstractProductionItem;

import java.util.ArrayList;

// Clasa concretă 1 [4, 6]
public class ProdusTelefon extends AbstractProductionItem {

    public ProdusTelefon() {
        System.out.println("Incarcare reteta Telefon din BD... dureaza!");
        this.modelName = "Telefon-Basic";
        this.componente = new ArrayList<>();
        this.componente.add("Ecran OLED");
        this.componente.add("Baterie 4000mAh");
    }

    @Override
    public void displayInfo() {
        System.out.println("Produs: " + modelName + " (Serial: " + serialCode + ") | Lot: " + batchLabel + " | Componente: " + componente);
    }
}