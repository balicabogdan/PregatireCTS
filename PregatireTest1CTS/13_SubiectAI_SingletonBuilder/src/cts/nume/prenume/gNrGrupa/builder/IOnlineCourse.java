package cts.nume.prenume.gNrGrupa.builder;

public interface IOnlineCourse {
    String getCourseId();
    String getTitlu();
    float getPretDeBaza();
    boolean areMaterialeVideo();
    boolean areQuizInteractiv();
    boolean areSuportLive();
    boolean areCertificat();
    boolean areSuportOffline();
    void afisareDetaliiCurs();
}
