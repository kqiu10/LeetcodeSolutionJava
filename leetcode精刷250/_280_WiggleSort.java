/**
 * Date: 11/28/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _280_WiggleSort {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 != 0 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
        return;
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
