package leetcode.数组;
/**

 * Package Name : leetcode;
 * File name : KthLargestElementinanArray215;
 * Creator: Kane;
 * Date: 7/19/20
 */

import java.util.PriorityQueue;

/**
 * Time complexity: O(n);
 * Worst Time complexity: O(n^2);
 * Space complexity: O(1);
 * Description: SelectSort
 */
public class KthLargestElementinanArray215 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 < k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
    }
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }
}

/**
 * Time complexity: O(nlogk);
 * Space complexity: O(n);
 * Description: PriorityQueue
 */
class MethodII {
    public int KthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}