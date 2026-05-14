package preg1.adapter;

// =======================================================
// 1. Sistemul VECHI (ce avem la dispozitie, incompatibil)
// =======================================================
interface IMicroUSBIncarcator {
    void incarcaPrinMicroUSB();
}

class MicroUSB implements IMicroUSBIncarcator {

    @Override
    public void incarcaPrinMicroUSB() {
        System.out.println("Incarcare fizica prin cablul vechi Micro USB...");
    }
}

// =======================================================
// 2. Sistemul NOU (ce are nevoie telefonul nostru/Target)
// =======================================================
interface IUSBcIncarcator {
    void incarcarePrinUSBc();
}

class Telefon {
    private String model;

    public Telefon(String model) {
        this.model = model;
    }

    // Telefonul accepta STRICT incarcatoare de tip USB-C
    public void chargeUSBc(IUSBcIncarcator incarcator) {
        System.out.println("Telefonul " + model + " s-a conectat la mufa USB-C.");
        incarcator.incarcarePrinUSBc();
    }
}

// =======================================================
// 3. ADAPTORUL (Inima pattern-ului - face "traducerea")
// =======================================================
// Implementeaza interfata NOUA, dar foloseste in spate obiectul VECHI
class Adaptor implements IUSBcIncarcator {
    private IMicroUSBIncarcator referintaVeche;

    public Adaptor(IMicroUSBIncarcator referinta) {
        this.referintaVeche = referinta;
    }

    @Override
    public void incarcarePrinUSBc() {
        System.out.println("Adaptorul preia mufa USB-C si o converteste...");
        referintaVeche.incarcaPrinMicroUSB();
    }
}

// =======================================================
// 4. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        Telefon telefon = new Telefon("Xiaomi");
        IMicroUSBIncarcator incarcatorVechi = new MicroUSB();
        IUSBcIncarcator adapter = new Adaptor(incarcatorVechi);
        telefon.chargeUSBc(adapter);
    }
}
