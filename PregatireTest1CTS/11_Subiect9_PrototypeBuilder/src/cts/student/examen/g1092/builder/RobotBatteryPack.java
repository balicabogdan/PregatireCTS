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

    private RobotBatteryPack(RobotBatteryPackBuilder builder){
        this.batteryName = builder.batteryName;
        this.capacity = builder.capacity;
        this.voltage = builder.voltage;
        this.fastChargeSupport = builder.fastChargeSupport;
        this.coolingSystem = builder.coolingSystem;
        this.shockProtection = builder.shockProtection;
        this.wirelessMonitor = builder.wirelessMonitor;
        this.extendedWarranty = builder.extendedWarranty;

    }

    public static class RobotBatteryPackBuilder implements IBuilder{
        private String batteryName;
        private int capacity;
        private float voltage;

        private boolean fastChargeSupport;
        private boolean coolingSystem;
        private boolean shockProtection;
        private boolean wirelessMonitor;
        private boolean extendedWarranty;

        public RobotBatteryPackBuilder(String batteryName, int capacity, float voltage) {
            this.batteryName = batteryName;
            this.capacity = capacity;
            this.voltage = voltage;
        }

        public RobotBatteryPackBuilder setFastChargeSupport(boolean fastChargeSupport) {
            this.fastChargeSupport = fastChargeSupport;
            return this;
        }

        public RobotBatteryPackBuilder setCoolingSystem(boolean coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        public RobotBatteryPackBuilder setShockProtection(boolean shockProtection) {
            this.shockProtection = shockProtection;
            return this;
        }

        public RobotBatteryPackBuilder setWirelessMonitor(boolean wirelessMonitor) {
            this.wirelessMonitor = wirelessMonitor;
            return this;
        }

        public RobotBatteryPackBuilder setExtendedWarranty(boolean extendedWarranty) {
            this.extendedWarranty = extendedWarranty;
            return this;
        }


        @Override
        public RobotBatteryPack build() {
            return new RobotBatteryPack(this);
        }
    }

    @Override
    public String getBatteryName() {
        return "";
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public float getVoltage() {
        return 0;
    }

    @Override
    public boolean hasFastChargeSupport() {
        return false;
    }

    @Override
    public boolean hasCoolingSystem() {
        return false;
    }

    @Override
    public boolean hasShockProtection() {
        return false;
    }

    @Override
    public boolean hasWirelessMonitor() {
        return false;
    }

    @Override
    public boolean hasExtendedWarranty() {
        return false;
    }

    @Override
    public float getKmRange(IDeliveryRobot robot) {
        return 0;
    }
}
