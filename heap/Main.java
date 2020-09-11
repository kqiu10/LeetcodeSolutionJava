package heap;
/**
 * Package Name : heap.Impl;
 * File name : Main;
 * Creator: Kane;
 * Date: 9/11/20
 */

import heap.Impl.MaxHeapImpl;

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Main {
    public static void main(String[] args) {
        MaxHeapImpl<Integer> mapHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[]{2, 23, 30, 8, 32, 31, 41, 1, 15};
        for (Integer num : nums) {
            mapHeap.offer(num);
        }
        mapHeap.print();

    }
}
