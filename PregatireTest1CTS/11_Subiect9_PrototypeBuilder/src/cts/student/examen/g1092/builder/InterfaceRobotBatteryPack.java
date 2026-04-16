package cts.student.examen.g1092.builder;

import cts.student.examen.g1092.prototype.IDeliveryRobot;

public interface InterfaceRobotBatteryPack {
    String getBatteryName();
    int getCapacity();
    float getVoltage();
    boolean hasFastChargeSupport();
    boolean hasCoolingSystem();
    boolean hasShockProtection();
    boolean hasWirelessMonitor();
    boolean hasExtendedWarranty();
    float getKmRange(IDeliveryRobot robot);
}