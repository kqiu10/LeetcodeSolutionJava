/**
 * Date: 12/11/20
 * Question Description
 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 */

import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(k * logk);
 * Space complexity: O(k);

 */
public class _378_kthSmallestElementinaSortedMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int sum = m * n;
        int size = sum - k + 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(size, (a, b) -> (a - b));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > size) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
    }

}
