package src.shape.segment;
/**
 * Package Name : src.shape.segment;
 * File name : SegmentIntersect;
 * Creator: Kane;
 * Date: 9/13/20
 */



/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class SegmentIntersect {
    public boolean onSegment(Point p, Point q, Point r) {
        if (q.x >= Math.min(p.x, r.x) && q.x <= Math.min(p.x, r.x) && q.y >= Math.min(p.y, r.y) && q.y <= Math.min(p.y, r.y)) {
            return true;
        }
        return false;
    }

    public int orientation(Point p, Point q, Point r) {
        int res = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (res == 0) return 0;
        return res > 0 ? 1 : 2;
    }

    /**
     * p1 q1 on same line
     * p2 q2 on same line
     */

    public boolean segmentIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) {
            return true;
        }
        /**
         * 两线有部分重合的Corner case;
         */
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }



}
