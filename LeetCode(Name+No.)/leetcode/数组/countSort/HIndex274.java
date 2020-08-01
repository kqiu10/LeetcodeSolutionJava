package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : HIndex274;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.Arrays;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(1);
 * Description: HIndex代表n篇文章被引用n次;
 */
public class HIndex274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;

    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 * helper[i] 表示文章被引用了i次;
 */
class HIndexII {
    public int hIndex(int[] citations) {
        //考虑引用0次的情况
        int[] helper = new int[citations.length + 1];
        int sum = 0;
        for (int i = 0; i < citations.length; i++) {
            int index = citations[i] >= citations.length ? citations.length : citations[i];
            helper[index]++;
        }
        for (int i = citations.length; i > 0; i--) {
            sum += helper[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
