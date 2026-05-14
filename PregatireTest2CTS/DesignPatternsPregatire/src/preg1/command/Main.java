package preg1.command;
import java.util.ArrayList;
import java.util.List;

// =======================================================
// 1. EXECUTANTUL / RECEIVER-UL (Cel care face treaba fizic)
// =======================================================
class Bucatar {
    private String numeBucatar;

    public Bucatar(String numeBucatar) {
        this.numeBucatar = numeBucatar;
    }

    public void preparaPizza(String tipPizza) {
        System.out.println("Bucatarul " + numeBucatar + " prepara pizza: " + tipPizza);
    }

    public void preparaPaste(String tipPaste) {
        System.out.println("Bucatarul " + numeBucatar + " prepara paste: " + tipPaste);
    }
}

// =======================================================
// 2. INTERFAȚA COMANDĂ (Șablonul pe care îl notează ospătarul)
// =======================================================
interface IComanda {
    void executa();
}

// =======================================================
// 3. COMENZILE CONCRETE (Obiectele care leagă comanda de bucătar)
// =======================================================
class ComandaPizza implements IComanda {
    private String tipPizza;
    // Rombul din diagrama: Comanda STIE cine o va executa
    private Bucatar bucatar;

    public ComandaPizza(Bucatar bucatar, String tipPizza) {
        this.bucatar = bucatar;
        this.tipPizza = tipPizza;
    }

    @Override
    public void executa() {
        bucatar.preparaPizza(tipPizza);
    }
}

class ComandaPaste implements IComanda {
    private String tipPaste;
    private Bucatar bucatar;

    public ComandaPaste(Bucatar bucatar, String tipPaste) {
        this.bucatar = bucatar;
        this.tipPaste = tipPaste;
    }

    @Override
    public void executa() {
        bucatar.preparaPaste(tipPaste);
    }
}

// =======================================================
// 4. INVOKER-UL (Cel care cere executia, in cazul nostru Ospatarul)
// =======================================================
class Ospatar {
    private String numeOspatar;
    // Lista cu "carnetelul" unde aduna comenzile inainte sa le trimita
    private List<IComanda> listaComenzi = new ArrayList<>();

    public Ospatar(String numeOspatar) {
        this.numeOspatar = numeOspatar;
    }

    public void preiaComanda(IComanda comanda) {
        listaComenzi.add(comanda);
        System.out.println("[Ospatar " + numeOspatar + "] A notat o noua comanda.");
    }

    public void trimiteComenziLaBucatarie() {
        System.out.println("\n[Ospatar " + numeOspatar + "] Trimite comenzile la bucatarie!");
        for (IComanda comanda : listaComenzi) {
            comanda.executa(); // El doar apasa "butonul" executa, nu stie CUM se face mancarea
        }
        listaComenzi.clear(); // A sters de pe carnetel ce a trimis deja
    }
}

// =======================================================
// 5. Testarea (Clasa publica principala / Clientul din restaurant)
// =======================================================
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistem Comenzi Command ---");

        // 1. Cream executantul (Bucatarul de la bucatarie)
        Bucatar chefSorin = new Bucatar("Sorin");

        // 2. Cream invoker-ul (Ospatarul de la masa)
        Ospatar ospatarIon = new Ospatar("Ion");

        // 3. Clientul da comenzi (Cream comenzile si i le dam ospatarului)
        IComanda c1 = new ComandaPizza(chefSorin, "Diavola");
        IComanda c2 = new ComandaPaste(chefSorin, "Carbonara");
        IComanda c3 = new ComandaPizza(chefSorin, "Margherita");

        ospatarIon.preiaComanda(c1);
        ospatarIon.preiaComanda(c2);
        ospatarIon.preiaComanda(c3);

        // 4. La final, ospatarul se duce la bucatarie si da drumul la gatit!
        ospatarIon.trimiteComenziLaBucatarie();
    }
}
