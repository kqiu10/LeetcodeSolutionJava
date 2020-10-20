package 设计题.实现题;
/**
 * Date: 10/19/20
 * Question Description
 Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 Example:

 Vector2D iterator = new Vector2D([[1,2],[3],[4]]);

 iterator.next(); // return 1
 iterator.next(); // return 2
 iterator.next(); // return 3
 iterator.hasNext(); // return true
 iterator.hasNext(); // return true
 iterator.next(); // return 4
 iterator.hasNext(); // return false
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _251_Flatten2DVector {
    int indexList, indexElement;
    int[][] list;

    public _251_Flatten2DVector(int[][] v) {
        indexList = 0;
        indexElement = 0;
        list = v;
    }

    public int next() {
        if (!hasNext()) return -1;
        return list[indexList][indexElement++];
    }

    public boolean hasNext() {
        while (indexList < list.length) {
            if (indexElement < list[indexList].length) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
