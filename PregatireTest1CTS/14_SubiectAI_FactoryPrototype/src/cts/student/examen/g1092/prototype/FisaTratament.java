package cts.student.examen.g1092.prototype;

import java.util.ArrayList;
import java.util.List;

public class FisaTratament implements IFisaTratament, Cloneable{
    private String diagnostic;
    private String durata;
    private List<String> medicamente;

    public FisaTratament(String diagnostic, String durata) {
        System.out.println("Se extrage istoricul pacientului din BD Națională pentru diagnosticul: " + diagnostic + "... durează!");
        this.diagnostic = diagnostic;
        this.durata = durata;
        this.medicamente = new ArrayList<>();
    }

    @Override
    public Object clone(){
        try {
            FisaTratament clona = (FisaTratament) super.clone();
            clona.medicamente = new ArrayList<>(medicamente);
            return clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("ERROR clonare", e);
        }
    }

    @Override public String getDiagnostic() { return diagnostic; }
    @Override public String getDurata() { return durata; }

    @Override
    public void adaugaMedicament(String medicament) {
        this.medicamente.add(medicament);
    }

    @Override
    public void afisareFisa() {
        System.out.println("Fișă [" + diagnostic + "] | Durata: " + durata + " | Medicamente: " + medicamente);
    }
}
