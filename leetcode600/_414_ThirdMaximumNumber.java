package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : _414_ThirdMaximumNumber;
 * Creator: Kane;
 * Date: 8/8/20
 */

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _414_ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer num : nums) {
            if (num.equals(max1) || num.equals(max2) || num.equals(max3)) continue;
            if (max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (max2 == null || num > max2) {
                max3 = max2;
                max2 = num;
            } else if (max3 == null || num > max3) {
                max3 = num;
            }
        }
        return max3 == null ? max1 : max3;
    }

    public static void main(String[] args) {
        thirdMax(new int[]{3, 2, 1});

    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Priority Queue;
 */
class ThirdMaximumNumberII{
    public static int thirdMax(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.add(num)) {
                heap.add(num);
                if (heap.size() > 3) heap.poll();
            }
        }
        if (heap.size() == 2) {
            heap.poll();
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        thirdMax(new int[]{4, 3, 2, 1,0});

    }
}