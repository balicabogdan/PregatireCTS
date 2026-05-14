package verificare.Subiect1Seminar.strategy;

public class Produs implements IProdus{
    private String nume;
    private double pret;
    private int nrRecenzii;

    public Produs(String nume, double pret, int nrRecenzii) {
        this.nume = nume;
        this.pret = pret;
        this.nrRecenzii = nrRecenzii;
    }

    @Override
    public double getPret() {
        return pret;
    }

    @Override
    public int getNrRecenzii() {
        return nrRecenzii;
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Produs{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", pret=").append(pret);
        sb.append(", nrRecenzii=").append(nrRecenzii);
        sb.append('}');
        return sb.toString();
    }
}
