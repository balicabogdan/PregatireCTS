package designPatterns.composite.implementare;

import java.util.ArrayList;
import java.util.List;

//Pasul 3: Clasa Composite (Structura / Categoria) Asta e o secțiune a meniului (ex: "Băuturi", "Mâncare").
// Ea reține o listă de ANod (sub-categorii sau produse). Aici trebuie să suprascriem metodele de management.

public class Structura extends ANod {
    private String numeStructura;
    // Rombul de pe diagrama - Structura contine o lista de componente generale
    private List<ANod> structura = new ArrayList<>();

    public Structura(String numeStructura) {
        this.numeStructura = numeStructura;
    }

    @Override
    public String getDenumire() {
        return this.numeStructura;
    }

    @Override
    public int getPret() {
        // Un folder/categorie nu are un pret propriu per se in acest scenariu,
        // sau ar putea returna suma preturilor copiilor. La curs s-a cerut doar o exceptie sau 0.
        throw new UnsupportedOperationException("O categorie nu are un pret de sine statator!");
    }

    // Aici implementam metodele de structura
    @Override
    public void adaugaNod(ANod nod) {
        structura.add(nod);
    }

    @Override
    public void stergeNod(ANod nod) {
        structura.remove(nod);
    }

    @Override
    public ANod getChild(int i) {
        return structura.get(i);
    }
}
