package leetcode.BitWise位运算;
/**
 * Description: 任何数异或0等于其本身;
 * Package Name : leetcode;
 * File name : SingleNumber136;
 * Creator: Kane;
 * Date: 7/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 */
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
       int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];

        }
        return res;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 2, 1};
        System.out.println(singleNumber(ints));


    }
}
