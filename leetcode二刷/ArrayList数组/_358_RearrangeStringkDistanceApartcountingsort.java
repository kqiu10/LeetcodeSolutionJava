package leetcode.数组;
/**
 * Package Name : leetcode.数组;
 * File name : _358_RearrangeStringkDistanceApartcountingsort;
 * Creator: Kane;
 * Date: 7/31/20
 */

import java.util.*;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: countSort
 */
public class _358_RearrangeStringkDistanceApartcountingsort {
    public static String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] count = new int[26];
        int[] valid = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);
            if (nextLetter == -1) {
                return "";
            }
            sb.append((char)('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;

        }
        return sb.toString();

    }
    public static int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                max = count[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        rearrangeString("aabbcc", 3);
    }
}

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description: PriorityQueue
 */
class RearrangeStringkDistanceApartcountingsortII{
    public static String rearrangeString(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            if (queue.size() < k) continue;
            Map.Entry<Character, Integer> front =  queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        return res.length() == s.length() ? res.toString() : "";
    }
}
