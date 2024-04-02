import java.util.HashSet;
import java.util.Set;

public class Sõna {

    private String suvalineSõna;
    private char[] arvatudTähed; // Sisaldab sõna kujul R_T__ st 1. täht ja arvatud täht
    private Set<Character> pakutudTähed;

    public Sõna(String suvalineSõna) {
        this.suvalineSõna = suvalineSõna.toUpperCase();
        this.arvatudTähed = new char[suvalineSõna.length()];
        this.pakutudTähed = new HashSet<>();

        for (int i = 0; i < suvalineSõna.length(); i++) {
            if (i == 0) {
                arvatudTähed[i] = Character.toUpperCase(suvalineSõna.charAt(i));
            } else {
                arvatudTähed[i] = '_';
            }
        }
    }

    public boolean arvaTäht(char täht) {
        täht = Character.toUpperCase(täht);
        boolean õige = false;
        pakutudTähed.add(täht);
        for (int i = 0; i < suvalineSõna.length(); i++) {
            if (Character.toUpperCase(suvalineSõna.charAt(i)) == täht && arvatudTähed[i] == '_') {
                arvatudTähed[i] = täht;
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
            System.out.println("Vale! " + String.valueOf(arvatudTähed));
        }
        return õige;
    }

    public boolean onÕigeSõnaArvatud() {
        for (char täht : arvatudTähed) {
            if (täht == '_') {
                return false;
            }
        }
        return true;
    }

    public void prindiArvatudTähed() {
        System.out.print("Kasutatud tähed: ");
        for (char täht : pakutudTähed) {
            System.out.print(täht + " ");
        }
        System.out.println();
    }

    public void lisaTäht(char täht) {
        pakutudTähed.add(täht);
    }

    public boolean tähtSaadaval(char täht) {
        // kui täht on juba mängija poolt pakutud, siis seda ei saa enam pakkuda
        return !pakutudTähed.contains(täht);
    }
}
