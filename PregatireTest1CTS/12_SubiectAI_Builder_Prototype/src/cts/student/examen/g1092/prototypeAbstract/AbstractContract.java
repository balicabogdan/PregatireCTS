package cts.student.examen.g1092.prototypeAbstract;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContract implements Cloneable{
    // Folosim protected ca să fie vizibile în clasele copil [1]
    protected String tip;
    protected List<String> listaClauze;

    // 2. Implementarea metodei clone() pentru a realiza Deep Copy [3]
    @Override
    public Object clone() {
        try {
            // Copiază primitivele FĂRĂ a apela constructorul "greu"
            AbstractContract clona = (AbstractContract) super.clone();

            // Deep Copy pentru a proteja lista (așa cum am stabilit)
            clona.listaClauze = new ArrayList<>(this.listaClauze);

            return clona;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Eroare la clonare", e);
        }
    }

    // Metode de business
    public void adaugaClauza(String clauza) {
        this.listaClauze.add(clauza);
    }

    public abstract void printare();
}
