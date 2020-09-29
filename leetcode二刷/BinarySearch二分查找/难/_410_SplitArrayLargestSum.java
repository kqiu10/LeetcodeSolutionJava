package BinarySearch二分查找.难;
/**
 * Package Name : BinarySearch二分查找.难;
 * File name : _410_SplitArrayLargestSum;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description:
 * do binarySearch within max value and sum value
 * Ex
 * 1 2 3 4 5     m = 3
 * max = 5    sum = 15
 * 5 ~ 15   mid = 10   [1 2 3 4] [5]  m = 2 < 3; right = mid - 1 = 9
 * 5 ~ 9    mid = 7    [1 2 3] [4] [5]  m = 3 == 3; right = mid - 1 = 6
 * 5 ~ 6    mid = 5    [1 2] [3] [4] [5]  m = 4 > 3; left = mid + 1 = 6
 * 6 ~ 6    mid = 6    [1 2 3] [4] [5]  m = 3 == 3; right = mid - 1 = 5;
 * return
 *
 */
public class _410_SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) return (int)sum;
        long left = max;
        long right = sum;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isvalid(mid, nums, m)) right = mid - 1;
            else left = mid + 1;
        }
        return (int)left;


    }
    private static boolean isvalid (long target, int[] nums, int m) {
        int count = 1;
        int total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        splitArray(new int[]{7, 2, 5, 10, 8}, 2);
    }
}
