package Heap堆.PriorityQueue;
/**
 * Package Name : Heap堆.PriorityQueue;
 * File name : _295_FindMedianfromDataStream;
 * Creator: Kane;
 * Date: 10/22/2020
 */

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there
 * is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Time complexity:O(logn);
 * Space complexity: O(n);
 * Description:
 * Two PriorityQueue
 * 1 2 -3
 * small: 3
 * large: 2 1
 * when the count is odd, large queue will always be larger than small queue, and the median is large.poll();
 * 1 2 -3 4
 * small: -1 3
 * large:  2 4
 * number in small priority queue always be opposite.
 * when the count is even, median is large.peek() - small.peek();
 */
public class _295_FindMedianfromDataStream {
    private PriorityQueue<Long> small;
    private PriorityQueue<Long> large;

    /** initialize your data structure here. */
    public _295_FindMedianfromDataStream() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();

    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (small.size() > large.size()) {
            large.add(-small.poll());
        }

    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() :(double)(large.peek() - small.peek()) / 2 ;

    }

    public static void main(String[] args) {
        _295_FindMedianfromDataStream obj = new _295_FindMedianfromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

