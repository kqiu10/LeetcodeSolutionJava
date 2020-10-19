package 设计题.Iterator;
/**
 * Date: 10/18/20
 * Question Description
 Given two 1d vectors, implement an iterator to return their elements alternately.



 Example:

 Input:
 v1 = [1,2]
 v2 = [3,4,5,6]
 Output: [1,3,2,4,5,6]
 Explanation: By calling next repeatedly until hasNext returns false,
 the order of elements returned by next should be: [1,3,2,4,5,6].
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 Ex:
 v1 = [1,2]
 v2 = [3,4,5,6]
 Output: [1,3,2,4,5,6]
 i = 3 4 5 6
 j = 1 2 3
   |
   |
   V
 i = 2 3
 j = 3 4 5 6
    |
    |
    V
 i = 4 5 6
 j = 2 3
 * Time complexity:O(n);
 * Space complexity: O(1); 注意
 */
public class _281_ZigzagIterator {

    Iterator<Integer> i, j, temp;
    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }


/**
 * Time complexity:O(n);
 * Space complexity: O(1); 注意
 */
    LinkedList<Iterator> list;
    public void _281_ZigzagIteratorII(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next2() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }
    public boolean hasNextII() {
        return !list.isEmpty();
    }
}
