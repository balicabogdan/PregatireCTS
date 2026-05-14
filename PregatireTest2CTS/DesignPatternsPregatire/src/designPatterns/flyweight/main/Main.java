package designPatterns.flyweight.main;

/*
„În cadrul restaurantului, se dorește ca printarea unui bon să fie însoțită de un mesaj «simpatic» ales de
departamentul de marketing dintr-un set predefinit limitat de mesaje. Fiecare bon va conține: nr. mesei,
cost total și un mesaj. Întrucât se generează un număr foarte mare de bonuri, se dorește optimizarea memoriei
consumate reutilizând mesajele.”
 */

import designPatterns.flyweight.implementare.Bon;
import designPatterns.flyweight.implementare.IPrintare;
import designPatterns.flyweight.implementare.MesajPrintareFactory;

public class Main {
    public static void main(String[] args) {
        // Cream mai multe bonuri (Extrinsec)
        Bon bon1 = new Bon(1, 100);
        Bon bon2 = new Bon(2, 200);
        Bon bon3 = new Bon(3, 250);

        // Luam Flyweight-urile de la fabrica (Intrinsec)
        // La primul apel, il va crea
        IPrintare mesajMultumire = MesajPrintareFactory.getMesaj("Standard", "Multumim ca ne-ati vizitat!");
        mesajMultumire.printareBon(bon1);

        // La al doilea apel, NU mai creeaza un obiect nou in memorie, il va recicla pe cel de sus
        IPrintare mesajMultumire2 = MesajPrintareFactory.getMesaj("Standard", "Multumim ca ne-ati vizitat!");
        mesajMultumire2.printareBon(bon2);

        // Cream un alt tip de mesaj
        IPrintare mesajAvertizare = MesajPrintareFactory.getMesaj("Scump", "Ne scuzati pentru preturile mari...");
        mesajAvertizare.printareBon(bon3);
    }
}
