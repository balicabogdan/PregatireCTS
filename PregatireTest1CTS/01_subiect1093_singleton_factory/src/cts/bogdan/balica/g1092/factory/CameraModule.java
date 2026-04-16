package cts.bogdan.balica.g1092.factory;

public class CameraModule extends AbstractModule {
    private String rezolutie;
    private int cadrePeSecunda;

    public CameraModule() {
        this.name = "Camera HD";
        this.description = "Inregistrare la rezolutie inalta";
        this.price = 400.0f;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }
}
