package cts.student.examen.g1092.singleton;

import java.util.ArrayList;
import java.util.List;

public class RawMaterialManager implements IRawMaterialControl{
    private static final RawMaterialManager instance = new RawMaterialManager();

    private float stocDisponibil;
    private List<String> istoricOperatii;

    private RawMaterialManager() {
        this.stocDisponibil = 0f;
        this.istoricOperatii = new ArrayList<>();
    }

    public static RawMaterialManager getInstance(){
        return instance;
    }

    @Override
    public void addRawMaterial(String codAngajat, float quantity)  {
        try{
        if(quantity <= 0){
            throw new Exception("Nu e destula cantitate disponibila");
        }
        stocDisponibil+=quantity;
        istoricOperatii.add("IN: Angajatul "+codAngajat+" a adaugat unitati: "+quantity);} catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void consumeRawMaterial(String codAngajat, String productName, float quantity){
        try{
            if (stocDisponibil < quantity) {
                throw new Exception("Nu e destul stoc disponibil pentru a extrage");
            }
            stocDisponibil -= quantity;
            istoricOperatii.add("OUT: Angajatul " + codAngajat + " a extras unitati: " + quantity + " pentru " + productName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float getAvailableStock() {
        return stocDisponibil;
    }

    @Override
    public void displayHistory() {
        System.out.println("---ISTORIC:---");
        for(String operatie : istoricOperatii){
            System.out.println(operatie);
        }
    }
}
