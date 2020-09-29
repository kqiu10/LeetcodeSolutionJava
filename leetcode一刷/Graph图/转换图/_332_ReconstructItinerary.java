package leetcode.Graph图.转换图;
/**
 * Date: 9/22/20
 * Question Description
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from,
 * to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from
 * JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest
 * lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a
 * smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 *
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Time complexity:O(nlogn);
 * Space complexity: O(n);
 * Description: DFS(HashMap) + PriorityQueue
 */
public class _332_ReconstructItinerary {
    HashMap<String, PriorityQueue<String>> map;
    List<String> res;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        res = new LinkedList<>();
        for (List<String> ticket : tickets) {
           map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        helper("JFK");
        return res;
    }
    private void helper(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll());
        }
        res.add(0, airport);
    }

}
