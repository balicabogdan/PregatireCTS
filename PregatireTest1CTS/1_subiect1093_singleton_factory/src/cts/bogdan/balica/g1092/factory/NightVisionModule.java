package cts.bogdan.balica.g1092.factory;

public class NightVisionModule extends AbstractModule{
    private int razaInfrarosu;
    private boolean modTermicActiv;

    public NightVisionModule() {
        this.name = "Night Vision";
        this.description = "Permite vederea pe timp de noapte";
        this.price = 250.0f;
    }

    public void setRazaInfrarosu(int raza) {
        this.razaInfrarosu = raza;
        System.out.println("Raza infrarosu setata la: " + raza + " metri.");
    }

    public void setModTermic(boolean activ) {
        this.modTermicActiv = activ;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
