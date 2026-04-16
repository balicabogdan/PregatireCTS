package prototype;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContract implements Cloneable{
    protected String id;
    protected String tip;
    protected List<String> listaClauze; // Atributul "problematic" la clonare

    @Override
    protected Object clone(){
        AbstractContract clona = null;
        try{
            clona = (AbstractContract) super.clone();
            clona.listaClauze = new ArrayList<>(this.listaClauze);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clona;
    }
}
