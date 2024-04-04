import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Mängija {
    // mäng käib kuni elud mängijal otsa saavad
    private byte elud = 6;
    private int punktid = 0;
    private List<String> mehikeseOsad;


    public Mängija() throws Exception {
        // isendi loomine
        // lisab kõik read failist "mehike.txt" listi mehikeseOsad

        mehikeseOsad = Files.readAllLines(Paths.get("mehike.txt"));

    }



    public String lisaPunkte(int punktid) {
        this.punktid += punktid;
        return "Lisasin " + punktid + " punkti.";
    }

    // kui pakutakse vale täht, siis võetakse mängijalt 1 elu ära
    public void eemaldaElu() {
        if (elud > 0)
            elud -= 1;
    }

    public byte getElud() {
        return elud;
    }

    // kui mingi sõna on ära arvatud, siis elud taastatakse ja hakkab uue sõna arvamine
    public void taastaElud() {
        elud = 6;
    }

    public int getPunktid() {
        return punktid;
    }

    // väljastab mehikese kuju
    public void printMehike() {
        for (String s : mehikeseOsad.subList(elud * 8, elud * 8 + 8)) {
            System.out.print(s + "\n");
        }
    }

}
