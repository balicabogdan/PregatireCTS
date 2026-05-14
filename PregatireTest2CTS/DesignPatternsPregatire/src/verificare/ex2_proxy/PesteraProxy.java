package verificare.ex2_proxy;

import java.util.ArrayList;
import java.util.List;

public class PesteraProxy implements IPestera{
    private IPestera pesteraReala;
    private List<String> listaAsteptare = new ArrayList<>();

    public PesteraProxy(IPestera pesteraReala) {
        this.pesteraReala = pesteraReala;
    }

    @Override
    public void viziteaza(String persoana, boolean areTichet) {
        if(!areTichet) {
            System.out.println("Acces respins: " + persoana + " a incercat sa intre fara bilet.");
            return;
        }

        listaAsteptare.add(persoana);
        System.out.println("[Proxy] " + persoana + " este in asteptare. (Grup " + listaAsteptare.size() + "/5)");

        if(listaAsteptare.size() == 5) {
            System.out.println("\n*** S-a format un grup! Se deschid portile pesterii! ***");

            // Trimitem tot grupul in pestera reala
            for(String vizitator : listaAsteptare) {
                pesteraReala.viziteaza(vizitator, true);
            }

            // Golim lista de asteptare pentru a primi urmatorul grup
            listaAsteptare.clear();
            System.out.println("---------------------------------------------------\n");
        }

    }
}
