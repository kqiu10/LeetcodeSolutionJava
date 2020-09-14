package src.shape.point;
/**
 * Package Name : src.shape.point;
 * File name : Orientation;
 * Creator: Kane;
 * Date: 9/13/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class Orientation {

    public int orientation(Point p, Point q, Point r) {
        int res = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (res == 0) return 0;
        return res > 0 ? 1 : 2;
    }
}
