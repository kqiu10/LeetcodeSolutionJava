/**
 * Date: 12/1/20
 * Question Description
 Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

 For example,
 [2,3,4], the median is 3

 [2,3], the median is (2 + 3) / 2 = 2.5

 Design a data structure that supports the following two operations:

 void addNum(int num) - Add a integer number from the data stream to the data structure.
 double findMedian() - Return the median of all elements so far.


 Example:

 addNum(1)
 addNum(2)
 findMedian() -> 1.5
 addNum(3)
 findMedian() -> 2
 */

import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(logn);
 * Space complexity: O(n);

 */
public class _295_FindMedianFromDataStream {
    PriorityQueue<Long> min;
    PriorityQueue<Long> max;
    /** initialize your data structure here. */
    public _295_FindMedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>();

    }

    public void addNum(int num) {
        max.add((long)num);
        min.add(-max.poll());
        if (min.size() > max.size()) {
            max.add(-min.poll());
        }
    }

    public double findMedian() {
        return min.size() == max.size() ? (double)(max.peek() - min.peek()) / 2 : max.peek();
    }
}
