package designPatterns.observer.implementare;

public class Client implements IObserver {
    private String nume;

    public Client(String nume) {
        this.nume = nume;
    }

    @Override
    public void getMesaj(String mesaj) {
        System.out.println(this.nume + ", ai o noua notificare: " + mesaj);
    }
}
