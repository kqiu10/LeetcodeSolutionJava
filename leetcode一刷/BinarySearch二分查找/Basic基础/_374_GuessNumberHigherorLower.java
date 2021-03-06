package BinarySearch二分查找.Basic基础;
/**
 * Package Name : BinarySearch二分查找.Basic;
 * File name : _374_GuessNumberHigherorLower;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O(logn);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _374_GuessNumberHigherorLower {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;

    }
    //avoid IDE send error;
    private int guess(int mid) {
        return 0;
    }
}
