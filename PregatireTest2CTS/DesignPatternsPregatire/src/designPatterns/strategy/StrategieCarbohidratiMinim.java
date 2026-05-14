package designPatterns.strategy;

import java.util.List;

// Strategia 2: Cauta meniul cu cei mai putini carbohidrati
public class StrategieCarbohidratiMinim implements IProcesabil {
    @Override
    public OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri) {
        OfertaMeniu ofertaMeniuCarbohidratiMinim = listaMeniuri.get(0);

        for(OfertaMeniu oferta : listaMeniuri) {
            if(oferta.getNrCarbohidrati() < ofertaMeniuCarbohidratiMinim.getNrCarbohidrati()) {
                ofertaMeniuCarbohidratiMinim = oferta;
            }
        }
        return ofertaMeniuCarbohidratiMinim;
    }
}
