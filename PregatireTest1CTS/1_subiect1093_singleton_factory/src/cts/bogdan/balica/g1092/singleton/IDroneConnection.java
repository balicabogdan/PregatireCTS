package cts.bogdan.balica.g1092.singleton;

public interface IDroneConnection {
    void connect(String userName);
    void disconnect(String userName);
    boolean isConnected(String userName);
    void viewConnections();
}
