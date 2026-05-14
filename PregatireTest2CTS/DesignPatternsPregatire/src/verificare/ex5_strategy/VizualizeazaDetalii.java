package verificare.ex5_strategy;

public class VizualizeazaDetalii implements IStrategy{
    @Override
    public void vizualizare(String schita) {
        System.out.println("Lista detalii produse pt schita" + schita);
    }
}
