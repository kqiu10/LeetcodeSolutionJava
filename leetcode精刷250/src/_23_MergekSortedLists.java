package src; /**
 * Date: 11/3/20
 * Question Description
 You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

 Merge all the linked-lists into one sorted linked-list and return it.



 Example 1:

 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 Output: [1,1,2,3,4,4,5,6]
 Explanation: The linked-lists are:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 merging them into one sorted list:
 1->1->2->3->4->4->5->6
 Example 2:

 Input: lists = []
 Output: []
 Example 3:

 Input: lists = [[]]
 Output: []
 */




import Heap堆.PriorityQueue.ListNode;

import java.util.PriorityQueue;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(n);

 */
public class _23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        return dummy.next;
    }
}
