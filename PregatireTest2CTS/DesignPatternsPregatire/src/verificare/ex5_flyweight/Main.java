package verificare.ex5_flyweight;

public class Main {
    public static void main(String[] args) {
        Bon bon1 = new Bon(1, 150.5f);
        Bon bon2 = new Bon(5, 300.0f);
        Bon bon3 = new Bon(2, 45.0f);

        IPrintare mesaj1 = MesajPrintareFactory.getMesajPrintare("Multumire", "Multumim ca ne-ati calcat pragul!");
        mesaj1.printareBon(bon1);

        IPrintare mesaj2 = MesajPrintareFactory.getMesajPrintare("Multumire", "Multumim ca ne-ati calcat pragul!");
        mesaj2.printareBon(bon2);

        IPrintare mesaj3 = MesajPrintareFactory.getMesajPrintare("Amuzament", "Slabut :( Totusi, va multumim!");
        mesaj3.printareBon(bon3);
    }
}