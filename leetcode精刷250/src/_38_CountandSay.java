package src; /**
 * Date: 11/4/20
 * Question Description
 */

/**
 * Time complexity:O(n^2);
 * Space complexity: O(n);
 * Description:
 *     1 count = 0 c = "1" res = "1"
 *     2 count = 1 c = "1" res = "11"
 *     3 j = 0 count = 1;
 *       j = 1 count = 2;
 *       res = "21"
 *     4 j = 0 c = "2" count = 1;
 *       j = 1 c = "1" res = "12" count = 1;
 *       j = 2 res = "1211"
 *     5 j = 0 c = "1" count = 1;
 *       j = 1 c = "2" res = "11" count = 1;
 *       j = 2 c = "1"  res = "1112" count = 1;
 *       j = 3 c = "1" count = 2;
 *       j = 4 c = "1" res = "111221"
 */
public class _38_CountandSay {
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";
        while (i < n) {
            int count  = 0;
            StringBuilder sb = new StringBuilder();
            char c = res.charAt(0);
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && c == res.charAt(j)) {
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
