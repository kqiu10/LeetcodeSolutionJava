package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : FindtheDuplicateNumber287;
 * Creator: Kane;
 * Date: 7/29/20
 */

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: 二分法；
 */
public class FindtheDuplicateNumber287 {
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int count = 0;
            int mid = (max - min) / 2 + min;
            for (int i = 0; i< nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;

    }

    public static void main(String[] args) {
        findDuplicate(new int[]{1,3,4,2,2});
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Lined List Cycle；
 * 代码参考：https://segmentfault.com/a/1190000003817671；
 */
class MethodII{
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        int find = 0;
        while (find != slow) {
            find = nums[find];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
