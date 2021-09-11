import connection.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Anime a = new Anime();
        System.out.println (a.toString());
        a.download_small_img("./");
    }
}
