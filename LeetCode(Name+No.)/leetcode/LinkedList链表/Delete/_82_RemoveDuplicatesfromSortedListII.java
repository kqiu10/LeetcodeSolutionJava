package LinkedList链表.Delete;
/**
 * Package Name : LinkedList链表.Delete;
 * File name : _82_RemoveDuplicatesfromSortedListII;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class _82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int sameVal = p.next.val;
                while (p.next != null && p.next.val == sameVal) {
                    p.next = p.next.next;
                }
            } else p = p.next;
        }
        return dummy.next;

    }
}
