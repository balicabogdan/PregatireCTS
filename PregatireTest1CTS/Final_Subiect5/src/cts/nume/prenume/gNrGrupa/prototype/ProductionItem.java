package cts.nume.prenume.gNrGrupa.prototype;

import java.util.ArrayList;
import java.util.List;

public class ProductionItem implements IProductionItem, Cloneable{
    private String model;
    private String serialCode;
    private String label;
    private String packType;
    private List<String> componente; // Adăugat pentru a demonstra DEEP COPY!

    public ProductionItem(String model, String serialCode, String label, String packType) {
        this.model = model;
        this.serialCode = serialCode;
        this.label = label;
        this.packType = packType;
    }

    @Override
    public Object clone(){
        try {
            ProductionItem clona = (ProductionItem) super.clone();
            clona.componente = new ArrayList<>(this.componente);
            return  clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("ERR clona", e);
        }
    }

    @Override
    public String getModelName() {
        return model;
    }

    @Override
    public String getSerialCode() {
        return serialCode;
    }

    @Override
    public String getBatchLabel() {
        return label;
    }

    @Override
    public String getPackagingType() {
        return packType;
    }

    @Override
    public void displayInfo() {

    }
}
