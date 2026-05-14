package verificare.ex5_strategy;

public class Client {
    private IStrategy strategieViz;

    public void setStrategieViz(IStrategy stratViz){
        this.strategieViz = stratViz;
    }
    public void afiseazaSchita(String schita){
        if(strategieViz != null){
            strategieViz.vizualizare(schita);
        }
    }
}
