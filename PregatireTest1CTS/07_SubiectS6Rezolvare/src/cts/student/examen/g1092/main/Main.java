package cts.student.examen.g1092.main;

import cts.student.examen.g1092.builder.ProductionItem;
import cts.student.examen.g1092.singleton.RawMaterialManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
        RawMaterialManager manager = RawMaterialManager.getInstance();
        System.out.println("Stoc disponibil:" + manager.getAvailableStock());
        manager.addRawMaterial("ABC",10f);
        manager.addRawMaterial("DEF",15.2f);
        System.out.println("Stoc disponibil:" + manager.getAvailableStock());
        manager.consumeRawMaterial("A","pepsi",1.5f);
        manager.consumeRawMaterial("B","2 pepsi",3f);
        System.out.println("Stoc disponibil:" + manager.getAvailableStock());
        manager.consumeRawMaterial("C","Bloc",3000f);

    } catch (Exception e) {
        // Aici va intra pe eroare și afișează excepția
        System.err.println(e.getMessage());
    }
        RawMaterialManager.getInstance().displayHistory();

        System.out.println("\n=== TESTARE BUILDER (Produse asamblate) ===");

        ProductionItem produsMinimal = new ProductionItem.ProductionItemBuilder("model min","min","aer").build();
        ProductionItem produsMediu = new ProductionItem.ProductionItemBuilder("Masa Premium", "SN-200", "Sticlă")
                .setSpecialFinish(true)
                .setPackagingType("Lemn Securizat")
                .build();
        ProductionItem produsMaxim = new ProductionItem.ProductionItemBuilder("Canapea Lux", "SN-300", "Piele")
                .setBatchLabel("Lot-VIP")
                .setPackagingType("Folie Aer")
                .setSpecialFinish(true)
                .setQualityCheck(true)
                .setAssemblyInstructions("Manual Detaliat")
                .setDeliveryPriority("Urgent")
                .build();
        produsMinimal.displayInfo();
        produsMediu.displayInfo();
        produsMaxim.displayInfo();
    }
}