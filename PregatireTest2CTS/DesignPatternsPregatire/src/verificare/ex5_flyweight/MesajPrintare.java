package verificare.ex5_flyweight;

class MesajPrintare implements IPrintare {
    private String tipPrintare;
    private String mesaj;

    public MesajPrintare(String tipPrintare, String mesaj) {
        this.tipPrintare = tipPrintare;
        this.mesaj = mesaj;
    }

    @Override
    public void printareBon(Bon bon) {
        System.out.println("Masa: " + bon.getNrMasa() + " | Total: " + bon.getCostTotal());
        System.out.println("Mesaj: " + mesaj);
    }
}
