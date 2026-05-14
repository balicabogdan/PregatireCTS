package verificare.ex5_flyweight;

class Bon {
    private int nrMasa;
    private float costTotal;

    public Bon(int nrMasa, float costTotal) {
        this.nrMasa = nrMasa;
        this.costTotal = costTotal;
    }

    public int getNrMasa() { return nrMasa; }
    public float getCostTotal() { return costTotal; }
}
