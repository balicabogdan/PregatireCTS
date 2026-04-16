package cts.bogdan.balica.g1092.factory;

public class GpsTrackingModule extends AbstractModule {
    private int acurateteMetri;
    private int numarSatelitiConectati;

    public GpsTrackingModule() {
        this.name = "GPS Tracker";
        this.description = "Urmarire locatie exacta";
        this.price = 150.0f;
    }

    public void setAcurateteMetri(int acurateteMetri) {
        this.acurateteMetri = acurateteMetri;
        System.out.println("Acuratete GPS setata la " + acurateteMetri + " metri.");
    }
}
