package designPatterns.proxy.main;

import designPatterns.proxy.implementare.Client;
import designPatterns.proxy.implementare.IPetrecere;
import designPatterns.proxy.implementare.Petrecere;
import designPatterns.proxy.implementare.PetrecereProxy;

/*
În cadrul restaurantului se organizează diverse petreceri, la care poate participa orice client. S-a decis ca,
pentru petrecerea de Crăciun, să se introducă o vârstă minimă de participare. Se cere implementarea unui modul
intermediar (Proxy) care să permită înregistrarea la petrecere doar a clienților care au împlinit vârsta de 18 ani.
 */
public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("George", 20);
        Client c2 = new Client("Ionut", 16);

        // 1. Cream petrecerea de baza (fara restrictii)
        IPetrecere petrecereNormala = new Petrecere();

        // 2. O "imbracam" in Proxy (angajam bodyguard-ul)
        IPetrecere petrecereCuRestrictii = new PetrecereProxy(petrecereNormala);

        System.out.println("--- Tentative de inregistrare ---");
        // 3. Clientul interactioneaza cu Proxy-ul in loc de obiectul real
        petrecereCuRestrictii.adaugaParticipant(c1); // Va fi adaugat
        petrecereCuRestrictii.adaugaParticipant(c2); // Va fi respins
    }
}
