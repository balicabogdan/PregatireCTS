package cts.student.examen.abstractClass.singleton;

public class ProductionLine implements IProductionLineControl {
    private static final ProductionLine uniqueInstance = new ProductionLine();

    private String activeEmployeeId;
    private int activeSpeed;

    private ProductionLine() {
        this.activeEmployeeId = null;
        this.activeSpeed = 0;
    }

    public static ProductionLine getInstance(){
        return uniqueInstance;
    }

    @Override
    public void startLine(String employeeId) throws Exception {

        if (activeEmployeeId != null) {
            throw new Exception("Eroare: Linia este ocupată de angajatul " + activeEmployeeId);
        }

        this.activeEmployeeId = employeeId;
        System.out.println("START: Linia a fost pornită de " + employeeId);
    }

    @Override
    public void stopLine(String employeeId) throws Exception {
        if (activeEmployeeId == null || !activeEmployeeId.equals(employeeId)) {
            throw new Exception("Eroare: Nu ai dreptul să oprești linia!");
        }
        this.activeEmployeeId = null;
        System.out.println("STOP: Linia a fost oprită.");
    }

    @Override
    public void setWorkingSpeed(String employeeId, int speed) throws Exception {
        if (activeEmployeeId == null || !activeEmployeeId.equals(employeeId)) {
            throw new Exception("Eroare de acces!");
        }
        this.activeSpeed = speed;
    }

    @Override
    public void setOperatingMode(String employeeId, String mode) throws Exception {
        if (activeEmployeeId == null || !activeEmployeeId.equals(employeeId)) {
            throw new Exception("Eroare de acces!");
        }
        // logica
    }
}
