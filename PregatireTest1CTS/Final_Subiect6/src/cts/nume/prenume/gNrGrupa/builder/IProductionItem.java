package cts.nume.prenume.gNrGrupa.builder;

public interface IProductionItem {
    String getModelName();
    String getSerialCode();
    String getMaterialType();
    String getBatchLabel();
    String getPackagingType();
    void displayInfo();
}
