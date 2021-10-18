package Frontend.utility;

import java.lang.StringBuilder;

public class LineBreaker {
    /** TOFIX
    * Adds a line break
    *
    * @param s     The input String
    * @param space The number of spaces to add
    */
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
