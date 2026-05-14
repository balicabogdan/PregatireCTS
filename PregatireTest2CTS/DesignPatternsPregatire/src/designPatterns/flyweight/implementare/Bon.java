package designPatterns.flyweight.implementare;

//Pasul 1: Starea Extrinsecă (Partea variabilă, unică pentru fiecare client) Aceasta este clasa Bon,
// care se modifică la fiecare comandă. Observă că nu conține deloc mesajul în ea!
public class Bon {
    private int nrMasa;
    private float costTotal;

    public Bon(int nrMasa, float costTotal) {
        this.nrMasa = nrMasa;
        this.costTotal = costTotal;
    }

    public int getNrMasa() { return nrMasa; }
    public float getCostTotal() { return costTotal; }
}
