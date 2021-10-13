import connection.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            for (int i=0; i<10; i++) {
                Anime a = new Anime(2999, true);
                System.out.println (a.toString());
                a.download_small_img("./images/");
            }
        } catch (ConnectionError e) {
            System.out.println (e.toString());
        }
    }
}
