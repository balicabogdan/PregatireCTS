package designPatterns.adapter.implementare1;

public class EvaluareClientFirmaB implements IEvaluareClientFirmaB {
    @Override
    public void analizaClientFirmaB(Client client) {
        System.out.println("Tehnica evaluare firma B");
    }
}
