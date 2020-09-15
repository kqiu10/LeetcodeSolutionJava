package ArrayList数组.HashSet;
/**
 * Package Name : 数组.HashSet;
 * File name : _217_ContainsDuplicate;
 * Creator: Kane;
 * Date: 8/7/20
 */

import java.util.HashSet;
import java.util.Arrays;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i< nums.length; i++) {
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: TODO
 */
class ContainsDuplicateII{
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
