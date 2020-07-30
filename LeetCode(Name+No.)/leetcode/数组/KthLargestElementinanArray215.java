package leetcode.数组;
/**
 * Description: TODO
 * Package Name : leetcode;
 * File name : KthLargestElementinanArray215;
 * Creator: Kane;
 * Date: 7/19/20
 */

/**
 * Time complexity: O();
 * Space complexity: O();
 */
public class KthLargestElementinanArray215 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        int left = 0;
        int right = nums.length -1;
        while (true) {
            int pes = partition(nums, left, right);
            if (pes + 1 == k) {
                return nums[pes];
            } else if (pes + 1 > k) {
               right = pes - 1;
            } else {
                left = pes + 1;
            }
        }
    }
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] >pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) {
                l++;
            }
            if (nums[r] <= pivot) {
                r--;
            }
        }
        swap(nums,left,r);
        return r;
    }


    public static void swap(int[]nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
