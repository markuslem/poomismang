import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {

        Mängija mängija = new Mängija();


        Sõna arvatavSõna = new Sõna();

        Scanner scanner = new Scanner(System.in);

        mängija.printMehike();

        while (mängija.getElud() > 0) {
            // väljastab lünkliku sõna
            arvatavSõna.väljastaLünklik();

            // kasutaja poolt juba pakutud tähed
            arvatavSõna.prindiKasutatudTähed(); // neid tähti ei saa kasutaja uuesti sisestada

            char täht;
            while (true) { // ootab, et kasutaja sisestaks sobiva sisendi - 1 täht
                System.out.print("Pakkuge täht: ");
                String pakutud = scanner.nextLine();
                if (pakutud.length() == 0) continue;

                täht = Character.toUpperCase(pakutud.charAt(0));
                if (pakutud.length() == 1 && arvatavSõna.tähtSaadaval(täht)) {
                    arvatavSõna.lisaTäht(täht); // Lisame kasutatud tähe pakutud tähtede hulka
                    break;
                } else {
                    System.out.println("Ebakorrektne sisend või täht on juba kasutuses.");
                }
            }


            if (arvatavSõna.tähtKuulubSõnasse(täht)) { // kui pakutakse õige täht
                mängija.lisaPunkte(1);

                // lünkade avamine
                arvatavSõna.avaTäht(täht);

                // kui kõik tähed on ära arvatud, algab mäng uue sõnaga
                if (arvatavSõna.onÕigeSõnaArvatud()) {
                    System.out.println("Arvasite kõik tähed ära!");
                    System.out.println(arvatavSõna.getSuvalineSõna());

                    System.out.println("\n------------------------\n");
                    // elud taastatakse ja hakatakse uut sõna küsima

                    mängija.taastaElud();
                    System.out.println("UUS SÕNA:");
                    arvatavSõna = new Sõna();
                    mängija.printMehike();
                }

            } else { // kui pakutakse valet tähte

                // elu eemaldamine
                mängija.eemaldaElu();
                mängija.printMehike();
            }
        }

        // lõppkokkuvõte
        System.out.print("Sõna oli: ");
        System.out.println(arvatavSõna.getSuvalineSõna());
        System.out.println("Mäng läbi!");
        System.out.println("Punktid: " + mängija.getPunktid());
        scanner.close();

    }
}
