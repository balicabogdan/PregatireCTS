package cts.nume.prenume.gNrGrupa.builder;

public class OnlineCourse implements IOnlineCourse{
    // Atribute obligatorii
    private  String courseId;
    private  String titlu;
    private  float pretDeBaza;

    // Atribute opționale
    private  boolean materialeVideo;
    private  boolean quizInteractiv;
    private  boolean suportLive;
    private  boolean certificat;
    private  boolean suportOffline;

    private OnlineCourse(OnlineCourseBuilder builder){
        this.courseId = builder.courseId;
        this.titlu = builder.titlu;
        this.pretDeBaza = builder.pretDeBaza;
        this.materialeVideo = builder.materialeVideo;
        this.quizInteractiv = builder.quizInteractiv;
        this.suportLive = builder.suportLive;
        this.certificat = builder.certificat;
        this.suportOffline = builder.suportOffline;
    }

    public static class OnlineCourseBuilder implements IBuilder{
        private  String courseId;
        private  String titlu;
        private  float pretDeBaza;

        // Atribute opționale
        private  boolean materialeVideo;
        private  boolean quizInteractiv;
        private  boolean suportLive;
        private  boolean certificat;
        private  boolean suportOffline;

        public OnlineCourseBuilder(String courseId, String titlu, float pretDeBaza){
            this.courseId = courseId;
            this.titlu = titlu;
            this.pretDeBaza = pretDeBaza;
        }

        public OnlineCourseBuilder setMaterialeVideo(boolean materialeVideo) {
            this.materialeVideo = materialeVideo;
            return this;
        }

        public OnlineCourseBuilder setQuizInteractiv(boolean quizInteractiv) {
            this.quizInteractiv = quizInteractiv;
            return this;
        }

        public OnlineCourseBuilder setSuportLive(boolean suportLive) {
            this.suportLive = suportLive;
            return this;
        }

        public OnlineCourseBuilder setCertificat(boolean certificat) {
            this.certificat = certificat;
            return this;
        }

        public OnlineCourseBuilder setSuportOffline(boolean suportOffline) {
            this.suportOffline = suportOffline;
            return this;
        }

        @Override
        public OnlineCourse build() {
            return new OnlineCourse(this);
        }
    }

    // Getteri din IOnlineCourse
    @Override public String getCourseId() { return courseId; }
    @Override public String getTitlu() { return titlu; }
    @Override public float getPretDeBaza() { return pretDeBaza; }
    @Override public boolean areMaterialeVideo() { return materialeVideo; }
    @Override public boolean areQuizInteractiv() { return quizInteractiv; }
    @Override public boolean areSuportLive() { return suportLive; }
    @Override public boolean areCertificat() { return certificat; }
    @Override public boolean areSuportOffline() { return suportOffline; }

    @Override
    public void afisareDetaliiCurs() {
        System.out.println("Curs [" + courseId + "] " + titlu + " (" + pretDeBaza + " RON) " +
                "| Video:" + materialeVideo + " | Quiz:" + quizInteractiv +
                " | Live:" + suportLive + " | Certificat:" + certificat + " | Offline:" + suportOffline);
    }
}
