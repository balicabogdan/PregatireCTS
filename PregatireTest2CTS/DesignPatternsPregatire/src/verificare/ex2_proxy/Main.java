package verificare.ex2_proxy;

/*
Vizitarea unei peșteri turistice se face pe bază de bilet. Pentru a optimiza fluxul, s-a dorit etapizarea intrării:
se formează o listă de așteptare într-un modul intermediar, iar abia când se strâng exact 5 persoane pe listă, apelul
 este lăsat să treacă mai departe către obiectivul real pentru a permite vizitarea
 */

public class Main {
    public static void main(String[] args) {
        IPestera pesteraTuristica = new PesteraProxy(new Pestera());

        // Simulăm un flux de turiști [5]
        System.out.println("--- Incepe programul de vizitare ---");

        pesteraTuristica.viziteaza("Ion", true);
        pesteraTuristica.viziteaza("Maria", true);
        pesteraTuristica.viziteaza("Gigel", false); // Va fi respins imediat
        pesteraTuristica.viziteaza("Ana", true);
        pesteraTuristica.viziteaza("Mihai", true);

        // La urmatorul vizitator se fac fix 5, deci Proxy-ul ii va lasa sa intre!
        pesteraTuristica.viziteaza("Elena", true);

        // Acesti doi turisti vor ramane in asteptare (Grup: 2/5) pana mai vin altii
        pesteraTuristica.viziteaza("Vasile", true);
        pesteraTuristica.viziteaza("Ioana", true);
    }
}
