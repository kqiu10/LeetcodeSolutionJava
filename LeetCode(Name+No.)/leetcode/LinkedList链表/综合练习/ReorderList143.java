package LinkedList链表.综合练习;
/**
 * Package Name : LinkedList链表.综合练习;
 * File name : ReorderList143;
 * Creator: Kane;
 * Date: 8/20/20
 */


/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = head;
        ListNode temp = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l2  = reverse(slow);
        merge(l1, l2);

    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }
        return prev;
    }
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null) break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;

        }
    }

}
