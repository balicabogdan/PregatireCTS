package cts.nume.prenume.gNrGrupa.singleton;

public interface IProductionLineControl {
    void startLine(String employeeId) throws Exception;
    void stopLine(String employeeId) throws Exception;
    void setWorkingSpeed(String employeeId, int speed) throws Exception;
    void setOperatingMode(String employeeId, String mode) throws Exception;
    void addTechnologicalStep(String employeeId, String step) throws Exception;
}
