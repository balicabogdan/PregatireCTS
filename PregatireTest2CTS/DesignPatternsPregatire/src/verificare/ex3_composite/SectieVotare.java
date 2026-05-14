package verificare.ex3_composite;

// =======================================================
// 2. FRUNZA (Leaf - elementul de bază, Secția de votare)
// =======================================================
class SectieVotare implements INodVotare {
    private String numeSectie;
    private int numarVoturiInregistrate;

    public SectieVotare(String numeSectie, int numarVoturiInregistrate) {
        this.numeSectie = numeSectie;
        this.numarVoturiInregistrate = numarVoturiInregistrate;
    }

    @Override
    public int calculeazaVoturi() {
        return numarVoturiInregistrate;
    }

    @Override
    public void adaugaNod(INodVotare nod) {
        throw new UnsupportedOperationException("Nu se poate");
    }

    @Override
    public void stergeNod(INodVotare nod) {
        throw new UnsupportedOperationException("Nu se poate");
    }

    @Override
    public INodVotare getNod(int index) {
        throw new UnsupportedOperationException("Nu se poate");
    }
}
