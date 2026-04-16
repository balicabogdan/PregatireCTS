package cts.student.examen.g1092.builder;

public interface ISistemIrigatie {
    String getIdSistem();
    String getTipPompa();
    float getDebitApa();
    boolean areSenzorUmiditate();
    boolean areStatieMeteo();
    boolean areDozatorIngrasamant();
    boolean areConexiuneSatelit();
    boolean arePanouSolar();
    void afisareSpecificatii();
}
