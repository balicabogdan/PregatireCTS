package designPatterns.decorator.implementare;

/*
Pasul 3: Clasa AbstractDecorator (Cea mai importantă de pe diagramă!) Aceasta implementează IBon și deține
 un obiect IBon. Rolul ei este de a „împacheta” bonul original și de a pasa apelurile mai departe către el.
  Aici transcrii relația cu romb din cheatsheet
 */
public abstract class AbstractDecorator implements IBon {
    protected IBon bonDecorat; // Referinta catre obiectul pe care il decoram

    // Constructorul cere un obiect pe care sa il "imbrace"
    public AbstractDecorator(IBon bon) {
        this.bonDecorat = bon;
    }

    // Delegam toate actiunile catre obiectul real
    @Override
    public float getTotal() { return bonDecorat.getTotal(); }

    @Override
    public void printare() { bonDecorat.printare(); }

    @Override
    public void adaugaProdus(float pret) { bonDecorat.adaugaProdus(pret); }
}
