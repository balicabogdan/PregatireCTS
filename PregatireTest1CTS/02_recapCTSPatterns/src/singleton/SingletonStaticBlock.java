package singleton;

public class SingletonStaticBlock {
    private static SingletonStaticBlock instance;

    private SingletonStaticBlock() {
        System.out.println("S-a creat instanta din Static Block!");
    }

    static {
        try {
            // Aici construim "Regele"
            instance = new SingletonStaticBlock();
        } catch (Exception e) {
            System.out.println("Eroare la crearea Singleton-ului!");
        }
    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
