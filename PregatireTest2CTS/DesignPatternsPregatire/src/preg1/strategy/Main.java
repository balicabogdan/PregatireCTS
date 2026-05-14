package preg1.strategy;

import java.util.ArrayList;
import java.util.List;

// =======================================================
// 1. CLASA DE DATE (Ce informatii procesam)
// =======================================================
class OfertaMeniu {
    private String denumireMeniu;
    private int nrCalorii;
    private int nrCarbohidrati;

    public OfertaMeniu(String denumire, int calorii, int carbohidrati) {
        this.denumireMeniu = denumire;
        this.nrCalorii = calorii;
        this.nrCarbohidrati = carbohidrati;
    }

    public String getDenumire() { return denumireMeniu; }
    public int getCalorii() { return nrCalorii; }
    public int getCarbohidrati() { return nrCarbohidrati; }
}

// =======================================================
// 2. INTERFAȚA STRATEGY (Șablonul general)
// =======================================================
interface IProcesabil {
    // Returneaza oferta potrivita dintr-o lista, in functie de o logica
    OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri);
}

// =======================================================
// 3. STRATEGIILE CONCRETE (Fiecare face un singur lucru)
// =======================================================
// Strategia 1: Cauta meniul cu cele mai putine calorii
class StrategieCaloriiMinim implements IProcesabil {
    @Override
    public OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri) {
        OfertaMeniu minim = listaMeniuri.get(0);
        for(OfertaMeniu oferta : listaMeniuri) {
            if(oferta.getCalorii() < minim.getCalorii()) {
                minim = oferta;
            }
        }
        return minim;
    }
}

// Strategia 2: Cauta meniul cu cei mai putini carbohidrati
class StrategieCarbohidratiMinim implements IProcesabil {
    @Override
    public OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri) {
        OfertaMeniu minim = listaMeniuri.get(0);
        for(OfertaMeniu oferta : listaMeniuri) {
            if(oferta.getCarbohidrati() < minim.getCarbohidrati()) {
                minim = oferta;
            }
        }
        return minim;
    }
}

// =======================================================
// 4. CONTEXTUL (Clasa care deține și schimbă strategia)
// =======================================================
class MeniuRestaurant {
    private List<OfertaMeniu> listaMeniuri = new ArrayList<>();

    // ROMBUL NEGRU: Contextul detine o referinta catre interfata
    private IProcesabil strategieAlegere;

    public void adaugaOferta(OfertaMeniu oferta) {
        listaMeniuri.add(oferta);
    }

    // METODA CHEIE a acestui pattern: Permite schimbarea din mers!
    public void setStrategieAlegere(IProcesabil strategie) {
        this.strategieAlegere = strategie;
    }

    // Metoda de actiune
    public OfertaMeniu obtineMeniuIdeal() {
        if(strategieAlegere != null) {
            // Executam strategia setata de client
            return strategieAlegere.alegereMeniu(listaMeniuri);
        } else {
            throw new RuntimeException("Nu a fost setata nicio strategie!");
        }
    }
}

// =======================================================
// 5. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Recomandare Meniu ---");

        MeniuRestaurant restaurant = new MeniuRestaurant();
        restaurant.adaugaOferta(new OfertaMeniu("Salata Caesar", 150, 10));
        restaurant.adaugaOferta(new OfertaMeniu("Burger Dublu", 800, 50));
        restaurant.adaugaOferta(new OfertaMeniu("Piept Pui cu Legume", 300, 5));

        // Client 1 vrea sa isi seteze strategia pe "Calorii Minime"
        restaurant.setStrategieAlegere(new StrategieCaloriiMinim());
        OfertaMeniu recomandare1 = restaurant.obtineMeniuIdeal();
        System.out.println("Recomandare Calorii Minime: " + recomandare1.getDenumire());

        // Client 2 se razgandeste si schimba strategia pe "Carbohidrati Minimi"
        restaurant.setStrategieAlegere(new StrategieCarbohidratiMinim());
        OfertaMeniu recomandare2 = restaurant.obtineMeniuIdeal();
        System.out.println("Recomandare Carbohidrati Minimi: " + recomandare2.getDenumire());
    }
}
