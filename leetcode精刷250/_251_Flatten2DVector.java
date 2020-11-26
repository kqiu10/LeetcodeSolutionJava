/**
 * Date: 11/26/20
 * Question Description
 */

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _251_Flatten2DVector {
    int indexArray;
    int indexNum;
    int[][] list;
    public _251_Flatten2DVector(int[][] v) {
        indexArray = 0;
        indexNum = 0;
        list = v;
    }

    public int next() {
        if (!hasNext()) return -1;
        return list[indexArray][indexNum++];

    }

    public boolean hasNext() {
        while (indexArray < list.length) {
            if (indexNum < list[indexArray].length) {
                return true;
            } else {
                indexArray++;
                indexNum = 0;
            }
        }
        return false;
    }
}
