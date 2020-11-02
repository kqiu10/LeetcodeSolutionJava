package HashMap;
/**
 * Package Name : HashMap;
 * File name : _535_EncodeandDecodeTinyURL;
 * Creator: Kane;
 * Date: 9/3/20
 */

import java.util.HashMap;
import java.util.Random;

/**
 * Time complexity:O(1);
 * Space complexity: O(1); n 个 String O(n)
 * Description: TODO
 */
public class _535_EncodeandDecodeTinyURL {
    HashMap<String, String> map = new HashMap<>();
    String mapString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = rnd.nextInt(mapString.length());
            sb.append(mapString.charAt(index));
        }
        String shortUrl = "http://tinyurl.com/" + sb.toString();
        if (!map.containsKey(shortUrl)) {
            map.put(shortUrl, longUrl);
        }
        return shortUrl;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
