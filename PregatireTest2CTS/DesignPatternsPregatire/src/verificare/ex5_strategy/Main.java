package verificare.ex5_strategy;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        client.setStrategieViz(new Vizualizare2D());
        client.afiseazaSchita("Living Room");
        client.setStrategieViz(new Vizualizare3D());
        client.afiseazaSchita("Living Roomm");
        client.setStrategieViz(new VizualizeazaDetalii());
        client.afiseazaSchita("Baie");

    }
}
