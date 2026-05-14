package designPatterns.proxy.implementare;

import java.util.ArrayList;
import java.util.List;

public class Petrecere implements IPetrecere {
    private List<Client> listaParticipanti = new ArrayList<>();

    @Override
    public void adaugaParticipant(Client cl) {
        listaParticipanti.add(cl);
        System.out.println(cl.getNume() + " a fost adaugat cu succes la petrecere.");
    }
}
