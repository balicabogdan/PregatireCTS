package designPatterns.strategy;

import java.util.List;

public interface IProcesabil {
    // Returneaza oferta potrivita dintr-o lista, in functie de strategie
    OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri);
}
