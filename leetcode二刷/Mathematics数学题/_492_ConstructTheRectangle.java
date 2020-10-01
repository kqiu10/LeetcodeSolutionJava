package leetcode.Mathmatics数学题;
/**
 * Package Name : leetcode.Mathmatics数学题;
 * File name : _492_ConstructTheRectangle;
 * Creator: Kane;
 * Date: 7/28/20
 */

/**
 * Time complexity:O(sqrt(n));
 * Space complexity: O(1);
 * Description: TODO
 */
public class _492_ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};

    }
}
