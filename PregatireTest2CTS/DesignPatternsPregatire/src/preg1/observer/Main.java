package preg1.observer;

import java.util.ArrayList;
import java.util.List;

// =======================================================
// 1. INTERFAȚA OBSERVER (Abonatul)
// =======================================================
interface IObserver {
    void getMesaj(String mesaj);
}

// =======================================================
// 2. OBSERVER CONCRET (Clientul care primeste notificarile)
// =======================================================
class Client implements IObserver {
    private String nume;

    public Client(String nume) {
        this.nume = nume;
    }

    @Override
    public void getMesaj(String mesaj) {
        System.out.println("[" + nume + "] Ai o notificare noua: " + mesaj);
    }
}

// =======================================================
// 3. INTERFAȚA SUBJECT (Canalul la care ne abonam)
// =======================================================
interface ISubiect {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyAll(String mesaj);
}

// =======================================================
// 4. SUBJECT CONCRET (Restaurantul care trimite ofertele)
// =======================================================
class Restaurant implements ISubiect {
    private String numeRestaurant;

    // Lista in care pastram toti abonatii (partea esentiala din pattern!)
    private List<IObserver> listaObservatori = new ArrayList<>();

    public Restaurant(String nume) {
        this.numeRestaurant = nume;
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
        // Parcurgem lista si trimitem mesajul fiecarui abonat in parte
        for (IObserver obs : listaObservatori) {
            obs.getMesaj(mesaj);
        }
    }

    // Metoda specifica restaurantului care declanseaza notificarea
    public void adaugaOferta(String oferta) {
        System.out.println("\n---> " + numeRestaurant + " a publicat o oferta noua: " + oferta);

        // Aici apelam notificarea in masa!
        notifyAll(oferta);
    }
}

// =======================================================
// 5. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Notificari Restaurant ---");

        // 1. Cream canalul (Restaurantul)
        Restaurant restaurant = new Restaurant("Trattoria Il Calcio");

        // 2. Cream abonatii (Clientii)
        IObserver client1 = new Client("Ion");
        IObserver client2 = new Client("Maria");
        IObserver client3 = new Client("Gigel");

        // 3. Abonam clientii la restaurant
        restaurant.addObserver(client1);
        restaurant.addObserver(client2);
        restaurant.addObserver(client3);

        // 4. Restaurantul adauga o oferta -> TOTI primesc mesajul!
        restaurant.adaugaOferta("1+1 Gratis la orice Pizza!");

        // 5. Un client se dezaboneaza
        System.out.println("\n[Sistem] Maria s-a dezabonat.");
        restaurant.removeObserver(client2);

        // 6. O noua oferta este adaugata -> Doar Ion si Gigel mai primesc!
        restaurant.adaugaOferta("Reducere 20% la Meniul Zilei!");
    }
}

