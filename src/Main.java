import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {

        Mängija mängija = new Mängija();

        String rida = FailiLugeja.loeSuvalineRida();
        String sõna = FailiLugeja.eraldaSõna(rida);

        Sõna arvatavSõna = new Sõna(sõna);

        Scanner scanner = new Scanner(System.in);

        while (mängija.getElud() > 0) {
            arvatavSõna.prindiArvatudTähed();

            char täht;
            while (true) {
                System.out.print("Pakkuge täht: ");
                String pakutud = scanner.nextLine();
                täht = Character.toUpperCase(pakutud.charAt(0));
                if (pakutud.length() == 1 && arvatavSõna.tähtSaadaval(täht)) {
                    System.out.println("See on korrektne sisend");
                    arvatavSõna.lisaTäht(täht); // Lisame kasutatud tähe hulka
                    break;
                } else {
                    System.out.println("Ebakorrektne sisend.");
                }
            }

            boolean kuulumine = arvatavSõna.arvaTäht(täht);
            if (kuulumine) {
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
