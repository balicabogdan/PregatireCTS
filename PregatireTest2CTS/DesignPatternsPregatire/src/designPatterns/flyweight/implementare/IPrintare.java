package designPatterns.flyweight.implementare;

//Pasul 2: Interfața Flyweight Conform diagramei, trebuie să definim interfața care primește starea variabilă ca parametru.
public interface IPrintare {
    // operation(extrinsicState) de pe diagrama
    void printareBon(Bon bon);
}