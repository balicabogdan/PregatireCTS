package verificare.ex4_observer;

import java.util.ArrayList;
import java.util.List;

class ServiciuMeteo implements ISubject {
    private String oras;
    private float temperaturaCurenta;

    // Lista esențială pentru Observer: reține toți abonații
    private List<IObserver> listaAbonati = new ArrayList<>();

    public ServiciuMeteo(String oras, float temperaturaInitiala) {
        this.oras = oras;
        this.temperaturaCurenta = temperaturaInitiala;
    }

    @Override
    public void adaugaObserver(IObserver observer) {
        listaAbonati.add(observer);
    }

    @Override
    public void eliminaObserver(IObserver observer) {
        listaAbonati.remove(observer);
    }

    @Override
    public void notificaAbonati() {
        System.out.println("--- [Sistem Meteo " + oras + "] Trimitem actualizări către " + listaAbonati.size() + " abonați... ---");
        // Parcurgem lista și trimitem fiecăruia noua temperatură
        for (IObserver obs : listaAbonati) {
            obs.getNotificare(this.temperaturaCurenta);
        }
    }

    // Metoda de business care preia senzorii
    public void setTemperatura(float temperaturaNoua) {
        // Dacă temperatura s-a modificat, o actualizăm și declanșăm automat notificările!
        if (this.temperaturaCurenta != temperaturaNoua) {
            this.temperaturaCurenta = temperaturaNoua;

            notificaAbonati(); // Magia pattern-ului: toți primesc SMS-ul simultan
        }
    }
}
