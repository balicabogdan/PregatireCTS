package verificare.Subiect1Seminar.strategy;

import java.util.List;

public class Utilizator {
    private String nume;
    private IStrategyViz strat;

    public Utilizator(String nume) {
        this.nume = nume;
    }

    public void setStrat(IStrategyViz strat){
        this.strat =strat;
    }

    public void afiseazaProd(List<IProdus> produse){
        if(strat!= null){
            System.out.println("Viz produse pentru: " + nume + ":");
            strat.vizualizare(produse);
        }
    }
}
