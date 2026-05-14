package designPatterns.adapter.implementare1;

public class Adapter implements IEvaluareClientFirmaB {
    // Referinta catre obiectul/sistemul la care ne adaptam
    private IEvaluareClientFirmaA referinta = new EvaluareClientFirmaA();

    // O metoda ajutatoare pentru a face "traducerea" datelor
    private int costTotalEvenimente(Client client) {
        int total = 0;
        for(int cost : client.getCostEvenimente()) {
            total += cost;
        }
        return total;
    }

    @Override
    public void analizaClientFirmaB(Client client) {
        System.out.println("Pare ca evaluarea este facuta de firma B, dar se realizeaza de firma A...");
        // Traducem un obiect "Client" intr-un "int" pentru a folosi metoda din Firma A
        int total = costTotalEvenimente(client);
        referinta.analizaClientFirmaA(total);
    }
}
