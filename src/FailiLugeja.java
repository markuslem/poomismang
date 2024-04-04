import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FailiLugeja {


    public static String loeSuvalineRida() throws Exception {
        /*
         * Loeb failist "tabel1.txt" suvalise rea 1 ja 9717 vahel
         * Tagastab terve sõna
         * */


        // arvu loomine
        int suvalineArv = (int) (Math.random() * 9716) + 1;

        // kujul - sõna    liik    kokku    ajakulu
        // eraldatud "\t"-ga

        try (Scanner sc = new Scanner(new File("tabel1.txt"), StandardCharsets.UTF_8)) {
            // kuni jõuab suvalise arvuna antud arvuni
            for (int i = 0; i < suvalineArv; i++) sc.nextLine(); // loendab kuni õige reani (nr suvaline arv)
            return sc.nextLine(); // tagastab õige rea
        }
    }

    public static String eraldaSõna(String rida) throws Exception {
        // sõna on esimesel kohal reas
        return rida.substring(0, rida.indexOf('\t'));
    }

}
