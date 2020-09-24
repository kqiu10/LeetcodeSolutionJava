package leetcode.Graph图.并查集;
/**
 * Date: 9/23/20
 * Question Description
 * There are N students in a class. Some of them are friends, while some are not. Their
 * friendship is transitive in nature. For example, if A is a direct friend of B, and B is a
 * direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a
 * group of students who are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If
 * M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 * And you have to output the total number of friend circles among all the students.
 *
 * Example 1:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 * The 2nd student himself is in a friend circle. So return 2.
 *
 *
 * Example 2:
 *
 * Input:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct
 * friends,
 * so the 0th and 2nd students are indirect friends. All of them are in the same friend circle,
 * so return 1.
 *
 */


public class _547_FriendCircles {
    /**
     * Description: DFS
     * Time complexity:O(edges * nodes);
     * Space complexity: O(n);
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int res = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }
    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < visited.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    /**
     * Description: UnionFind
     * Time complexity:O(edges * nodes);
     * Space complexity: O(n);
     */
    public int findCircleNumII(int[][] M) {
        int res = M.length;

        int[] roots = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            roots[i] = -1;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    int x = find(roots, i);
                    int y = find(roots, j);
                    if (x != y) {
                        roots[x] = y;
                        res--;
                    }
                }
            }
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (roots[i] != -1) {
            i = roots[i];
        }
        return i;
    }
}
