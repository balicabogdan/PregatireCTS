package preg1.proxy;

import java.util.ArrayList;
import java.util.List;

// =======================================================
// 1. CLASA DE DATE (Clientul care vrea sa participe)
// =======================================================
class Client {
    private String nume;
    private int varsta;

    public Client(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public int getVarsta() { return varsta; }
    public String getNume() { return nume; }
}

// =======================================================
// 2. INTERFATA COMUNA (Subject-ul din diagrama)
// =======================================================
interface IPetrecere {
    void adaugaParticipant(Client cl);
}

// =======================================================
// 3. OBIECTUL REAL (RealSubject - petrecerea de baza)
// =======================================================
class Petrecere  implements IPetrecere{
    private List<Client> listaParticipanti = new ArrayList<>();

    @Override
    public void adaugaParticipant(Client cl) {
        listaParticipanti.add(cl);
        System.out.println(cl.getNume() + " a fost adaugat cu succes la petrecere!");
    }
}

// =======================================================
// 4. PROXY-UL (Modulul intermediar cu restrictia)
// =======================================================
class PetrecereProxy implements IPetrecere {
    private IPetrecere petrecereReala;

    public PetrecereProxy(IPetrecere petrecereReala) {
        this.petrecereReala = petrecereReala;
    }


    @Override
    public void adaugaParticipant(Client cl) {
        if(cl.getVarsta() >= 18){
            petrecereReala.adaugaParticipant(cl);
        }else {
            System.out.println("Acces respins! " + cl.getNume() + " are " + cl.getVarsta() + " ani (minimul este 18).");
        }
    }
}

// =======================================================
// 5. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        Petrecere petrecere = new Petrecere();
        IPetrecere petSecure = new PetrecereProxy(petrecere);
        Client c1 = new Client("andrei",18);
        Client c2 = new Client("andreea",12);
        Client c3 = new Client("cosmin",28);

        petSecure.adaugaParticipant(c1);
        petSecure.adaugaParticipant(c2);
        petSecure.adaugaParticipant(c3);
    }
}

