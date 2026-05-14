package designPatterns.composite.implementare;

// Reprezinta interfața comună (Component) de pe diagrama
public abstract class ANod {
    // Metode specifice oricarui element din meniu
    public abstract String getDenumire();
    public abstract int getPret();

    // Metode specifice DOAR nodurilor de tip Structura (pentru a adauga/sterge sub-elemente)
    // Le aruncam UnsupportedOperationException implicit, ca Frunzele sa nu fie obligate sa le scrie.
    public void adaugaNod(ANod nod) {
        throw new UnsupportedOperationException("Nu se poate adauga un nod!");
    }
    public void stergeNod(ANod nod) {
        throw new UnsupportedOperationException("Nu se poate sterge un nod!");
    }
    public ANod getChild(int i) {
        throw new UnsupportedOperationException("Acest nod nu are copii!");
    }
}
