package verificare.Subiect1Seminar.strategy;

import java.util.Comparator;
import java.util.List;

public class VizualizareCrescator implements IStrategyViz{
    @Override
    public void vizualizare(List<IProdus> produse) {
        produse.stream().sorted(Comparator.comparingDouble(IProdus::getPret)).forEach(System.out::println);;
    }
}
