package designPatterns.adapter.main;

import designPatterns.adapter.implementare2.Adaptor;
import designPatterns.adapter.implementare2.IMicroUSBIncarcator;
import designPatterns.adapter.implementare2.IUSBcIncarcator;
import designPatterns.adapter.implementare2.MicroUSB;

/*
Un telefon acceptă doar încărcare prin USB-C (chargeUSBc()), însă utilizatorul are doar un încărcător vechi Micro-USB
(chargeMicroUsb()). Se cere realizarea unui adaptor care să permită încărcarea telefonului cu încărcătorul existent
 */
public class Main {
    public static void main(String[] args) {
        IMicroUSBIncarcator incarcatorVechi = new MicroUSB();
        IUSBcIncarcator adaptor = new Adaptor(incarcatorVechi);
        adaptor.incarcarePrinUSBc();
    }
}
