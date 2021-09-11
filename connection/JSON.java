package connection;

import java.util.regex.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class JSON {
    /**
    * Parses a json string into a HashMap.
    *
    * @param jsonString The JSON string to be parsed.
    * @return           A HashMap containing relevant anime data.
    */
    public static HashMap<String, String> parse(String jsonString) {
        HashMap<String, String> map = new HashMap<String, String>();
        Pattern p = Pattern.compile ("\"[a-zA-Z_]+\":(\"([^,])+\"|[0-9]+)");
        Matcher m = p.matcher (jsonString);

        while (m.find()) {
            String queriedString = m.group();
            queriedString = queriedString.replace("\"", "");
            queriedString = queriedString.replace("https://", "");
            queriedString = queriedString.replace("http://", "");
            StringTokenizer tok = new StringTokenizer(queriedString, ":");

            if (queriedString.contains("cover_image")) {
                continue;
            }
            String key = tok.nextToken();
            String val = tok.nextToken();
            map.put (key, val);
        }

        return map;
    }
}
