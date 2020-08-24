package LinkedList链表.Reverse;
/**
 * Package Name : LinkedList链表.Reverse;
 * File name : _92_ReverseLinkedListII;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * 1->2->3->4->5
 * p  c  t
 *
 * 1st rotation
 * 2 -> 4
 * 3 -> 2
 * 1 -> 3
 *
 * 2nd rotation
 * 2 -> 5
 * 4 -> 3
 * 1 -> 4
 */
public class _92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}
