package BinarySearch二分查找.二维数组;
/**
 * Package Name : BinarySearch二分查找.二维数组;
 * File name : KthSmallestElementinaSortedMatrix;
 * Creator: Kane;
 * Date: 8/15/20
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find
 * the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 *
 * Time complexity:O(nlogn); n is the number of column because it's n * n matrix.
 * Space complexity: O(n);
 * Description: PriorityQueue
 * the size of PriorityQueue is the length of matrix, and we replace element in its onw column.
 *
 */
public class _378_KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(matrix.length, (a, b) -> (a.val - b.val));
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tuple = pq.poll();
            if (tuple.x == matrix.length - 1) continue;
            pq.offer(new Tuple(tuple.x + 1, tuple.y, matrix[tuple.x + 1][tuple.y]));
        }
        return pq.poll().val;

    }
    class Tuple {
        int x, y, val;
        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
/**
 * Time complexity:O(nlog(max - min));
 * Space complexity: O(1);
 * Description: BinarySearch
 *  [ 1,  5,  9],
 *  [10, 11, 13],
 *  [12, 13, 15]
 *  because each of the rows and columns are sorted in ascending order
 *  so
 *  the min val is matrix[0][0] = 1;
 *  the max val is matrix[n - 1][n - 1] = 15;
 *  then use binarySearch each time to determine k is in which part.
 */
class KthSmallestElementinaSortedMatrixII{
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            int num = count(matrix, mid);
            if (num >= k) right = mid;
            else left = mid;
        }
        if (count(matrix,right) <= k - 1) return right;
        return left;

    }
    public int count (int[][] matrix, int target) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while(i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }
}
