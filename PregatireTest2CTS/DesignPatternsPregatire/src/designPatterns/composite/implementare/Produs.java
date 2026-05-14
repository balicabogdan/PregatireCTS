package designPatterns.composite.implementare;

//Pasul 2: Clasa Leaf (Frunza / Elementul Simplu) Acesta este produsul final (ex: o Pizza, un Suc).
// El știe doar prețul și denumirea lui, nu poate conține alte produse.
public class Produs extends ANod {
    private String denumire;
    private int pret;

    public Produs(String denumire, int pret) {
        this.denumire = denumire;
        this.pret = pret;
    }

    @Override
    public String getDenumire() {
        return this.denumire;
    }

    @Override
    public int getPret() {
        return this.pret;
    }
    // Nu suprascriem add/remove/getChild, asa ca daca cineva le apeleaza pe o Frunza, va primi eroare (corect!).
}
