package designPatterns.proxy.implementare;

public class Client {
    private String nume;
    private int varsta;

    public Client(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public int getVarsta() { return varsta; }
    public String getNume() { return nume; }
}
