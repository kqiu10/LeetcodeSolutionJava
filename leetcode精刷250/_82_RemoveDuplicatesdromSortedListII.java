/**
 * Date: 11/10/20
 * Question Description
 */

import LinkedList链表.Basic.ListNode;

/**
 * Description: TODO
 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _82_RemoveDuplicatesdromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int minVal = p.next.val;
                while (p.next != null && p.next.val == minVal) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;

    }
}
