package designPatterns.strategy;

public class OfertaMeniu {
    private String denumireMeniu;
    private int nrCalorii;
    private int nrCarbohidrati;

    public OfertaMeniu(String denumire, int calorii, int carbohidrati) {
        this.denumireMeniu = denumire;
        this.nrCalorii = calorii;
        this.nrCarbohidrati = carbohidrati;
    }

    public int getNrCalorii() { return nrCalorii; }
    public int getNrCarbohidrati() { return nrCarbohidrati; }
    public String getDenumireMeniu() { return denumireMeniu; }
}
