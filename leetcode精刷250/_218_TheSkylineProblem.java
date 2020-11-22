/**
 * Date: 11/22/20
 * Question Description
 A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings Skyline Contour
 The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

 For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].


 */

import java.util.*;


public class _218_TheSkylineProblem {
    /**
     * Description: PQ & HashMap;
     * Time complexity:O(n^2);
     * Space complexity: O(n);
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();
        for (int[] build : buildings) {
            height.add(Arrays.asList(build[0], -build[2]));
            height.add(Arrays.asList(build[1], build[2]));
        }
        Collections.sort(height, (a, b) -> (a.get(0).equals(b.get(0))) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        for (List<Integer> h : height) {
            if (h.get(1) < 0) {
                pq.offer(-h.get(1));
            } else {
                pq.remove(h.get(1));
            }
            int cur = pq.peek();
            if (prev != cur) {
                res.add(Arrays.asList(h.get(0), cur));
                prev = cur;
            }
        }
        return res;
    }
    /**
     * Description: TreeMap;
     * Time complexity:O(nlogn);
     * Space complexity: O(n);
     */
    public List<List<Integer>> getSkylineII(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> height = new ArrayList<>();
        for (int[] build : buildings) {
            height.add(Arrays.asList(build[0], -build[2]));
            height.add(Arrays.asList(build[1], build[2]));
        }
        Collections.sort(height, (a, b) -> (a.get(0).equals(b.get(0))) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1);
        int prev = 0;
        for (List<Integer> h : height) {
            if (h.get(1) < 0) {
                map.put(-h.get(1), map.getOrDefault(-h.get(1), 0) + 1);
            } else {
                int cnt = map.get(h.get(1));
                if (cnt == 1) {
                    map.remove(h.get(1));
                } else {
                    map.put(h.get(1), cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                res.add(Arrays.asList(h.get(0), cur));
                prev = cur;
            }
        }
        return res;
    }
}
