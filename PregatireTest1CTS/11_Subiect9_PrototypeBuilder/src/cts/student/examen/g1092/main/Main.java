package cts.student.examen.g1092.main;

import cts.student.examen.g1092.prototype.DeliveryRobot;
import cts.student.examen.g1092.prototype.IDeliveryRobot;

public class Main {
    public static void main(String[] args) {
        DeliveryRobot deliveryRobot = new DeliveryRobot();
        deliveryRobot.setModel("mod1");
        deliveryRobot.setAutonomy(10);
        deliveryRobot.setMaxSpeed(20);
        deliveryRobot.setTransportCapacity(10f);
        deliveryRobot.addStandardRoute("route1");

        DeliveryRobot prot2 = (DeliveryRobot) deliveryRobot.clone();
        prot2.setAutonomy(5);
        prot2.addStandardRoute("route2");

        deliveryRobot.displayRobotInfo();
        prot2.displayRobotInfo();
    }
}