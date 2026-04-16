package singleton;

public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
        System.out.println("Regele a fost trezit (creat)!");
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            // Dacă e null, înseamnă că nimeni nu l-a cerut până acum. Îl creăm!
            instance = new SingletonLazy();
        }
        // Returnăm instanța (fie aia proaspăt creată, fie cea veche)
        return instance;
    }

}
