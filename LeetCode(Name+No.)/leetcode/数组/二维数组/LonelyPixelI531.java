package 数组.二维数组;
/**
 * Package Name : 数组.二维数组;
 * File name : LonelyPixelI531;
 * Creator: Kane;
 * Date: 8/12/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class LonelyPixelI531 {
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length;
        int n = picture[0].length;
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                }
            }
        }
        int res = 0;

        for (int i = 0; i < m; i++) {
            int pos = 0;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    pos = j;
                }

            }
            if (count == 1 && 1 == col[pos]) res++;

        }
        return res;

    }
}
