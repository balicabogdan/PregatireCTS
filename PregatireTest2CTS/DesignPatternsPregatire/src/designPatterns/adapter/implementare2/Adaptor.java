package designPatterns.adapter.implementare2;

public class Adaptor implements IUSBcIncarcator {
    // Referinta catre sistemul vechi
    private IMicroUSBIncarcator referintaVeche;

    // Constructorul prin care primim incarcatorul vechi
    public Adaptor(IMicroUSBIncarcator referinta) {
        this.referintaVeche = referinta;
    }

    @Override
    public void incarcarePrinUSBc() {
        referintaVeche.incarcaPrinMicroUSB();
    }
}
