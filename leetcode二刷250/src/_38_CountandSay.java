/**
 * Date: 2/26/21
 * Question Description:
 * <p>
 * Examples:
 */

/**
 * Time Complexity: O(不清楚)
 * Space Complexity: O(1)
 */
public class _38_CountandSay {
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while(i < n) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    if (j != res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            res = sb.toString();
            i++;
        }
        return res;
    }
}
