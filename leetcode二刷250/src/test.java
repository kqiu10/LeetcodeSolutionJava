/**
 * Date: 4/10/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.*;

/**
 * Time Complexity: O()
 * Space Complexity: O()
 */
public class test {
    public List<Integer> findCommon(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int val : arr1) {
            set.add(val);
        }
        for (int val : arr2) {
            if (!set.add(val)) {
                res.add(val);
            }
        }
        return new ArrayList<Integer>(res);
    }

    public void swapZero(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (arr[r] == 0) {
                r--;
            }
            if (l < r && arr[l] == 0) {
                swap(l++, r--, arr);
            }
            l++;
        }
        System.out.println(Arrays.toString(arr));
    }
    void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int findSubIncreaseArray(int[] arr) {
        int res = 0;
        for (int i = 0, j = 0; i < arr.length - 1; i++) {
            if (i == arr.length - 2 && j == 0) {
                return arr.length;
            }
            else {
                res = Math.max(res, i - j + 1);
            }
            if (arr[i + 1] < arr[i]) {
                res = Math.max(res, i - j + 1);
                j = i;
            }
        }
        return res;
    }

    public boolean compareTwoString(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * question 4
     * @param args
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i++) {
            int cur = i + 1;
            while (cur <= nums2.length - 1 && nums2[cur] < nums2[i]) {
                cur++;
            }
            if (cur == nums2.length) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], nums2[cur]);
            }
        }
        map.put(nums2[nums2.length - 1], -1);
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }



    public static void main(String[] args) {
        test t1 = new test();
//        System.out.println( t1.findCommon(new int[]{1, 2, 5, 3, 0}, new int[]{2, 2, 0}));
//        t1.swapZero(new int[]{0, 8, 9, 0, 4, 2, 0, 0});
//        System.out.println(t1.findSubIncreaseArray(new int[]{1, 2, 3, 1, 5, 7, 8, 9}));
//        System.out.println(t1.findSubIncreaseArray(new int[]{1, 2, 3, 4, 5, 6, 7}));
//        System.out.println(t1.compareTwoString("aabc", "abaabc"));
        System.out.println(Arrays.toString(t1.nextGreaterElement(new int[]{2,4}, new int[]{1,
                2,3,4})));
    }


}
