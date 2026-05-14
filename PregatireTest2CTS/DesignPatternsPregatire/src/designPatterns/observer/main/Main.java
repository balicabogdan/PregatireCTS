package designPatterns.observer.main;

import designPatterns.observer.implementare.Client;
import designPatterns.observer.implementare.IObserver;
import designPatterns.observer.implementare.Restaurant;

/*
În cadrul restaurantului se organizează diverse petreceri, la care poate participa orice client. S-a decis ca,
pentru petrecerea de Crăciun, să se introducă o vârstă minimă de participare. Se cere implementarea unui modul
intermediar (Proxy) care să permită înregistrarea la petrecere doar a clienților care au împlinit vârsta de 18 ani.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Cream subiectul (restaurantul)
        Restaurant restaurant = new Restaurant("Trattoria Il Calcio");

        // 2. Cream observatorii (clientii)
        IObserver client1 = new Client("Ion");
        IObserver client2 = new Client("Gigel");
        IObserver client3 = new Client("Marian");

        // 3. Clientii se aboneaza
        restaurant.addObserver(client1);
        restaurant.addObserver(client2);
        restaurant.addObserver(client3);

        // 4. Restaurantul lanseaza o oferta (Toti vor fi notificati)
        restaurant.adaugaOfertaNoua("Pizza la jumatate de pret in seara asta!");

        // 5. Un client decide sa se dezaboneze
        restaurant.removeObserver(client2);

        // 6. Alta oferta este lansata (Doar Ion si Marian vor primi mesaj)
        restaurant.adaugaOfertaNoua("Meniu de pranz cu desert gratuit!");
    }
}
