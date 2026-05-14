package designPatterns.flyweight.implementare;

//Pasul 4: Fabrica de Flyweight-uri (FlyweightFactory) Aici rezolvi 50% din cerință. Fabrica se asigură că nu facem new MesajPrintare de 1 milion de ori pentru 1 milion de bonuri.
import java.util.HashMap;
import java.util.Map;

public class MesajPrintareFactory {
    // Colectia care stocheaza si recicleaza obiectele
    private static Map<String, IPrintare> colectieMesaje = new HashMap<String, IPrintare>();

    // Metoda getFlyweight(key) de pe diagrama
    public static IPrintare getMesaj(String tip, String mesajConcret) {
        // Daca nu il avem deja in memorie, il cream si il salvam
        if (!colectieMesaje.containsKey(tip)) {
            colectieMesaje.put(tip, new MesajPrintare(tip, mesajConcret));
            System.out.println("--- S-a creat un obiect nou in memorie pentru tipul: " + tip + " ---");
        }
        // Daca exista, pur si simplu il returnam din colectie
        return colectieMesaje.get(tip);
    }
}
