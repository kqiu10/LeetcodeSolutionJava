package ArrayList数组.实现题;
/**
 * Package Name : 数组.实现题;
 * File name : FindtheCelebrity277;
 * Creator: Kane;
 * Date: 8/9/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 * Description: TODO
 */
public class FindtheCelebrity277 {
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (possible != i && (knows(possible, i) || !knows(i, possible))) {
                return -1;
            }
        }
        return possible;

    }
    public boolean knows(int a, int b) {
        return true;
    }
}
