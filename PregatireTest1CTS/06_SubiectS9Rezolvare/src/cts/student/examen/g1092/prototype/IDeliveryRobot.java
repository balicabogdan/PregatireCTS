package cts.student.examen.g1092.prototype;

public interface IDeliveryRobot {
    String getModel();
    float getTransportCapacity();
    int getAutonomy();
    float getMaxSpeed();
    void setModel(String model);
    void setTransportCapacity(float capacity);
    void setAutonomy(int autonomy);
    void setMaxSpeed(float maxSpeed);
    void addStandardRoute(String route);
    void displayRobotInfo();
}