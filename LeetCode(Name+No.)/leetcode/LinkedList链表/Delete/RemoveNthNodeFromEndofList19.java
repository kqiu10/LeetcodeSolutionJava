package LinkedList链表.Delete;
/**
 * Package Name : LinkedList链表.Delete;
 * File name : RemoveNthNodeFromEndofList19;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: Tow Pointers
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 1st for loop
 * Advances first pointer so that the gap between first and second is n nodes apart
 *
 * 2ed for loop
 * Move first to the end, maintaining the gap
 * dummy -> 1 -> 2 -> 3 -> 4 -> 5
 *                   fast
 *                   slow
 */
public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
