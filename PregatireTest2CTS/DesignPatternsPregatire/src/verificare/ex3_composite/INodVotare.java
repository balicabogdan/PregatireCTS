package verificare.ex3_composite;

// =======================================================
// 1. INTERFAȚA COMUNĂ (Component - Nodul din arbore)
// =======================================================
interface INodVotare {
    int calculeazaVoturi();

    void adaugaNod(INodVotare nod);
    void stergeNod(INodVotare nod);
    INodVotare getNod(int index);
}