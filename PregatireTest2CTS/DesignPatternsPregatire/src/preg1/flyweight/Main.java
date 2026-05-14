package preg1.flyweight;

import java.util.HashMap;
import java.util.Map;

// =======================================================
// 1. STAREA EXTRINSECĂ (Partea care se schimba mereu)
// =======================================================
class Bon {
    private int nrMasa;
    private float costTotal;

    public Bon(int nrMasa, float costTotal) {
        this.nrMasa = nrMasa;
        this.costTotal = costTotal;
    }

    public int getNrMasa() { return nrMasa; }
    public float getCostTotal() { return costTotal; }
}

// =======================================================
// 2. INTERFAȚA FLYWEIGHT (Componenta de bază)
// =======================================================
interface IPrintare {
    // Metoda primeste starea "extrinseca" (bonul variabil) ca parametru!
    void printareBon(Bon bon);
}

// =======================================================
// 3. CONCRETE FLYWEIGHT (Starea Intrinsecă - Partea refolosită)
// =======================================================
class MesajPrintare implements IPrintare {
    private String tipMesaj;
    private String textMesaj;

    public MesajPrintare(String tipMesaj, String textMesaj) {
        this.tipMesaj = tipMesaj;
        this.textMesaj = textMesaj;
    }

    @Override
    public void printareBon(Bon bon) {
        System.out.println("Bon pt Masa " + bon.getNrMasa() + " | Total: " + bon.getCostTotal() + " LEI");
        System.out.println("Mesaj marketing: " + textMesaj);
        System.out.println("-------------------------------------------------");
    }
}

// =======================================================
// 4. FLYWEIGHT FACTORY (Fabrica inteligenta care recicleaza)
// =======================================================
class MesajPrintareFactory {
    // Aici stocam obiectele pentru a nu le recrea
    private static Map<String, IPrintare> colectieMesaje = new HashMap<>();

    public static IPrintare getMesaj(String tip, String text) {
        // Daca mesajul NU exista in memorie, il cream acum
        if (!colectieMesaje.containsKey(tip)) {
            colectieMesaje.put(tip, new MesajPrintare(tip, text));
            System.out.println("  [!] S-a instantiat un obiect NOU in memorie pentru: " + tip);
        }
        // Returnam obiectul (fie el proaspat creat sau scos din "reciclare")
        return colectieMesaje.get(tip);
    }
}

// =======================================================
// 5. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Generare Bonuri ---");

        // 1. Cream informatiile variabile (Extrinseci) - 3 bonuri diferite
        Bon bon1 = new Bon(5, 150.50f);
        Bon bon2 = new Bon(9, 300.00f);
        Bon bon3 = new Bon(2, 45.00f);

        // 2. Printam primul bon (Factory va CREA obiectul in memorie)
        IPrintare mesajMultumire = MesajPrintareFactory.getMesaj("Multumire", "Multumim ca ne-ati calcat pragul!");
        mesajMultumire.printareBon(bon1);

        // 3. Printam al doilea bon, folosind ACELASI tip de mesaj
        // Factory NU va mai crea obiectul, ci il va RECICLA pe cel de sus!
        IPrintare mesajMultumireReciclat = MesajPrintareFactory.getMesaj("Multumire", "Multumim ca ne-ati calcat pragul!");
        mesajMultumireReciclat.printareBon(bon2);

        // 4. Printam un bon cu un mesaj diferit (Factory va crea un NOU obiect)
        IPrintare mesajAvertizare = MesajPrintareFactory.getMesaj("Avertizare", "Nu uitati sa lasati bacsis!");
        mesajAvertizare.printareBon(bon3);
    }
}
