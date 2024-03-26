import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Mängija {
    // mäng käib kuni elud mängijal otsa saavad
    private byte elud = 6;
    private int punktid = 0;
    private List<String> mehikeseOsad;

    // mehikese isendi loomisel loetakse mehike.txt failist mehikese osad.
    public Mängija() throws IOException {
        mehikeseOsad = Files.readAllLines(Paths.get("mehike.txt"));
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

    public int getPunktid() {
        return punktid;
    }

    public void printMehike() throws Exception {
        for (String s : mehikeseOsad.subList(elud * 8, elud * 8 + 8)) {
            System.out.print(s + "\n");
        }
    }

    public static void main(String[] args) throws Exception {
        Mängija mängija = new Mängija();
        System.out.println(mängija.elud);
        mängija.printMehike();
    }
}
