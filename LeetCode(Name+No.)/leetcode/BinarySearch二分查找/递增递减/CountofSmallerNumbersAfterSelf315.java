package BinarySearch二分查找.递增递减;
/**
 * Package Name : BinarySearch二分查找.递增递减;
 * File name : CountofSmallerNumbersAfterSelf315;
 * Creator: Kane;
 * Date: 8/15/20
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ou are given an integer array nums and you have to return a new counts array. The counts array
 * has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example 1:
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 * Time complexity:O(n^2) (worst case)  nlogn as usual;
 * Space complexity: O();
 * Description:
 * Ex [5, 2, 6, 1]
 * use List insert from end to start as sorted, the index result is [0, 1, 1, 2];
 * which is the reverse of the answer [2, 1, 1, 0];
 */
public class CountofSmallerNumbersAfterSelf315 {
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = findIndex(list, nums[i]);
            res[i] = idx;
            list.add(idx, nums[i]);
        }
        return Arrays.asList(res);

    }
    public static int findIndex(List<Integer> res, int target) {
        if (res.size() == 0) return 0;
        int end = res.size() - 1;
        int start = 0;
        if (res.get(end) < target) return end + 1;
        if (res.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (res.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        if (res.get(start) >= target) return start;
        return end;

    }

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }

}
