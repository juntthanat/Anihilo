package Frontend.utility;

import java.lang.StringBuilder;

public class LineBreaker {
    public static String breaker(String s, int space) {
        // * add <BR/> in " " in the last every 30 letter or less
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while (i + space < sb.length() && (i = sb.lastIndexOf(" ", i + space)) != -1) {
            sb.replace(i, i + 1, "<BR/>");
        }
        return sb.toString();
    }
}
