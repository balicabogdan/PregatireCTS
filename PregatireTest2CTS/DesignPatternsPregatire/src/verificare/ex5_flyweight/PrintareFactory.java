package verificare.ex5_flyweight;

import java.util.HashMap;
import java.util.Map;

class MesajPrintareFactory {
    private static Map<String, IPrintare> colectieMesaje = new HashMap<>();

    public static IPrintare getMesajPrintare(String tipPrintare, String mesaj) {
        if (!colectieMesaje.containsKey(tipPrintare)) {
            colectieMesaje.put(tipPrintare, new MesajPrintare(tipPrintare, mesaj));
        }
        return colectieMesaje.get(tipPrintare);
    }
}