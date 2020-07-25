package leetcode.Mathmatics数学题;
/**
 * Description: TODO
 * Package Name : leetcode.Mathmatics数学题;
 * File name : AddDigits258;
 * Creator: Kane;
 * Date: 7/25/20
 * 1 : 1
 * 2 : 2
 * 3 : 3
 * 4 : 4
 * 5 : 5
 * 6 : 6
 * 7 : 7
 * 8 : 8
 * 9 : 9
 * 10 : 1
 * 11 : 2
 * 12 : 3
 * 13 : 4
 * 14 : 5
 * 15 : 6
 * 16 : 7
 * 17 : 8
 * 18 : 9
 */

/**
 * Time complexity:O(1);
 * Space complexity: O(1);
 */
public class AddDigits258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;

    }
}
