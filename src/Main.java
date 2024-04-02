import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        /*String suvalineSõna;
        try {
            suvalineSõna = FailiLugeja.eraldaSõna(FailiLugeja.loeSuvalineRida()).toUpperCase(); // Teisendame loetud sõna suurtähtedeks
            Sõna mängitavSõna = new Sõna(suvalineSõna);
            mängitavSõna.arvaSõna();
        } catch (Exception e) {
            System.out.println("Viga faili lugemisel: " + e.getMessage());
        }*/

        // mängija isendi loomine
        Mängija mängija = new Mängija();

        // sõna lugemine
        String rida = FailiLugeja.loeSuvalineRida();
        String sõna = FailiLugeja.eraldaSõna(rida);

        Sõna arvatavSõna = new Sõna(sõna); // sõna isend - iga sõna kohta uus isend

        Scanner scanner = new Scanner(System.in);


        // nii kaua, kuni sõna ära arvatakse või elud otsa saavad
        while (mängija.getElud() > 0) {// sisendi küsimine
            arvatavSõna.prindiKasutatudTähed();

            char täht; // täht mida pakutakse
            while (true) {

                // kontrollib, kas sisend on korrektne
                System.out.print("Pakkuge täht: ");
                String pakutud = scanner.nextLine(); // kasutaja sisend
                täht = Character.toUpperCase(pakutud.charAt(0));
                if (pakutud.length() == 1 && arvatavSõna.tähtSaadaval(täht)) {
                    // sisend on korrektne
                    // st tähte ei ole enne pakutud ja sisendi pikkus on 1
                    System.out.println("See on korrektne sisend");
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
                mängija.lisaPunkte(100);
            } else {
                System.out.println("Pakutud täht ei kuulu sõnasse");
                mängija.eemaldaElu();
                mängija.printMehike();
            }
        }

        System.out.println("Punktid: " + mängija.getPunktid());
        scanner.close();

    }
}
