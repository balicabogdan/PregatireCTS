package designPatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class MeniuRestaurant {
    private List<OfertaMeniu> listaMeniuri = new ArrayList<>();

    // ROMBUL de pe diagrama: Contextul detine o referinta catre interfata
    private IProcesabil strategieAlegere;

    public void adaugaOferta(OfertaMeniu oferta) {
        listaMeniuri.add(oferta);
    }

    // Metoda esentiala pentru pattern-ul Strategy
    public void setStrategieAlegere(IProcesabil strategie) {
        this.strategieAlegere = strategie;
    }

    // Metoda prin care ospatarul ii gaseste clientului meniul ideal
    public OfertaMeniu obtineMeniuIdeal() {
        if(strategieAlegere != null) {
            return strategieAlegere.alegereMeniu(listaMeniuri);
        } else {
            throw new RuntimeException("Nu a fost setata nicio strategie!");
        }
    }
}

