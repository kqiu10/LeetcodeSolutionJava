package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : _442_FindAllDuplicatesinanArray;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _442_FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 0 || nums == null) return res;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[index] = - nums[index];
            }
        }
        return res;
    }
}
