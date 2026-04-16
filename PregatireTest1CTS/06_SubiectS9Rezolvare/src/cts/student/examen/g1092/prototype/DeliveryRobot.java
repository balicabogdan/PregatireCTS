package cts.student.examen.g1092.prototype;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRobot implements IDeliveryRobot, Cloneable{
    private String model;
    private float capacitateTransport;
    private int autonomie;
    private float vitezaMax;
    private String tipSenzor;
    private List<String> ruteStandard;

    public DeliveryRobot(String model) {
        this.model = model;
        this.ruteStandard = new ArrayList<>();
    }

    @Override public String getModel() { return model; }
    @Override public float getTransportCapacity() { return capacitateTransport; }
    @Override public int getAutonomy() { return autonomie; }
    @Override public float getMaxSpeed() { return vitezaMax; }

    @Override public void setModel(String model) { this.model = model; }
    @Override public void setTransportCapacity(float capacity) { this.capacitateTransport = capacity; }
    @Override public void setAutonomy(int autonomy) { this.autonomie = autonomy; }
    @Override public void setMaxSpeed(float maxSpeed) { this.vitezaMax = maxSpeed; }

    @Override
    public void addStandardRoute(String route) {
        this.ruteStandard.add(route);
    }

    @Override
    public void displayRobotInfo() {
        System.out.println("Robot " + model + " | Rute: " + ruteStandard);
    }

    @Override
    public Object clone(){
            DeliveryRobot clona = new DeliveryRobot(this.model);
            clona.capacitateTransport = this.capacitateTransport;
            clona.autonomie = this.autonomie;
            clona.vitezaMax = this.vitezaMax;

            clona.ruteStandard = new ArrayList<>();
            for(String ruta : this.ruteStandard){
                clona.ruteStandard.add(ruta);
            }
            return clona;

    }
}
