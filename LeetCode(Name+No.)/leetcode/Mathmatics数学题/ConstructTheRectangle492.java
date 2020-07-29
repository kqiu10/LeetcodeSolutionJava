package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : ConstructTheRectangle492;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(sqrt(n));
 * Space complexity: O(1);
 * Description: TODO
 */
public class ConstructTheRectangle492 {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};

    }
}
