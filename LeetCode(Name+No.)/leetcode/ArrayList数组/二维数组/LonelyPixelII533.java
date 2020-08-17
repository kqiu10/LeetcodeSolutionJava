package ArrayList数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : LonelyPixelII533;
 * Creator: Kane;
 * Date: 8/12/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(m * n);
 * Space complexity: O(max(m, n));
 * Description: TODO
 */
public class LonelyPixelII533 {
    public static  int findBlackPixel(char[][] picture, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        int m = picture.length;
        int n = picture[0].length;
        int res = 0;
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                    count++;
                }
            }
            if (count == N) {
                String row = new String(picture[i]);
                map.put(row, map.getOrDefault(row, 0) + 1);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) != N) continue;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'B' && col[i] == N) {
                    res+=N;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        findBlackPixel(new char[][]{{'W','B', 'W','B', 'B','W'},{'W','B', 'W','B', 'B','W'},{'W','B', 'W','B', 'B','W'},{'W','W','B','W','B','W'}},3);
    }
}
