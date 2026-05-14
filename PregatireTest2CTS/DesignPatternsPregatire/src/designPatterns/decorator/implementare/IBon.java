package designPatterns.decorator.implementare;

/*
Pasul 1: Interfața de bază (Component-ul) Aceasta definește ce poate face un bon în mod normal.
 */
public interface IBon {
    float getTotal();
    void printare();
    void adaugaProdus(float pret);
}