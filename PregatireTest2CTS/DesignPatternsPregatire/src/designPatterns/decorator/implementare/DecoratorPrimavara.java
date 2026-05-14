package designPatterns.decorator.implementare;

/*
Pasul 4: Decoratorul Concret (ConcreteDecorator) Aici facem magia! Moștenim AbstractDecorator
și suprascriem metoda pe care vrem să o alterăm (în cazul nostru, getTotal()).
 */
public class DecoratorPrimavara extends AbstractDecorator {
    private boolean esteFemeie; // addedState-ul de pe diagrama

    public DecoratorPrimavara(IBon bon, boolean esteFemeie) {
        super(bon);
        this.esteFemeie = esteFemeie;
    }

    @Override
    public float getTotal() {
        // 1. Preluam totalul original cerand parintelui sa il calculeze
        float totalInitial = super.getTotal();

        // 2. Adaugam comportamentul/reducerea noastra
        if (esteFemeie) {
            System.out.println("Se aplica reducerea de primavara (10%)!");
            return totalInitial - (totalInitial * 0.1f);
        }
        return totalInitial;
    }
}
