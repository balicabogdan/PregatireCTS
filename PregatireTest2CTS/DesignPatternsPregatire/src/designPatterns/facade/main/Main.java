package designPatterns.facade.main;

import designPatterns.facade.implementare.FacadeRezervare;

public class Main {
    public static void main(String[] args) {
        // Clientul vrea o rezervare pe 14 Mai si are nevoie de 2 bucatari
        boolean sePoateFaceRezervarea = FacadeRezervare.verificaDisponibilitate(2, "14-Mai");

        if(sePoateFaceRezervarea) {
            System.out.println("Rezervarea a fost acceptata!");
        } else {
            System.out.println("Nu sunt resurse suficiente pentru rezervare.");
        }
    }
}