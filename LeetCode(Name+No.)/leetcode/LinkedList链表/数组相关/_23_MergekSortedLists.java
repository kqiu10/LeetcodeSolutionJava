package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : _23_MergekSortedLists;
 * Creator: Kane;
 * Date: 8/19/20
 */

import java.util.PriorityQueue;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: PriorityQueue;
 */
public class _23_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(0);
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

/**
 * Time complexity:O(nlogk); where k is the number of linkedLists
 * Space complexity: O(n);
 * Description: Divide and Conquer;
 */
class MergekSortedListsII {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }
    private ListNode sort (ListNode[] lists, int l, int r) {
        if (l >= r) return lists[l];
        int mid = (r - l) / 2 + l;
        ListNode l1 = sort(lists, l, mid);
        ListNode l2 = sort(lists, mid + 1, r);
        return merge(l1, l2);
     }
     private ListNode merge (ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
     }
}

