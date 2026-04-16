package cts.student.examen.g1092.prototype;

import java.util.ArrayList;
import java.util.List;

public class Item implements ProductionItem, Cloneable{
    private String modelName;
    private String serialCode;
    private String batchLabel;
    private String packagingType;
    private List<String> componente; // Adăugat pentru a demonstra DEEP COPY!


    public Item(String modelName) {
        System.out.println("Se incarca reteta din baza de date pentru " + modelName + "... dureaza!");
        this.modelName = modelName;
        this.componente = new ArrayList<>();
    }

    @Override
    public Object clone() {
        try{
            Item clona = (Item) super.clone();
            clona.componente = new ArrayList<>();
            clona.componente.addAll(this.componente);
            return clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }


    // Setteri PENTRU PARTICULARIZAREA CLONEI [3]
    public void setSerialCode(String serialCode) { this.serialCode = serialCode; }
    public void setBatchLabel(String batchLabel) { this.batchLabel = batchLabel; }
    public void setPackagingType(String packagingType) { this.packagingType = packagingType; }
    public void addComponenta(String comp) { this.componente.add(comp); }

    // Metodele din interfață
    @Override public String getModelName() { return modelName; }
    @Override public String getSerialCode() { return serialCode; }
    @Override public String getBatchLabel() { return batchLabel; }
    @Override public String getPackagingType() { return packagingType; }

    @Override
    public void displayInfo() {
        System.out.println("Item{" +
                "modelName='" + modelName + '\'' +
                ", serialCode='" + serialCode + '\'' +
                ", batchLabel='" + batchLabel + '\'' +
                ", packagingType='" + packagingType + '\'' +
                ", componente=" + componente +
                '}');
    }
}
