package designPatterns.adapter.implementare2;

public class MicroUSB implements IMicroUSBIncarcator {
    @Override
    public void incarcaPrinMicroUSB() {
        System.out.println("Incarcare prin Micro USB...");
    }
}
