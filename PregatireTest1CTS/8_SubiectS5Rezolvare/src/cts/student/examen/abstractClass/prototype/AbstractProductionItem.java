package cts.student.examen.abstractClass.prototype;

import java.util.ArrayList;
import java.util.List;

// 1. Clasa abstractă implementează direct Cloneable [1, 2]
public abstract class AbstractProductionItem implements Cloneable {

    protected String modelName;
    protected String serialCode;
    protected String batchLabel;
    protected String packagingType;
    protected List<String> componente;

    // 2. Suprascrierea metodei clone() cu super.clone() si Deep Copy [3]
    @Override
    public Object clone() {
        try {
            // Magia Java: Copiază obiectul instant fără a apela vreun constructor
            AbstractProductionItem clona = (AbstractProductionItem) super.clone();

            // DEEP COPY OBLIGATORIU pentru lista de componente [3]
            clona.componente = new ArrayList<>();
            for (String comp : this.componente) {
                clona.componente.add(comp);
            }

            return clona;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Setteri PENTRU PARTICULARIZAREA CLONEI (Cerință S5)
    public void setSerialCode(String serialCode) { this.serialCode = serialCode; }
    public void setBatchLabel(String batchLabel) { this.batchLabel = batchLabel; }
    public void setPackagingType(String packagingType) { this.packagingType = packagingType; }
    public void addComponenta(String comp) { this.componente.add(comp); }

    // Metodă abstractă pe care o vor implementa copiii
    public abstract void displayInfo();
}