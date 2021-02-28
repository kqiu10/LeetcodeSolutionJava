/**
 * Date: 2/28/21
 * Question Description:
 * <p>
 * Examples:
 */

import java.util.PriorityQueue;

/**
 * Time Complexity: O(n*logk)
 * Space Complexity: O(k)
 */
public class _23_MergeKSortedLists {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode ele = pq.poll();
            cur.next = new ListNode(ele.val);
            cur = cur.next;
            if (ele.next != null) {
                pq.offer(ele.next);
            }
        }
        return dummy.next;

    }
}
