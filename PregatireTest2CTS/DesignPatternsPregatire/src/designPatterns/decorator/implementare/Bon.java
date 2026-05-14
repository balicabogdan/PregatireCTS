package designPatterns.decorator.implementare;

import java.util.ArrayList;
import java.util.List;


/*
Pasul 2: Clasa concretă de bază (ConcreteComponent) Asta e implementarea existentă,
bonul simplu. Nu avem voie să modificăm clasa asta pentru a adăuga reducerea, ea doar adună prețurile!
 */
public class Bon implements IBon {
    private List<Float> produse = new ArrayList<>();
    private int id;

    public Bon(int id) {
        this.id = id;
    }

    @Override
    public void adaugaProdus(float pret) {
        produse.add(pret);
    }

    @Override
    public float getTotal() {
        float total = 0;
        for(Float p : produse) {
            total += p;
        }
        return total;
    }

    @Override
    public void printare() {
        System.out.println("Bonul " + id + " a fost printat.");
    }
}
