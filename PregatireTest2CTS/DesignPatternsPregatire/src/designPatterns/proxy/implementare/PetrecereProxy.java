package designPatterns.proxy.implementare;

public class PetrecereProxy implements IPetrecere {
    // Referinta catre obiectul real pe care il protejam
    private IPetrecere petrecereReal;

    // Constructor
    public PetrecereProxy(IPetrecere petrecere) {
        this.petrecereReal = petrecere;
    }

    @Override
    public void adaugaParticipant(Client cl) {
        // AICI este esenta DP-ului Proxy: adaugam o CONDITIE (verificare)
        if (cl.getVarsta() >= 18) {
            // Daca are 18 ani, delegam munca obiectului real
            petrecereReal.adaugaParticipant(cl);
        } else {
            // Daca nu, oprim procesul
            System.out.println("Acces respins! " + cl.getNume() + " are " + cl.getVarsta() + " ani. Varsta minima este 18 ani.");
        }
    }
}