package ArrayList数组.bucketSort;
/**
 * Package Name : 数组.bucketSort;
 * File name : ContainsDuplicateIII220;
 * Creator: Kane;
 * Date: 8/10/20
 */

import java.util.HashMap;
import java.util.TreeSet;

/**
 * Time complexity:O(nlogk);
 * Space complexity: O(k);
 * Description:
 * i <= k <= j
 * nums[i] <= t <= nums[j]
 * both set.remove() . set.floor() and set.ceiling() cause logk Time Complexity
 * TreeSet
 */
public class ContainsDuplicateIII220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(k);
 * Description:
 * i <= k <= j
 * nums[i] <= t <= nums[j]
 * both set.remove() . set.floor() and set.ceiling() cause logk Time Complexity
 * BucketSort
 */
class ContainsDuplicateIII2{
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            Long bucket = remappedNum / ((long)t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                {
                return true;
                }
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
            }
        return false;
    }
}