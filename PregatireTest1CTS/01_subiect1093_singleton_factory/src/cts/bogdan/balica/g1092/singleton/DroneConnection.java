package cts.bogdan.balica.g1092.singleton;

import java.util.ArrayList;
import java.util.List;

public class DroneConnection implements IDroneConnection{
    private static DroneConnection insantaUnica = new DroneConnection();

    private List<String> utilizatoriConectati;

    private DroneConnection(){
        this.utilizatoriConectati = new ArrayList<>();
    }

    public static DroneConnection getInstance(){
        return insantaUnica;
    }


    @Override
    public void connect(String userName) {
        if(!utilizatoriConectati.contains(userName)){
            utilizatoriConectati.add(userName);
            System.out.println("Utilizatorul " + userName+ " s-a conectat la drona.");
        }
        else{
            System.out.println("Utilizatorul " + userName+ " este conectat deja la drona.");
        }
    }

    @Override
    public void disconnect(String userName) {
        if(utilizatoriConectati.contains(userName)){
            utilizatoriConectati.remove(userName);
            System.out.println("Utilizatorul " + userName+ " s-a deconectat de la drona.");
        }
        else{
            System.out.println("Utilizatorul " + userName+ " nu era conectat la drona.");
        }
    }

    @Override
    public boolean isConnected(String userName) {
        if(utilizatoriConectati.contains(userName)){
            return true;
        }
        return false;
    }

    @Override
    public void viewConnections() {
        System.out.println("Conexiuni active la drona: " + utilizatoriConectati.size());
        for(String user : utilizatoriConectati){
            System.out.println("- " + user);
        }
    }
}
