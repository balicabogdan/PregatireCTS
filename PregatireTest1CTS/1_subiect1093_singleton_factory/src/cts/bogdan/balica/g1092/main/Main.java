package cts.bogdan.balica.g1092.main;

import cts.bogdan.balica.g1092.factory.*;
import cts.bogdan.balica.g1092.singleton.DroneConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------SINGLETON-------");
        DroneConnection conexiune = DroneConnection.getInstance();

        conexiune.connect("Bogdan");
        conexiune.connect("Andrei");
        conexiune.connect("Cosmin");

        conexiune.viewConnections();
        System.out.println("este Bogdan conectat? " +conexiune.isConnected("Bogdan"));
        conexiune.disconnect("Andrei");
        conexiune.viewConnections();

        DroneConnection altaConexiune = DroneConnection.getInstance();
        System.out.println("Sunt la fel instantele de conex? " + (conexiune == altaConexiune));

        System.out.println("-------FACTORY-------");
        IModuleFactory fabricaNightVision = new NightVisionFactory();
        AbstractModule modul1 = fabricaNightVision.createModule();

        IModuleFactory fabricaGps = new GpsFactory();
        AbstractModule modul2 = fabricaGps.createModule();

        IModuleFactory fabricaCamera = new CameraFactory();
        AbstractModule modul3 = fabricaCamera.createModule();

        //aici trb tostring si la restul dar imi e lene
        System.out.println("Au fost create modulele: " + modul1 + ", " + modul2 + ", " + modul3);

        GpsTrackingModule gpsCustomizat = (GpsTrackingModule) modul2;
        gpsCustomizat.setAcurateteMetri(2);
    }
}
