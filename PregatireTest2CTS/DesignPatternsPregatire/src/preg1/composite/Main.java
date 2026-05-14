package preg1.composite;

import java.util.ArrayList;
import java.util.List;

// =======================================================
// 1. INTERFAȚA COMUNĂ (Nodul - "Component" pe diagramă)
// =======================================================
interface INodMeniu {
    void afisare(String indentare);

    // Metode specifice doar pentru Categorie (Structura)
    // In Java 8+ putem pune 'default' ca Frunzele sa nu fie obligate sa le implementeze
    public void adaugaNod(INodMeniu nod);
    public INodMeniu getNod(int index);
}

// =======================================================
// 2. FRUNZA ("Leaf" - elementul final, care nu are copii)
// =======================================================
class Produs implements INodMeniu {
    private String denumire;
    private float pret;

    public Produs(String denumire, float pret) {
        this.denumire = denumire;
        this.pret = pret;
    }

    @Override
    public void afisare(String indentare) {
        System.out.println(indentare + "- Produs: " + denumire + " (" + pret + " LEI)");
    }

    @Override
    public void adaugaNod(INodMeniu nod) {
        throw new UnsupportedOperationException("Nu");
    }

    @Override
    public INodMeniu getNod(int index) {
        throw new UnsupportedOperationException("Nu");
    }
}

// =======================================================
// 3. STRUCTURA ("Composite" - categoria care contine alte noduri)
// =======================================================
class Categorie implements INodMeniu {
    private String numeCategorie;

    // ROMBUL NEGRU DE PE DIAGRAMA: Compozitia arborescenta
    private List<INodMeniu> copii = new ArrayList<>();

    public Categorie(String nume) {
        this.numeCategorie = nume;
    }

    @Override
    public void adaugaNod(INodMeniu nod) {
        copii.add(nod);
    }

    @Override
    public INodMeniu getNod(int index) {
        return copii.get(index);
    }

    @Override
    public void afisare(String indentare) {
        System.out.println(indentare + "[Categorie] " + numeCategorie);
        // Parcurgem toti copiii (fie ei Produse sau alte Categorii)
        for (INodMeniu nod : copii) {
            nod.afisare(indentare + "    ");
        }
    }
}

// =======================================================
// 4. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Meniu Restaurant ---");

        // 1. Cream radacina (Nivel 0)
        INodMeniu meniuTotal = new Categorie("Meniul Zilei");

        // 2. Cream categorii (Nivel 1)
        INodMeniu catBauturi = new Categorie("Bauturi");
        INodMeniu catMancare = new Categorie("Mancare");

        // 3. Cream sub-categorii (Nivel 2)
        INodMeniu subCatAlcool = new Categorie("Cu Alcool");
        INodMeniu subCatFaraAlcool = new Categorie("Fara Alcool");

        // 4. Cream produsele finale / Frunzele (Nivel 3)
        INodMeniu bere = new Produs("Bere Ursus", 10);
        INodMeniu apa = new Produs("Apa Plata", 5);
        INodMeniu pizza = new Produs("Pizza Margherita", 35);

        // 5. Asamblam structura arborescenta
        subCatAlcool.adaugaNod(bere);
        subCatFaraAlcool.adaugaNod(apa);

        catBauturi.adaugaNod(subCatAlcool);
        catBauturi.adaugaNod(subCatFaraAlcool);

        catMancare.adaugaNod(pizza);

        meniuTotal.adaugaNod(catBauturi);
        meniuTotal.adaugaNod(catMancare);

        // 6. Apelam o singura metoda pe radacina, si ea se propaga in tot arborele!
        meniuTotal.afisare("");
    }
}
