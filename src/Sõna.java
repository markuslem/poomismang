import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sõna {

    private String suvalineSõna;
    private char[] arvatudTähed;
    private int arvatudTähtedeArv;
    private Set<Character> kasutatudTähed;

    public Sõna(String suvalineSõna) {
        this.suvalineSõna = suvalineSõna;
        this.arvatudTähed = new char[suvalineSõna.length()];

        // Esimene täht antakse ette, ülejäänud tähtede asemel kuvatakse alakriipsud
        arvatudTähed[0] = suvalineSõna.charAt(0);
        for (int i = 1; i < suvalineSõna.length(); i++) {
            arvatudTähed[i] = '_';
        }
        this.arvatudTähtedeArv = 1;

        kasutatudTähed = new HashSet<>();
    }

    public void arvaTäht(char täht) {
        if (täht == suvalineSõna.charAt(arvatudTähtedeArv)) {
            arvatudTähed[arvatudTähtedeArv] = täht;
            arvatudTähtedeArv++;
            System.out.println("Õige! " + String.valueOf(arvatudTähed));
        } else {
            System.out.println("Vale!");
        }
    }

    public void arvaSõna() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Esimene täht: " + arvatudTähed[0]);
        for (int i = 1; i < suvalineSõna.length(); i++) {
            System.out.print("_");
        }
        System.out.println();
        System.out.println("Arva täht:");

        while (arvatudTähtedeArv < suvalineSõna.length()) {
            char sisestatudTäht = scanner.next().charAt(0);
            arvaTäht(sisestatudTäht);
        }

        System.out.println("Edukalt lahendatud. Sõnaks oli: " + suvalineSõna);

        scanner.close();
    }

    public boolean tähtSaadaval(char täht) {
        // kui täht on juba mängija poolt pakutud, siis seda ei saa enam pakkuda
        if (kasutatudTähed.contains(täht))
            return false; // täht on juba kasutuses, ei saa enam kasutada
        else
            return true;
    }

    public void lisaTäht(char täht) {
        // kui täht pakutakse ja see on saadaval
        kasutatudTähed.add(täht);
    }

    public void prindiKasutatudTähed() {
        if (!kasutatudTähed.isEmpty()) // kui on midagi printida
        {// kõikide kasutadu tähtede väljastamine eraldatult tühikuga
            System.out.print("Kasutatud tähed: ");
            kasutatudTähed.forEach(täht -> System.out.print(täht + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        String suvalineSõna = FailiLugeja.loeSuvalineRida();
        String[] osad = suvalineSõna.split("\\s+");
        Sõna mängitavSõna = new Sõna(osad[0]);
        mängitavSõna.arvaSõna();
    }
}
