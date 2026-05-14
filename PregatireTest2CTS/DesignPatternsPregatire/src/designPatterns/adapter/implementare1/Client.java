package designPatterns.adapter.implementare1;

public class Client {
    private String numeClient;
    private int nrEvenimente;
    private int[] costEvenimente;

    public Client(String numeClient, int nrEvenimente, int[] costEvenimente) {
        this.numeClient = numeClient;
        this.nrEvenimente = nrEvenimente;
        this.costEvenimente = costEvenimente;
    }

    public int[] getCostEvenimente() {
        return costEvenimente;
    }
}
