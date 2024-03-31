import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // mängija isendi loomine
        Mängija mängija = new Mängija();

        // sõna lugemine
        String rida = FailiLugeja.loeSuvalineRida();
        String sõna = FailiLugeja.eraldaSõna(rida);

        Sõna arvatavSõna = new Sõna(sõna);

        Scanner scanner = new Scanner(System.in);


        // nii kaua, kuni sõna ära arvatakse või elud otsa saavad
        while (mängija.getElud() > 0) {// sisendi küsimine
            arvatavSõna.prindiKasutatudTähed();

            char täht; // täht mida pakutakse
            while (true) {
                System.out.print("Pakkuge täht: ");
                String pakutud = scanner.nextLine(); // kasutaja sisend
                täht = Character.toUpperCase(pakutud.charAt(0));
                if (pakutud.length() == 1 && arvatavSõna.tähtSaadaval(täht)) {
                    // sisend on korrektne
                    System.out.println("korrektne");
                    arvatavSõna.lisaTäht(täht);
                    break; // kui programm on saanud korrektse sisendi
                } else {
                    System.out.println("Ebakorrektne sisend.");
                }
            }

            // Sõna klassis kontrollitakse, kas see täht kuulub sõnasse
            // boolean kuulumine = arvatavSõna.kuulub(täht)
            boolean kuulumine = false;
            if (kuulumine) {
                // sõna.avaTäht(täht)
                // sõna.väljastaSõna()
            } else {
                System.out.println("Pakutud täht ei kuulu sõnasse");
                mängija.eemaldaElu();
                mängija.printMehike();
            }
        }

        System.out.println("Punktid: " + mängija.getPunktid());


    }
}
