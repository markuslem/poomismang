import java.util.Scanner;

public class Sõna {

    private String suvalineSõna;
    private char[] arvatudTähed;
    private int arvatudTähtedeArv;

    public Sõna(String suvalineSõna) {
        this.suvalineSõna = suvalineSõna;
        this.arvatudTähed = new char[suvalineSõna.length()];

        // Esimene täht antakse ette, ülejäänud tähtede asemel kuvatakse alakriipsud
        arvatudTähed[0] = suvalineSõna.charAt(0);
        for (int i = 1; i < suvalineSõna.length(); i++) {
            arvatudTähed[i] = '_';
        }
        this.arvatudTähtedeArv = 1;
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

    public static void main(String[] args) throws Exception {
        String suvalineSõna = FailiLugeja.loeSuvalineRida();
        String[] osad = suvalineSõna.split("\\s+");
        Sõna mängitavSõna = new Sõna(osad[0]);
        mängitavSõna.arvaSõna();
    }
}
