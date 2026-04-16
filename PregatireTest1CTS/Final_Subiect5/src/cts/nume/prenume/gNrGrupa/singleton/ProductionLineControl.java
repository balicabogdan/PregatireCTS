package cts.nume.prenume.gNrGrupa.singleton;

public class ProductionLineControl implements IProductionLineControl{
    private static final ProductionLineControl instantaUnica = new ProductionLineControl();

    private String activeEmployeeID;
    private int activeSpeed;

    private ProductionLineControl(){
        activeSpeed = 0;
        activeEmployeeID = null;
    }

    public static ProductionLineControl getInstance(){
        return instantaUnica;
    }

    @Override
    public void startLine(String employeeId) throws Exception {
        if(activeEmployeeID != null){
            throw new Exception("Linia este ocupata de " + activeEmployeeID);
        }
        activeEmployeeID = employeeId;
    }

    @Override
    public void stopLine(String employeeId) throws Exception {
        if(activeEmployeeID == null){
            throw new Exception("Linia nu este ocupata de nimeni");
        }
        activeEmployeeID = null;
    }

    @Override
    public void setWorkingSpeed(String employeeId, int speed) throws Exception {
        if(!employeeId.equals(activeEmployeeID)){
            throw new Exception("Linia este ocupata de " + activeEmployeeID);
        }
        activeSpeed = speed;
    }

    @Override
    public void setOperatingMode(String employeeId, String mode) throws Exception {

    }

    @Override
    public void addTechnologicalStep(String employeeId, String step) throws Exception {

    }
}
