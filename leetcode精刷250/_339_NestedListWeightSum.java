/**
 * Date: 12/4/20
 * Question Description
 Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

 Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Example 1:
 Input: [[1,1],2,[1,1]]
 Output: 10
 Explanation: Four 1's at depth 2, one 2 at depth 1.

 Example 2:
 Input: [1,[4,[6]]]
 Output: 27
 Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _339_NestedListWeightSum {
    private int res = 0;
    public int depthSum(List<NestedInteger> nestedList) {
        for (int i = 0; i < nestedList.size(); i++) {
            helper(nestedList.get(i), 1);
        }
        return res;
    }
    private void helper(NestedInteger list, int depth) {
        if (list.isInteger()) {
            res += depth * list.getInteger();
            return;
        }
        List<NestedInteger> next = list.getList();
        for (int i = 0; i < next.size(); i++) {
            helper(next.get(i), depth + 1);
        }
    }

}
class NestedInteger {
    Integer value;
    List<NestedInteger> list;

    NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    }
    // Constructor initializes a single integer.

    NestedInteger(int value) {
        this.value = value;
    }

    ;

    NestedInteger(Integer value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }
    // @return true if this NestedInteger holds a single integer, rather than a nested list.

    public boolean isInteger() {
        return value != null;
    }

    ;
    // @return the single integer that this NestedInteger holds, if it holds a single integer

    // Return null if this NestedInteger holds a nested list

    public Integer getInteger() {
        return value;
    }

    ;

    public List<NestedInteger> getList() {
        return list;
    }

    ;

    public Integer next() {
        return value;
    }

    public boolean hasNext() {
        return true;
    }

    public void add(NestedInteger nestedInteger) {
    }
}
