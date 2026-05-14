package designPatterns.strategy;

import java.util.List;

// Strategia 1: Cauta meniul cu cele mai putine calorii
public class StrategieCaloriiMinim implements IProcesabil {
    @Override
    public OfertaMeniu alegereMeniu(List<OfertaMeniu> listaMeniuri) {
        OfertaMeniu ofertaMeniuCaloriiMinime = listaMeniuri.get(0);

        for(OfertaMeniu oferta : listaMeniuri) {
            if(oferta.getNrCalorii() < ofertaMeniuCaloriiMinime.getNrCalorii()) {
                ofertaMeniuCaloriiMinime = oferta;
            }
        }
        return ofertaMeniuCaloriiMinime;
    }
}

