package verificare.ex3_composite;

/*
Realizați o aplicație care are rolul de a agrega rezultatele în urma procesului de votare dintr-un referendum.
Voturile sunt înregistrate ca elemente simple la nivel de secții de votare, iar secțiile sunt la rândul lor
încadrate în structuri mai mari (județe). Se dorește o abordare arborescentă pentru a cere cu ușurință situația
voturilor la absolut orice nivel al ierarhiei
 */
public class Main {
    public static void main(String[] args) {
        INodVotare sectia1 = new SectieVotare("Secția Nr. 1 - Școala 12", 1500);
        INodVotare sectia2 = new SectieVotare("Secția Nr. 2 - Liceul de Artă", 2300);

        INodVotare sectia3 = new SectieVotare("Secția Nr. 3 - Primărie", 800);
        INodVotare sectia4 = new SectieVotare("Secția Nr. 4 - Cămin Cultural", 500);

        INodVotare judetBucuresti = new StructuraJudeț("Județul Ilfov & București");
        INodVotare judetCluj = new StructuraJudeț("Județul Cluj");

        judetBucuresti.adaugaNod(sectia1);
        judetBucuresti.adaugaNod(sectia2);
        judetCluj.adaugaNod(sectia3);
        judetCluj.adaugaNod(sectia4);

        INodVotare radacina_romania = new StructuraJudeț("NATIONAL");
        radacina_romania.adaugaNod(judetBucuresti);
        radacina_romania.adaugaNod(judetCluj);
    }
}
