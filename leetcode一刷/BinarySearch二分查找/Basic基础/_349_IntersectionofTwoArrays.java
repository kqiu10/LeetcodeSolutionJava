package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : _349_IntersectionofTwoArrays;
 * Creator: Kane;
 * Date: 8/13/20
 */

import java.util.HashSet;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null) return new int[]{};
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num :nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        int k = 0;
        int[] count = new int[res.size()];
        for (int num : res) {
            count[k++] = num;
        }
        return count;
    }
}
