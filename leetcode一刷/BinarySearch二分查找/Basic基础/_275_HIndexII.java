package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic基础;
 * File name : _275_HIndexII;
 * Creator: Kane;
 * Date: 8/14/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _275_HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0;
        int end = citations.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (citations[mid] > len - mid) end = mid - 1;
            else if (citations[mid] < len - mid) start = mid + 1;
            else return len - mid;

        }
        return len - start;


    }
}
