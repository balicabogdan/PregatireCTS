package designPatterns.composite.main;

import designPatterns.composite.implementare.ANod;
import designPatterns.composite.implementare.Produs;
import designPatterns.composite.implementare.Structura;

public class Main {
    public static void main(String[] args) {
        // 1. Definim radacina (Nivel 0)
        ANod meniuRestaurant = new Structura("Meniu Restaurant");

        // 2. Definim categorii principale (Nivel 1)
        ANod sectiuneBauturi = new Structura("Bauturi");
        ANod sectiuneMancare = new Structura("Mancare");

        // 3. Definim sub-categorii (Nivel 2)
        ANod subSectiuneAlcool = new Structura("Bauturi cu alcool");
        ANod subSectiunePizza = new Structura("Pizza");

        // 4. Definim produsele finale / Frunzele (Nivel 3)
        ANod bere = new Produs("Bere Ursus", 10);
        ANod pizzaMargherita = new Produs("Pizza Margherita", 35);
        ANod pizzaSalami = new Produs("Pizza Salami", 40);

        // 5. Asamblam structura (legam obiectele intre ele)
        subSectiuneAlcool.adaugaNod(bere);
        subSectiunePizza.adaugaNod(pizzaMargherita);
        subSectiunePizza.adaugaNod(pizzaSalami);

        sectiuneBauturi.adaugaNod(subSectiuneAlcool);
        sectiuneMancare.adaugaNod(subSectiunePizza);

        meniuRestaurant.adaugaNod(sectiuneBauturi);
        meniuRestaurant.adaugaNod(sectiuneMancare);

        // Acum intregul meniu este grupat într-un singur obiect (meniuRestaurant)
        System.out.println("Meniul a fost generat cu succes!");

        // Putem accesa un copil
        System.out.println("Primul element din meniu este categoria: " + meniuRestaurant.getChild(0).getDenumire());

    }
}
