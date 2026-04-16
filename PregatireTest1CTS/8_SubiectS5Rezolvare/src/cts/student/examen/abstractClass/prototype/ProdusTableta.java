package cts.student.examen.abstractClass.prototype;

import java.util.ArrayList;

public class ProdusTableta extends AbstractProductionItem {

    public ProdusTableta() {
        System.out.println("Incarcare reteta Tableta din BD... dureaza!");
        this.modelName = "Tableta-Pro";
        this.componente = new ArrayList<>();
        this.componente.add("Ecran 10 inch LCD");
    }

    @Override
    public void displayInfo() {
        System.out.println("Produs: " + modelName + " (Serial: " + serialCode + ") | Lot: " + batchLabel + " | Componente: " + componente);
    }
}