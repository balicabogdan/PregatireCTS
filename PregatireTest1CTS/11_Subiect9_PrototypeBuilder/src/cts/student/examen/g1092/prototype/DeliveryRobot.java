package cts.student.examen.g1092.prototype;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRobot implements IDeliveryRobot, Cloneable{

    private String model;
    private float transportCapacity;
    private int autonomy;
    private float maxSpeed;
    private List<String> standardRoutes; // Lista problematica la clonare

    public DeliveryRobot() {
        System.out.println("Se incarca rutele din satelit pentru modelul " + model + "... dureaza!");
        this.standardRoutes = new ArrayList<>();
    }

    @Override
    public Object clone() {
        DeliveryRobot clona = null;
        try {
            clona = (DeliveryRobot) super.clone();

            clona.model = this.model;
                clona.transportCapacity = this.transportCapacity;
                clona.autonomy = this.autonomy;
                clona.maxSpeed = this.maxSpeed;

                clona.standardRoutes = new ArrayList<>(this.standardRoutes);
    //            clona.standardRoutes = new ArrayList<>();
    //            for(String route : this.standardRoutes){
    //                clona.standardRoutes.add(route);
    //            }
                return clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Eroare la clonare", e);
        }
    }


    @Override public String getModel() { return model; }
    @Override public float getTransportCapacity() { return transportCapacity; }
    @Override public int getAutonomy() { return autonomy; }
    @Override public float getMaxSpeed() { return maxSpeed; }

    @Override public void setModel(String model) { this.model = model; }
    @Override public void setTransportCapacity(float capacity) { this.transportCapacity = capacity; }
    @Override public void setAutonomy(int autonomy) { this.autonomy = autonomy; }
    @Override public void setMaxSpeed(float maxSpeed) { this.maxSpeed = maxSpeed; }

    @Override
    public void addStandardRoute(String route) {
        this.standardRoutes.add(route);
    }

    @Override
    public void displayRobotInfo() {
        System.out.println( "DeliveryRobot{" +
                "model='" + model + '\'' +
                ", transportCapacity=" + transportCapacity +
                ", autonomy=" + autonomy +
                ", maxSpeed=" + maxSpeed +
                ", standardRoutes=" + standardRoutes +
                '}');
    }

}
