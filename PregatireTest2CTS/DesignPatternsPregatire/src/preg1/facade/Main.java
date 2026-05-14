package preg1.facade;

import java.util.ArrayList;

// =======================================================
// 1. SUBSISTEMUL COMPLEX (Clasele ascunse in spate)
// =======================================================

class Bucatar {
    private String nume;

    public Bucatar(String nume) {
        this.nume = nume;
    }

    public boolean verificaDisponibilitate(String data){
        return true;
    }

}

class GestiuneBucatari {
    private ArrayList<Bucatar> listaBucatari = new ArrayList<>();

    public void addBucatar(Bucatar bucatar){
        listaBucatari.add(bucatar);
    }
    public int getNrBucatari(){
        return listaBucatari.size();
    }
    public Bucatar getBucatar(int index){
        return listaBucatari.get(index);
    }
}

class Sala {
    private String denumire;
    private int capacitate;
    public Sala(String denumire, int capacitate) {
        this.denumire = denumire;
        this.capacitate = capacitate;
    }

    public boolean esteLibera(String data) {
        return true; // Logica simplificata
    }
}

class GestiuneSali {
    private ArrayList<Sala> listaSali = new ArrayList<>();

    public void adaugaSala(Sala s) { listaSali.add(s); }
    public int getNrSali() { return listaSali.size(); }
    public Sala getSala(int i) { return listaSali.get(i); }
}

// =======================================================
// 2. FACADE (Clasa care preia munca grea de pe umerii clientului)
// =======================================================
class FacadeRezervare {
    public static boolean verificaDisponibilitate(int nrBucatariNecesari, String data){
        GestiuneBucatari gestiuneBucatari = new GestiuneBucatari();
        gestiuneBucatari.addBucatar(new Bucatar("sef1"));
        gestiuneBucatari.addBucatar(new Bucatar("sef2"));
        int bucatariDisp = 0;
        for (int i = 0; i < gestiuneBucatari.getNrBucatari(); i++) {
            if(gestiuneBucatari.getBucatar(i).verificaDisponibilitate(data)){
                bucatariDisp++;
            }
        }

        GestiuneSali gestiuneSali = new GestiuneSali();
        gestiuneSali.adaugaSala(new Sala("Sala Mare", 100));

        boolean avemSalaLibera = false;
        for(int i = 0; i < gestiuneSali.getNrSali(); i++) {
            if(gestiuneSali.getSala(i).esteLibera(data)) {
                avemSalaLibera = true;
                break;
            }
        }

        return (bucatariDisp >= nrBucatariNecesari) && avemSalaLibera;
    }
}

// =======================================================
// 3. Testarea (Clasa publica principala / Clientul)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Rezervare Restaurant ---");

        // Managerul nu trebuie sa stie cum functioneaza GestiuneBucatari sau GestiuneSali.
        // El apeleaza o singura metoda simpla din Facade.
        boolean sePoateFaceRezervarea = FacadeRezervare.verificaDisponibilitate(2, "20-Mai");

        if (sePoateFaceRezervarea) {
            System.out.println("Rezervare acceptata: Exista suficient personal si o sala libera!");
        } else {
            System.out.println("Rezervare respinsa: Resurse insuficiente.");
        }
    }
}