package cts.student.examen.g1092.prototypeAbstract;

import java.util.ArrayList;

public class ContractCorporate extends AbstractContract {

    public ContractCorporate() {
        System.out.println("Incarcare contract corporate din BD... dureaza!"); // Proces consumator de timp [5]
        this.tip = "corporate";
        this.listaClauze = new ArrayList<>();
        this.listaClauze.add("clauza 1 corporate");
        this.listaClauze.add("clauza 2 corporate");
    }

    @Override
    public void printare() {
        System.out.println("Contract de tip " + this.tip + " | Clauze: " + this.listaClauze); // [5]
    }
}
