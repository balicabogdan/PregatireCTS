package verificare.ex4_observer;

class Client implements IObserver {
    private String nume;

    public Client(String nume) {
        this.nume = nume;
    }

    @Override
    public void getNotificare(float temperaturaNoua) {
        System.out.println("Notificare telefon [" + nume + "]: Temperatura s-a modificat la " + temperaturaNoua + " °C.");
    }
}
