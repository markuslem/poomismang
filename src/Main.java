import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        Mängija mängija = new Mängija();



        Sõna arvatavSõna = new Sõna();

        Scanner scanner = new Scanner(System.in);

        while (mängija.getElud() > 0) {
            // väljastab lünkliku sõna
            arvatavSõna.väljastaLünklik();

            // kasutaja poolt juba pakutud tähed
            arvatavSõna.prindiKasutatudTähed(); // neid tähti ei saa kasutaja uuesti sisestada

            char täht;
            while (true) {
                System.out.print("Pakkuge täht: ");
                String pakutud = scanner.nextLine();
                täht = Character.toUpperCase(pakutud.charAt(0));
                if (pakutud.length() == 1 && arvatavSõna.tähtSaadaval(täht)) {
                    arvatavSõna.lisaTäht(täht); // Lisame kasutatud tähe pakutud tähtede hulka
                    break;
                } else {
                    System.out.println("Ebakorrektne sisend või täht on juba kasutuses.");
                }
            }


            if (arvatavSõna.tähtKuulubSõnasse(täht)) {
                mängija.lisaPunkte(1);

                // lünkade avamine
                arvatavSõna.avaTäht(täht);

                if (arvatavSõna.onÕigeSõnaArvatud()) {
                    // kõik tähed on ära arvatud
                    System.out.println("Arvasite kõik tähed ära!");
                    System.out.println(arvatavSõna.getSuvalineSõna());

                    System.out.println("\n------------------------\n");

                    mängija.taastaElud();
                    System.out.println("UUS SÕNA:");
                    arvatavSõna = new Sõna();
                }

            } else {

                // elu eemaldamine
                mängija.eemaldaElu();
                mängija.printMehike();
            }
        }

        System.out.print("Sõna oli: ");
        System.out.println(arvatavSõna.getSuvalineSõna());
        System.out.println("Mäng läbi!");
        System.out.println("Punktid: " + mängija.getPunktid());
        scanner.close();

    }
}
