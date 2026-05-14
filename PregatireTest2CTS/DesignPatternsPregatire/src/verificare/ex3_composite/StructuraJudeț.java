package verificare.ex3_composite;

import java.util.ArrayList;
import java.util.List;

// =======================================================
// 3. STRUCTURA (Composite - nivelul de agregare, Județul/Regiunea)
// =======================================================
class StructuraJudeț  implements INodVotare{
    private String numeStructura;
    private List<INodVotare> subNoduri = new ArrayList<>();

    public StructuraJudeț(String numeStructura) {
        this.numeStructura = numeStructura;
    }

    @Override
    public int calculeazaVoturi() {
        int total = 0;
        for(INodVotare nod : subNoduri){
            total += nod.calculeazaVoturi();
        }
        return total;
    }

    @Override
    public void adaugaNod(INodVotare nod) {
        subNoduri.add(nod);
    }

    @Override
    public void stergeNod(INodVotare nod) {
        subNoduri.remove(nod);
    }

    @Override
    public INodVotare getNod(int index) {
        return subNoduri.get(index);
    }

    public String getNume() {
        return numeStructura;
    }
}
