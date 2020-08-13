package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : FindPeakElement162;
 * Creator: Kane;
 * Date: 8/13/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class FindPeakElement162 {
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start - 1< end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid + 1] < nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] > nums[end]) return start;
        return end;
    }

    public static void main(String[] args) {
        findPeakElement(new int[]{1, 2, 1, 3, 5});
    }
}
