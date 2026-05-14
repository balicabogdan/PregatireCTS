package designPatterns.adapter.implementare1;

public class EvaluareClientFirmaA implements IEvaluareClientFirmaA {
    @Override
    public void analizaClientFirmaA(int costTotalEvenimente) {
        System.out.println("Metoda analiza client Firma A pentru costul: " + costTotalEvenimente);
    }
}
