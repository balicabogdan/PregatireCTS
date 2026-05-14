package preg1.decorator;

// =======================================================
// 1. COMPONENTA DE BAZĂ (Interfața și implementarea veche)
// =======================================================
interface IPizza {
    float getPret();
    void descriere();
}

// Aceasta este clasa existenta pe care NU avem voie sa o modificam
class PizzaVegetariana implements IPizza {
    @Override
    public float getPret() {
        return 30.0f; // pretul de baza
    }

    @Override
    public void descriere() {
        System.out.print("Pizza Vegetariana clasica");
    }
}

// =======================================================
// 2. DECORATORUL ABSTRACT (Clasa esentiala de delegare)
// =======================================================
abstract class ADecoratorPizza implements IPizza {
    // Rombul de pe diagrama: Decoratorul DETINE o referinta catre componenta
    protected IPizza pizzaDecorata;

    public ADecoratorPizza(IPizza pizza) {
        this.pizzaDecorata = pizza;
    }

    // Metodele doar deaga/paseaza actiunea mai departe catre obiectul real
    @Override
    public float getPret() {
        return pizzaDecorata.getPret();
    }

    @Override
    public void descriere() {
        pizzaDecorata.descriere();
    }
}

// =======================================================
// 3. DECORATORUL CONCRET (Adauga optiunea de "Crown")
// =======================================================
class DecoratorCrown extends ADecoratorPizza{
    public DecoratorCrown(IPizza pizza) {
        super(pizza);
    }

    @Override
    public float getPret() {
        // Preia pretul de baza al pizzei decorate si adauga inca 10 lei
        return super.getPret() + 10.0f;
    }

    @Override
    public void descriere() {
        // Preia descrierea de baza si adauga informatia noua
        super.descriere();
        System.out.print(" + margine cu branza (Optiunea Crown)");
    }
}

// =======================================================
// 4. Testarea (Clasa publica principala)
// =======================================================
public class Main {
    public static void main(String[] args) {
        IPizza pizzaSimpla = new PizzaVegetariana();
        pizzaSimpla.descriere();
        System.out.println(" | Cost: " + pizzaSimpla.getPret() + " LEI");

        IPizza pizzaCuMargineBranza = new DecoratorCrown(pizzaSimpla);
        pizzaCuMargineBranza.descriere();
        System.out.println(" | Cost: " + pizzaCuMargineBranza.getPret() + " LEI");
    }
}
