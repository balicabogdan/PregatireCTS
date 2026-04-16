package cts.nume.prenume.gNrGrupa.main;

import cts.nume.prenume.gNrGrupa.builder.IOnlineCourse;
import cts.nume.prenume.gNrGrupa.builder.OnlineCourse;
import cts.nume.prenume.gNrGrupa.singleton.StreamingManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTARE BUILDER ===");

        // 1. Curs de bază (Minimal)
        IOnlineCourse cursBasic = new OnlineCourse.OnlineCourseBuilder("CS-101", "Introducere in Java", 50.0f)
                .build();

        // 2. Curs mediu (Exact 2 opțiuni)
        IOnlineCourse cursMediu = new OnlineCourse.OnlineCourseBuilder("CS-202", "Design Patterns", 150.0f)
                .setMaterialeVideo(true)
                .setQuizInteractiv(true)
                .build();

        // 3. Curs Premium (Toate opțiunile)
        IOnlineCourse cursPremium = new OnlineCourse.OnlineCourseBuilder("CS-999", "Arhitecturi Software Complete", 500.0f)
                .setMaterialeVideo(true)
                .setQuizInteractiv(true)
                .setSuportLive(true)
                .setCertificat(true)
                .setSuportOffline(true)
                .build();

        cursBasic.afisareDetaliiCurs();
        cursMediu.afisareDetaliiCurs();
        cursPremium.afisareDetaliiCurs();


        System.out.println("\n=== TESTARE SINGLETON ===");
        try {
            StreamingManager server = StreamingManager.getInstance();
            System.out.println("Capacitate server: " + server.getMaxAllowedStreams() + " stream-uri simultane.");

            // Pornim 2 stream-uri (Atingem pragul maxim)
            server.startStream(cursBasic.getTitlu());
            server.startStream(cursMediu.getTitlu());
            System.out.println("Stream-uri active curente: " + server.getActiveStreamsCount());
            // Provocăm excepția
            System.out.println("\n-- Încercăm pornirea unui al 3-lea curs --");
            server.startStream(cursPremium.getTitlu()); // AICI PICA SI ARUNCA EXCEPTIA

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Oprim un stream manual fără eroare ca să dovedim refolosirea
        try {
            StreamingManager.getInstance().stopStream(cursBasic.getTitlu());
            System.out.println("Am oprit " + cursBasic.getTitlu() + ". Active curente: " + StreamingManager.getInstance().getActiveStreamsCount());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        StreamingManager.getInstance().displayHistory();
    }
}