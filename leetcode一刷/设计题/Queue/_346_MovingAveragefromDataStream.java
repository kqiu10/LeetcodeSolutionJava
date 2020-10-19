package 设计题.Queue;
/**
 * Date: 10/18/20
 * Question Description
 Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 Example:

 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: TODO
 * Time complexity:O(1);
 * Space complexity: O(n);

 */
public class _346_MovingAveragefromDataStream {
    /** Initialize your data structure here. */
    Queue<Integer> queue;
    double sum = 0;
    int size;
    public _346_MovingAveragefromDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;

    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();

    }
}
