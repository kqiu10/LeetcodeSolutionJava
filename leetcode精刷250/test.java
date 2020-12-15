/**
 * Date: 12/13/20
 * Question Description
 */

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O();
 * Space complexity: O();

 */
public class test {
    static String[][] wordCountEngine(String document) {
        // your code goes here
        HashMap<String, String> map;
        map = new HashMap<>();
        final String initial = document.toLowerCase();
        PriorityQueue<Map.Entry<String, String>> pq = new PriorityQueue<>((a, b) -> Integer.parseInt(b.getValue()) ==Integer.parseInt(b.getValue()) ?  initial.indexOf(a.getKey()) - initial.indexOf(b.getKey()) : Integer.valueOf(b.getValue()) - Integer.valueOf(a.getValue()));

        String[] cleaned = document.split("\\s+");
        for (int i = 0; i < cleaned.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : cleaned[i].toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    sb.append(c);
                }
            }
            //new string
            String newStr = sb.toString();
            if (!map.containsKey(newStr)) {
                map.put(newStr, "0");
            }
            Integer val = Integer.parseInt(map.get(newStr));
            map.put(newStr, (val + 1) + "");
        }
        //hashmap with string and its occurance
        pq.addAll(map.entrySet());
        String[][] res = new String[pq.size()][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            Map.Entry<String,String> cur = pq.poll();
            res[idx][0] = cur.getKey();
            res[idx++][1] = cur.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!"));
    }
}
