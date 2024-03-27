import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class Mängija {
    // mäng käib kuni elud mängijal otsa saavad
    private byte elud = 6;
    private int punktid = 0;
    private List<String> mehikeseOsad;
    private Set<Character> kasutatudTähed;

    public Mängija() throws Exception {
        // isendi loomine
        // lisab kõik read failist "mehike.txt" listi mehikeseOsad
        mehikeseOsad = Files.readAllLines(Paths.get("mehike.txt"));
        kasutatudTähed = new HashSet<>();
    }


    // vb võiks mõelda, et mingi sõna annab rohkem punkte ja mingi vähem
    public String lisaPunkte(int punktid) {
        this.punktid += punktid;
        return "Lisasin " + punktid + " punkti.";
    }


    public void eemaldaElu() {
        if (elud > 0) {
            elud -= 1;
        } else {
            System.out.println("Elud on otsas.");
        }
    }

    public byte getElud() {
        return elud;
    }

    public void taastaElud() {
        elud = 6; // iga sõna alguses taastatakse mängija elud
    }

    public int getPunktid() {
        return punktid;
    }

    public void printMehike() throws Exception {
        for (String s : mehikeseOsad.subList(elud * 8, elud * 8 + 8)) {
            System.out.print(s + "\n");
        }
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
        Mängija mängija = new Mängija();
        System.out.println(mängija.elud);
        mängija.printMehike();
        mängija.eemaldaElu();
        mängija.printMehike();
        mängija.eemaldaElu();
        mängija.printMehike();
        for (char i : new char[]{'a', 'b', 'c', 'd'}) {
            mängija.lisaTäht(i);
        }
        mängija.prindiKasutatudTähed();
        System.out.println("mängija.tähtSaadaval('a') = " + mängija.tähtSaadaval('a'));
        System.out.println("mängija.tähtSaadaval('a') = " + mängija.tähtSaadaval('g'));
    }
}
