package designPatterns.facade.implementare;

public class FacadeRezervare {

    // Metoda unificata pe care o va apela clientul
    public static boolean verificaDisponibilitate(int nrBucatariNecesari, String data) {

        // 1. Verificam bucatarii
        GestiuneBucatari gestiuneBucatari = new GestiuneBucatari();
        int bucatariDisponibili = 0;

        for(int i = 0; i < gestiuneBucatari.getNrBucatari(); i++) {
            if(gestiuneBucatari.getBucatar(i).verificaDisponibilitate(data)) {
                bucatariDisponibili++;
            }
        }

        // 2. Verificam sala (presupunem ca vrem sala 1)
        GestiuneSali gestiuneSali = new GestiuneSali();
        boolean salaLibera = gestiuneSali.getSala(1).esteLibera(data);

        // Returnam decizia finala simplificata (true/false)
        if (bucatariDisponibili >= nrBucatariNecesari && salaLibera) {
            return true;
        }
        return false;
    }
}
