import java.util.HashSet;
import java.util.Set;

public class Sõna {

    private String suvalineSõna;
    private char[] arvatudTähed; // Sisaldab sõna kujul R_T__ st 1. täht ja arvatud täht
    private Set<Character> pakutudTähed;

    public Sõna() throws Exception {
        // sõna isendi loomisel loetakse failist uus sõna

        String rida = FailiLugeja.loeSuvalineRida();
        suvalineSõna= FailiLugeja.eraldaSõna(rida);


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

    public void avaTäht(char täht) {

        // Lünkade asendamine pakutud tähtedega
        for (int i = 0; i < suvalineSõna.length(); i++) {
            if (suvalineSõna.charAt(i) == täht) {
                arvatudTähed[i] = täht;
            }
        }
    }

    public boolean tähtKuulubSõnasse(char täht) {

       // kui täht sisaldub sõnas -> return true
        if (suvalineSõna.indexOf(täht) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getSuvalineSõna() {
        return suvalineSõna;
    }

    public void väljastaLünklik() {
        System.out.println(String.valueOf(arvatudTähed));
    }

    public boolean onÕigeSõnaArvatud() {
        for (char täht : arvatudTähed) {
            if (täht == '_') {
                return false;
            }
        }
        return true;
    }

    public void prindiKasutatudTähed() {
        if (!pakutudTähed.isEmpty()) // kui on midagi printida
        {// kõikide kasutadu tähtede väljastamine eraldatult tühikuga
            System.out.print("Kasutatud tähed: ");
            pakutudTähed.forEach(täht -> System.out.print(täht + " "));
            System.out.println();
        }
    }

    public void lisaTäht(char täht) {
        pakutudTähed.add(täht);
    }

    public boolean tähtSaadaval(char täht) {
        // kui täht on juba mängija poolt pakutud, siis seda ei saa enam pakkuda
        return !pakutudTähed.contains(täht);
    }
}
