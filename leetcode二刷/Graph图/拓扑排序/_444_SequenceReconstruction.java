package leetcode.Graph图.拓扑排序;
/**
 * Date: 9/23/20
 * Question Description
 * Check whether the original sequence org can be uniquely reconstructed from the sequences in
 * seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
 * Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e.,
 * a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether
 * there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: org = [1,2,3], seqs = [[1,2],[1,3]]
 * Output: false
 * Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2]
 * is also a valid sequence that can be reconstructed.
 * Example 2:
 *
 * Input: org = [1,2,3], seqs = [[1,2]]
 * Output: false
 * Explanation: The reconstructed sequence can only be [1,2].
 * Example 3:
 *
 * Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * Output: true
 * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original
 * sequence [1,2,3].
 * Example 4:
 *
 * Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * Output: true
 *
 */

import java.util.*;

/**
 * Time complexity:O(V + E);
 * Space complexity: O(n);
 * Description:
 * HashMap -> BFS
 * Ex
 * org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * map :
         * 5 - 2
         * 2 - 6
         * 6 - 3
         * 4 - 1
         * 1 - 5
         * 2 -
 * indegree
 *         1 - 1
 *         2 - 1
 *         3 - 1
 *         5 - 1
 *         6 - 1
 *         4 - 0
 *
 */
public class _444_SequenceReconstruction {
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i : seq) {
                map.putIfAbsent(i, new HashSet<>());
                indegree.putIfAbsent(i, 0);
            }
        }
        for (List<Integer> seq : seqs) {
            if (seq.size() == 1) continue;
            for (int i = 1; i < seq.size(); i++) {
                if (map.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }
        int res = 0;
        int k = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            if (org[k++] != cur) return false;
            for (int next : map.get(cur)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
            res++;
        }
        return res == indegree.size();
    }

}
/**n
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description:
 */
class SequenceReconstructionII{
    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int idx[] = new int[org.length + 1];
        int res = org.length - 1;
        //sort by sequence
        for (int i = 0; i < org.length; i++) {
            idx[org[i]] = i;
        }
        boolean seen[] = new boolean[org.length + 1];
        boolean isEmpty = true;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                isEmpty = false;
                int cur = seq.get(i);
                if (cur < 1 || cur > org.length) {
                    return false;
                }
                if (i == 0) continue;
                int prev = seq.get(i - 1);
                if (idx[prev] + 1 == idx[cur]) {
                    if (!seen[prev]) {
                        seen[prev] = true;
                        res--;
                    }
                } else if (idx[prev] >= idx[cur]) {
                    return false;
                }
            }
        }
        return res == 0 && !isEmpty;
    }
}