package 数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : FindAllNumbersDisappearedinanArray448;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: swap
 */
public class FindAllNumbersDisappearedinanArray448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && nums[nums[i] - 1 ] != nums[i]) {
                int temp =  nums[nums[i] - 1 ];
                nums[nums[i] - 1 ] = nums[i];
                nums[i] = temp;
            }
            if (nums[nums[i] - 1] == nums[i]) {
                continue;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                res.add(i + 1);
            }
        }
        return res;


    }
}


/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: Like BucketSort
 */
class FindAllNumbersDisappearedinanArrayII{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
