package verificare.Subiect1Seminar.strategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IProdus> produse = new ArrayList<>();
        produse.add(new Produs("Mouse", 350.0, 0));
        produse.add(new Produs("Tastatura", 300.0, 5));
        Utilizator utilizator = new Utilizator("Ion");
        utilizator.setStrat(new VizualizareCrescator());
        utilizator.afiseazaProd(produse);
    }
}
