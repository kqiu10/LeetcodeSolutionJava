package ArrayList数组.数学定理;
/**
 * Package Name : 数组.数学定理;
 * File name : MajorityElement169;
 * Creator: Kane;
 * Date: 8/11/20
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HashMap
 */
public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > (int)nums.length / 2) {
                res = nums[i];
                break;
            }
        }
        return res;

    }
}
/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: Sorting
 * no matter what value the majority element has in relation to the rest of the array, returning
 * the value at [n/2] will never be wrong.
 */
class MajorityElementII{
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Moore voting algorithm
 * 每次都找出一对不同的元素，从数组删掉，知道数组为空或只有一种元素。
 * 如果存在元素e出现频率超过半数，数组中最后剩下的就只有e
 */
class MajorityElementIII{
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            } if (num != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;

    }
}