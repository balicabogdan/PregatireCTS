package preg1.chainOfResp;

// =======================================================
// 1. CLASA DE DATE (Cererea care circula prin lant)
// =======================================================
class Comanda {
    private String produs;
    private boolean contineMancare;

    public Comanda(String produs, boolean contineMancare) {
        this.produs = produs;
        this.contineMancare = contineMancare;
    }

    public String getProdus() { return produs; }
    public boolean isContineMancare() { return contineMancare; }
}

// =======================================================
// 2. INTERFAȚA (Template-ul de bază)
// =======================================================
interface IHandler {
    void setNextHandler(IHandler nextHandler);
    IHandler getNextHandler();
    void procesareComanda(Comanda comanda);
}

// =======================================================
// 3. CLASA ABSTRACTĂ (Cea care gestionează legăturile din lanț)
// =======================================================
abstract class AHandler implements IHandler {
    // Aici sta "magia" pattern-ului: fiecare veriga retine cine e URMĂTORUL in lant
    private IHandler nextHandler;

    @Override
    public void setNextHandler(IHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public IHandler getNextHandler() {
        return this.nextHandler;
    }
}

// =======================================================
// 4. HANDLERII CONCREȚI (Angajatii / Verigile efective)
// =======================================================
class Ospatar extends AHandler {
    @Override
    public void procesareComanda(Comanda comanda) {
        // Daca e DOAR bautura, o rezolva ospatarul direct
        if (!comanda.isContineMancare()) {
            System.out.println("Ospatarul a servit la masa bautura: " + comanda.getProdus());
        } else {
            // Daca contine mancare, paseaza mai departe catre urmatorul (Bucatarul)
            if (this.getNextHandler() != null) {
                System.out.println("Ospatarul nu poate face mancarea. Trimite comanda mai departe catre bucatarie...");
                this.getNextHandler().procesareComanda(comanda);
            } else {
                System.out.println("Comanda nu a putut fi procesata! Nu exista nimeni disponibil in lant.");
            }
        }
    }
}

class Bucatar extends AHandler {
    @Override
    public void procesareComanda(Comanda comanda) {
        // Bucatarul se ocupa doar de mancare
        if (comanda.isContineMancare()) {
            System.out.println("Bucatarul a preparat mancarea: " + comanda.getProdus());
        } else {
            // Daca venea ceva ce nu stia, ar fi dat mai departe (desi nu e cazul in exemplul asta)
            if (this.getNextHandler() != null) {
                this.getNextHandler().procesareComanda(comanda);
            }
        }
    }
}

// =======================================================
// 5. Testarea în Main
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Chain of Responsibility ---");

        // 1. Cream "angajatii" (verigile)
        IHandler ospatar = new Ospatar();
        IHandler bucatar = new Bucatar();

        // 2. CONFIGURAM LANTUL (Ospatar -> Bucatar)
        // Ospatarul este primul, el da restul de comenzi la bucatar.
        ospatar.setNextHandler(bucatar);

        // 3. Cream comenzile de test
        Comanda comandaBautura = new Comanda("Bere Ursus", false);
        Comanda comandaMancare = new Comanda("Pizza Margherita", true);

        // 4. Clientul vorbeste MEREU doar cu prima veriga (Ospatarul)!
        System.out.println("\n-> Clientul comanda o bautura:");
        ospatar.procesareComanda(comandaBautura);

        System.out.println("\n-> Clientul comanda o pizza:");
        ospatar.procesareComanda(comandaMancare);
    }
}
