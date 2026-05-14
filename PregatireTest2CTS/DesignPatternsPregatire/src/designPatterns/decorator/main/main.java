package designPatterns.decorator.main;

/*
Într-un restaurant, la încheierea comenzii se calculează totalul și se afișează pe bon. Pe perioada primăverii,
s-a decis să se acorde o reducere de 10% pentru clienții de gen feminin. Se cere implementarea unui modul care
să adauge această opțiune pe bon fără a modifica codul deja existent, folosind design pattern-ul adecvat.
 */

import designPatterns.decorator.implementare.Bon;
import designPatterns.decorator.implementare.DecoratorPrimavara;
import designPatterns.decorator.implementare.IBon;

public class main {
    public static void main(String[] args) {
        // 1. Cream un bon simplu si adaugam produse pe el
        IBon bonSimplu = new Bon(1);
        bonSimplu.adaugaProdus(100f);
        bonSimplu.adaugaProdus(50f);

        System.out.println("Total fara reducere: " + bonSimplu.getTotal());

        // 2. Il "decoram" cu reducerea de primavara
        IBon bonCuReducere = new DecoratorPrimavara(bonSimplu, true);

        // 3. Apelam metodele folosind obiectul decorat. Clientul il trateaza la fel ca pe un bon simplu!
        System.out.println("Total cu reducere: " + bonCuReducere.getTotal());
    }
}
