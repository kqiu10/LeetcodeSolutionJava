package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : IntersectionofTwoArraysII350;
 * Creator: Kane;
 * Date: 8/13/20
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class IntersectionofTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) throw new IllegalArgumentException();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            int cnt = map.getOrDefault(num, 0);
            if (cnt > 0) {
                res.add(num);
                map.put(num, cnt - 1);
            }
        }
        int[] ret = new int[res.size()];
        int k = 0;
        for (Integer num : res) {
            ret[k++] = num;
        }
        return ret;

    }
}
