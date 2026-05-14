package designPatterns.observer.implementare;

import java.util.ArrayList;
import java.util.List;

public class Restaurant implements ISubiect {
    private String numeRestaurant;
    // Lista in care tinem toti abonatii!
    private List<IObserver> listaObservatori;

    public Restaurant(String numeRestaurant) {
        this.numeRestaurant = numeRestaurant;
        this.listaObservatori = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        listaObservatori.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        listaObservatori.remove(observer);
    }

    @Override
    public void notifyAll(String mesaj) {
        // Parcurgem lista si anuntam fiecare abonat
        for (IObserver obs : listaObservatori) {
            obs.getMesaj(mesaj);
        }
    }

    // Metoda de business: cand adaugam o oferta, se declanseaza si notificarea automata
    public void adaugaOfertaNoua(String oferta) {
        System.out.println("\n-> Sistemul restaurantului inregistreaza oferta: " + oferta);
        // Aici apelam notificarea
        notifyAll("Oferta noua la " + this.numeRestaurant + "! " + oferta);
    }
}