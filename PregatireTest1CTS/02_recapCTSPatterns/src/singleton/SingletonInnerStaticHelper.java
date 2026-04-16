package singleton;

public class SingletonInnerStaticHelper {

    // Pasul 1: Constructorul privat (Regula de aur, ca la toate variantele de Singleton)
    private SingletonInnerStaticHelper() {
        System.out.println("Regele a fost creat folosind Inner Static Helper!");
    }

    // Pasul 2: Clasa internă statică (Helper-ul)
    // Java ignoră complet această mini-clasă la pornirea programului.
    // Ea va fi "citită" doar când cineva o strigă.
    private static class Helper {
        // Aici dăm "new". E un fel de Eager, dar ascuns în interior!
        private static final SingletonInnerStaticHelper INSTANCE = new SingletonInnerStaticHelper();
    }

    // Pasul 3: Poarta de acces
    // Când primul ospătar apelează metoda, abia atunci Java vede clasa "Helper"
    // și creează INSTANCE o singură dată.
    public static SingletonInnerStaticHelper getInstance() {
        return Helper.INSTANCE;
    }
}
