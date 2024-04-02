import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sõna {

    private String suvalineSõna;
    private char[] arvatudTähed;
    private Set<Character> kasutatudTähed;

    public Sõna(String suvalineSõna) {
        this.suvalineSõna = suvalineSõna.toUpperCase(); // Teisendame kogu sõna suurtähtedeks
        this.arvatudTähed = new char[suvalineSõna.length()];

        for (int i = 0; i < suvalineSõna.length(); i++) {
            if (i == 0) {
                arvatudTähed[i] = Character.toUpperCase(suvalineSõna.charAt(i)); // Esimene täht suurtäheks
            } else {
                arvatudTähed[i] = '_'; // Kõik teised tähed "_" tähed
            }
        }

        kasutatudTähed = new HashSet<>();
    }

    public void arvaTäht(char täht) {
        täht = Character.toUpperCase(täht); // Konverteerime sisestatud tähe suurtäheks
        boolean õige = false;
        for (int i = 0; i < suvalineSõna.length(); i++) {
            if (Character.toUpperCase(suvalineSõna.charAt(i)) == täht && arvatudTähed[i] == '_') {
                arvatudTähed[i] = täht; // Kui sisestatud täht on sõnas ja koht on tühi, siis asendame "_" tähega
                õige = true;
            }
        }
        if (õige) {
            if (onÕigeSõnaArvatud()) {
                System.out.println("Õige! " + suvalineSõna);
                System.exit(0);
            } else {
                System.out.println("Õige! " + String.valueOf(arvatudTähed));
            }
        } else {
            System.out.println("Vale!");
        }
    }

    public boolean tähtSaadaval(char täht) {
        täht = Character.toUpperCase(täht);
        return kasutatudTähed.contains(täht);
    }

    public void lisaTäht(char täht) {
        täht = Character.toUpperCase(täht);
        kasutatudTähed.add(täht);
    }

    public boolean onÕigeSõnaArvatud() {
        for (char täht : arvatudTähed) {
            if (täht == '_') {
                return false;
            }
        }
        return true;
    }

    public void arvaSõna() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Alguses: ");
        for (int i = 0; i < suvalineSõna.length(); i++) {
            System.out.print(arvatudTähed[i]);
        }
        System.out.println();

        while (true) {
            System.out.println("Arva täht või sisesta 'lõpeta' sõna lõpetamiseks:");
            String sisend = scanner.nextLine();
            if (sisend.equalsIgnoreCase("lõpeta")) {
                break;
            }
            if (sisend.length() != 1) {
                System.out.println("Palun sisesta ainult üks täht!");
                continue;
            }
            char sisestatudTäht = sisend.charAt(0);
            sisestatudTäht = Character.toUpperCase(sisestatudTäht); // Teisendame sisestatud tähe suurtäheks
            if (tähtSaadaval(sisestatudTäht)) {
                System.out.println("See täht on juba kasutatud!");
                continue;
            }
            arvaTäht(sisestatudTäht);
            lisaTäht(sisestatudTäht);
            prindiKasutatudTähed();
        }

        System.out.println("Edukalt lõpetatud. Sõnaks oli: " + suvalineSõna);

        scanner.close();
    }

    public void prindiKasutatudTähed() {
        System.out.print("Kasutatud tähed: ");
        for (char c : kasutatudTähed) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
