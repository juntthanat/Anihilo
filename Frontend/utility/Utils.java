package Frontend.utility;

public class Utils {
    /**
    * Converts a String to HTML
    *
    * @param body The String to Convert
    *
    * @return String The HTML String
    */
    public static String toHTML(String body) {
        String html = "<html><body>" + body + "</body></html>";
        return html;
    }
}
