package cts.student.examen.g1092.builder;

import cts.student.examen.g1092.prototype.IDeliveryRobot;

public class RobotBatteryPack implements InterfaceRobotBatteryPack{
    private String batteryName;
    private int capacity;
    private float voltage;
    private boolean fastChargeSupport;
    private boolean coolingSystem;
    private boolean shockProtection;
    private boolean wirelessMonitor;
    private boolean extendedWarranty;

    public RobotBatteryPack(BatteryBuilder builder) {
        this.batteryName = builder.batteryName;
        this.capacity = builder.capacity;
        this.voltage = builder.voltage;
        this.fastChargeSupport = builder.fastChargeSupport;
        this.coolingSystem = builder.coolingSystem;
        this.shockProtection = builder.shockProtection;
        this.wirelessMonitor = builder.wirelessMonitor;
        this.extendedWarranty = builder.extendedWarranty;
    }

    public static class BatteryBuilder{
        private String batteryName;
        private int capacity;
        private float voltage;
        private boolean fastChargeSupport;
        private boolean coolingSystem;
        private boolean shockProtection;
        private boolean wirelessMonitor;
        private boolean extendedWarranty;

        public BatteryBuilder(String batteryName, int capacity, float voltage) {
            this.batteryName = batteryName;
            this.capacity = capacity;
            this.voltage = voltage;
        }

        public BatteryBuilder setFastCharge(boolean fastChargeSupport) {
            this.fastChargeSupport = fastChargeSupport;
            return this;
        }

        public BatteryBuilder setCooling(boolean coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public BatteryBuilder setShockProtection(boolean shockProtection) {
            this.shockProtection = shockProtection;
            return this;
        }

        public BatteryBuilder setWireless(boolean wirelessMonitor) {
            this.wirelessMonitor = wirelessMonitor;
            return this;
        }

        public BatteryBuilder setExtendedWarranty(boolean extendedWarranty) {
            this.extendedWarranty = extendedWarranty;
            return this;
        }

        public RobotBatteryPack build() {
            return new RobotBatteryPack(this);
        }
    }

    // --- Implementarea metodelor din interfața InterfaceRobotBatteryPack ---
    @Override public String getBatteryName() { return batteryName; }
    @Override public int getCapacity() { return capacity; }
    @Override public float getVoltage() { return voltage; }
    @Override public boolean hasFastChargeSupport() { return fastChargeSupport; }
    @Override public boolean hasCoolingSystem() { return coolingSystem; }
    @Override public boolean hasShockProtection() { return shockProtection; }
    @Override public boolean hasWirelessMonitor() { return wirelessMonitor; }
    @Override public boolean hasExtendedWarranty() { return extendedWarranty; }

    @Override
    public float getKmRange(IDeliveryRobot robot) {
        // Un calcul simulat simplu cerut de interfață
        return (this.capacity / robot.getTransportCapacity()) * 10;
    }

    @Override
    public String toString() {
        return "RobotBatteryPack{" +
                "batteryName='" + batteryName + '\'' +
                ", capacity=" + capacity +
                ", voltage=" + voltage +
                ", fastChargeSupport=" + fastChargeSupport +
                ", coolingSystem=" + coolingSystem +
                ", shockProtection=" + shockProtection +
                ", wirelessMonitor=" + wirelessMonitor +
                ", extendedWarranty=" + extendedWarranty +
                '}';
    }
}
