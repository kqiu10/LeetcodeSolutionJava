package BinarySearch二分查找.Basic;
/**
 * Package Name : BinarySearch二分查找.Basic;
 * File name : FirstBadVersion278;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (isBadVersion(mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;


    }
    //avoid IDE throw error;
    private boolean isBadVersion(int mid) {
        return true;
    }
}
