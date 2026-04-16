package cts.student.examen.g1092.builder;

public interface IProductionItem {
    String getModelName();
    String getSerialCode();
    String getMaterialType();
    String getBatchLabel();
    String getPackagingType();
    void displayInfo();
}