package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : _299_BullsandCows;
 * Creator: Kane;
 * Date: 7/31/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _299_BullsandCows {
    public static String getHint(String secret, String guess) {
        int cow = 0;
        int bull = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0 ) cow++;
                if (count[guess.charAt(i) - '0']-- > 0 ) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));
    }
}
