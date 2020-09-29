package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : MajorityElementII;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _229_MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int num1 = 0, num2 = 0;
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
            else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) count1++;
            else if (nums[i] == num2) count2++;
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;

    }

    public static void main(String[] args) {
        majorityElement(new int[]{0, 0, 0});
    }
}
