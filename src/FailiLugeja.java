import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FailiLugeja {


    public static String loeSuvalineRida() throws Exception {
        /*
         * Loeb failist "tabel1.txt" suvalise rea 1 ja 9717 vahel
         * */


        // arvu loomine
        int suvalineArv = (int) (Math.random() * 9717) + 1;

        // kujul - sõna    liik    kokku    ajakulu
        // eraldatud "\t"-ga

        try (Scanner sc = new Scanner(new File("tabel1.txt"), StandardCharsets.UTF_8)) {
            return Files.readAllLines(Paths.get("tabel1.txt")).get(suvalineArv);
        }
    }

    public static String eraldaSõna(String rida) throws Exception {

        return rida.substring(0, rida.indexOf('\t'));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(eraldaSõna(loeSuvalineRida()));
    }
}
