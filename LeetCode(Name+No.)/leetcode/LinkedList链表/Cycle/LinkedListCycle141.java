package LinkedList链表.Cycle;
/**
 * Package Name : LinkedList链表.Cycle;
 * File name : LinkedListCycle141;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;

    }
}
