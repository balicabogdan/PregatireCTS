package cts.student.examen.g1092.prototype;

import java.util.ArrayList;
import java.util.List;

public class ProfilCultura implements IProfilCultura,Cloneable{

    private String tipCultura;
    private int necesarApa;
    private String perioadaPlantare;
    private List<String> coordonateGPS;

    public ProfilCultura(String tipCultura) {
        this.tipCultura = tipCultura;
        this.coordonateGPS = new ArrayList<>();
    }

    @Override
    public Object clone(){
        ProfilCultura clona = null;
        try {
            clona= (ProfilCultura) super.clone();
            clona.tipCultura = this.tipCultura;
            clona.necesarApa = this.necesarApa;
            clona.coordonateGPS = new ArrayList<>(this.coordonateGPS);
            return clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTipCultura() {
        return "";
    }

    @Override
    public int getNecesarApaZilnic() {
        return 0;
    }

    @Override
    public String getPerioadaPlantare() {
        return "";
    }

    @Override
    public void adaugaCoordonataParcela(String coordonataGPS) {

    }

    @Override
    public void afisareProfil() {

    }
}
