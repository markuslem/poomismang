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


    // vb võiks mõelda, et mingi sõna annab rohkem punkte ja mingi vähem
    public String lisaPunkte(int punktid) {
        this.punktid += punktid;
        return "Lisasin " + punktid + " punkti.";
    }


    public void eemaldaElu() {
        if (elud > 0)
            elud -= 1;
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

}
