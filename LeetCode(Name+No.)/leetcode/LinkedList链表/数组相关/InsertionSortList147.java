package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : InsertionSortList147;
 * Creator: Kane;
 * Date: 8/20/20
 */

/**
 * Time complexity:O(n^2);
 * Space complexity: O(1);
 * Description: TODO
 */
public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode temp = null, prev = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;

    }
}
