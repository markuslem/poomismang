import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FailiLugeja {



    public static String loeSuvalineRida() throws Exception {
        /*
        * Loeb failist "tabel1.txt" suvalise rea 1 ja 9717 vahel
        * */



        // arvu loomine
        int suvalineArv = (int) (Math.random() * 9717) + 1;

        // kujul - sõna    liik    kokku    ajakulu
        return Files.readAllLines(Paths.get("tabel1.txt")).get(suvalineArv);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(loeSuvalineRida());
    }
}
