package designPatterns.flyweight.implementare;

//Pasul 3: Clasa ConcreteFlyweight (Starea Intrinsecă, partea refolosibilă) Aici punem mesajul efectiv.
// Va exista o singură instanță în memorie pentru fiecare tip de mesaj!
public class MesajPrintare implements IPrintare {
    private String tipPrintare; // ex: "Multumire", "Avertizare"
    private String mesaj;       // ex: "Multumim ca ati ales restaurantul nostru!"

    public MesajPrintare(String tipPrintare, String mesaj) {
        this.tipPrintare = tipPrintare;
        this.mesaj = mesaj;
    }

    @Override
    public void printareBon(Bon bon) {
        // Aici unim starea intrinseca (mesajul) cu cea extrinseca (bonul primit ca parametru)
        System.out.println("Bonul pentru masa " + bon.getNrMasa() + " are totalul de " + bon.getCostTotal() + " RON.");
        System.out.println("Mesaj restaurant: " + this.mesaj);
        System.out.println("-------------------------------------------------");
    }
}
