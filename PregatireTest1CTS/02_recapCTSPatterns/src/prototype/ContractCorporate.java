package prototype;

import java.util.ArrayList;

public class ContractCorporate extends AbstractContract {
    public ContractCorporate() {
        System.out.println("Incarcare contract din BD... Dureaza 5 secunde!");
        this.listaClauze = new ArrayList<>();
        this.listaClauze.add("Clauza 1: Confidentialitate");
        this.listaClauze.add("Clauza 2: Plati");
        this.tip = "Corporate";
    }

    private ContractCorporate(String tip) {
        this.tip = tip;
    }

    @Override
    public Object clone() {
        // Creăm obiectul nou gol folosind constructorul privat
        ContractCorporate clona = new ContractCorporate(this.tip);
        clona.id = this.id;

        // DEEP COPY OBLIGATORIU LA EXAMEN PENTRU LISTE:
        // Creăm o listă NOUĂ în memorie pentru clonă
        clona.listaClauze = new ArrayList<>();

        // Copiem manual fiecare element din lista originală în lista clonei
        for (String clauza : this.listaClauze) {
            clona.listaClauze.add(clauza);
        }

        return clona;
    }
}
