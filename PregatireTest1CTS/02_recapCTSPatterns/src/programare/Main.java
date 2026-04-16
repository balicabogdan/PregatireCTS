package programare;


import prototype.ContractCorporate;
import singleton.SingletonEager;
import singleton.SingletonStaticBlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        //------------------------SINGLETON EAGER---------------------
        System.out.println("Incepem testul cu 2 ospatari...");

        // 1. Creăm primul fir de execuție (Ospătarul 1)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Ospătarul 1 cere instanța Singleton
                SingletonEager instanta1 = SingletonEager.getInstance();
                System.out.println("Ospatarul 1 a primit instanta cu ID: " + instanta1.hashCode());
            }
        });

        // 2. Creăm al doilea fir de execuție (Ospătarul 2)
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // Ospătarul 2 cere instanța Singleton
                SingletonEager instanta2 = SingletonEager.getInstance();
                System.out.println("Ospatarul 2 a primit instanta cu ID: " + instanta2.hashCode());
            }
        });

        // 3. Le dăm START! (Atenție la examen: se folosește .start(), NU .run())
        t1.start();
        t2.start();


        //------------------------SingletonStaticBlock---------------------

        SingletonStaticBlock s1 = SingletonStaticBlock.getInstance();
        SingletonStaticBlock s2 = SingletonStaticBlock.getInstance();

        if (s1 == s2) {
            System.out.println("Instante identice versiune static block");
        }

        //------------------------Prototype---------------------

        System.out.println("--- Crearea obiectului ORIGINAL ---");
        // Aici se va afișa mesajul că durează mult, deoarece folosim "new"
        ContractCorporate contractOriginal = new ContractCorporate();

        System.out.println("\n--- Crearea CLONEI ---");
        // Aici NU se va mai afișa mesajul de încărcare, obiectul se creează instant!
        ContractCorporate clonaContract = (ContractCorporate) contractOriginal.clone();

        System.out.println("Clonare realizata cu succes!");
    }
}
