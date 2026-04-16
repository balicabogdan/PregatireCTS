package cts.student.examen.g1092.builder;

public class SistemIrigatie implements ISistemIrigatie{

    // Atribute obligatorii
    private String idSistem;
    private String tipPompa;
    private float debitApa;

    // Atribute opționale
    private boolean senzorUmiditateSol;
    private boolean statieMeteoIntegrata;
    private boolean modulDozareIngrasamant;
    private boolean conexiuneSatelit;
    private boolean panouSolar;

    private SistemIrigatie(SistemIrigatieBuilder builder){
        this.idSistem = builder.idSistem;
        this.tipPompa = builder.tipPompa;
        this.debitApa = builder.debitApa;
        this.senzorUmiditateSol = builder.senzorUmiditateSol;
        this.statieMeteoIntegrata = builder.statieMeteoIntegrata;
        this.modulDozareIngrasamant = builder.modulDozareIngrasamant;
        this.conexiuneSatelit = builder.conexiuneSatelit;
        this.panouSolar = builder.panouSolar;
    }

    public static class SistemIrigatieBuilder implements IBuilder{
        // Atribute obligatorii
        private String idSistem;
        private String tipPompa;
        private float debitApa;

        // Atribute opționale
        private boolean senzorUmiditateSol;
        private boolean statieMeteoIntegrata;
        private boolean modulDozareIngrasamant;
        private boolean conexiuneSatelit;
        private boolean panouSolar;

        public SistemIrigatieBuilder(String idSistem, String tipPompa, float debitApa) {
            this.idSistem = idSistem;
            this.tipPompa = tipPompa;
            this.debitApa = debitApa;
        }

        public SistemIrigatieBuilder setSenzorUmiditateSol(boolean senzorUmiditateSol) {
            this.senzorUmiditateSol = senzorUmiditateSol;
            return this;
        }

        public SistemIrigatieBuilder setStatieMeteoIntegrata(boolean statieMeteoIntegrata) {
            this.statieMeteoIntegrata = statieMeteoIntegrata;
            return this;
        }

        public SistemIrigatieBuilder setModulDozareIngrasamant(boolean modulDozareIngrasamant) {
            this.modulDozareIngrasamant = modulDozareIngrasamant;
            return this;
        }

        public SistemIrigatieBuilder setConexiuneSatelit(boolean conexiuneSatelit) {
            this.conexiuneSatelit = conexiuneSatelit;
            return this;
        }

        public SistemIrigatieBuilder setPanouSolar(boolean panouSolar) {
            this.panouSolar = panouSolar;
            return this;
        }

        @Override
        public SistemIrigatie build() {
            return new SistemIrigatie(this);
        }
    }

    // Metodele din interfață pentru citire (Getteri)
    @Override public String getIdSistem() { return idSistem; }
    @Override public String getTipPompa() { return tipPompa; }
    @Override public float getDebitApa() { return debitApa; }
    @Override public boolean areSenzorUmiditate() { return senzorUmiditateSol; }
    @Override public boolean areStatieMeteo() { return statieMeteoIntegrata; }
    @Override public boolean areDozatorIngrasamant() { return modulDozareIngrasamant; }
    @Override public boolean areConexiuneSatelit() { return conexiuneSatelit; }
    @Override public boolean arePanouSolar() { return panouSolar; }

    @Override
    public void afisareSpecificatii() {
        System.out.println("Sistem [" + idSistem + "] -> Pompă: " + tipPompa + " (" + debitApa + "L/h) | " +
                "Opțiuni: [SenzorUmiditate=" + senzorUmiditateSol + ", StatieMeteo=" + statieMeteoIntegrata +
                ", Dozator=" + modulDozareIngrasamant + ", Satelit=" + conexiuneSatelit +
                ", Solar=" + panouSolar + "]");
    }
}
