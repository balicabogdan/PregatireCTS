package cts.nume.prenume.gNrGrupa.singleton;

import java.util.ArrayList;
import java.util.List;

public class StreamingManager implements IStreamingManager{
    private static final StreamingManager instanta = new StreamingManager();

    private int pragMaxim;
    private List<String> istoricOperatii;
    private int activeStreams;

    private StreamingManager() {
        pragMaxim = 2;
        activeStreams = 0;
        istoricOperatii= new ArrayList<>();
    }

    public static StreamingManager getInstance(){
        return instanta;
    }

    @Override
    public void startStream(String courseName) throws Exception {
        if(activeStreams >= pragMaxim){
            throw new Exception("ERROR prag atins!");
        }
        activeStreams++;
        istoricOperatii.add("START: " + courseName);
    }

    @Override
    public void stopStream(String courseName) throws Exception {
        if (activeStreams == 0) {
            throw new Exception("Nu există niciun stream activ pe platformă!");
        }

        activeStreams--;
        istoricOperatii.add("STOP VIDEO: " + courseName);
    }

    @Override public int getActiveStreamsCount() { return activeStreams; }
    @Override public int getMaxAllowedStreams() { return pragMaxim; }

    @Override
    public void displayHistory() {
        System.out.println("=== ISTORIC SERVER STREAMING ===");
        for (String log : istoricOperatii) {
            System.out.println(log);
        }
    }
}
