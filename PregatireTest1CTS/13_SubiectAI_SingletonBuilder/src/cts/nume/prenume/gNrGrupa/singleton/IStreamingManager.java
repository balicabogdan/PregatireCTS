package cts.nume.prenume.gNrGrupa.singleton;

public interface IStreamingManager {
    void startStream(String courseName) throws Exception;
    void stopStream(String courseName) throws Exception;
    int getActiveStreamsCount();
    int getMaxAllowedStreams();
    void displayHistory();
}
