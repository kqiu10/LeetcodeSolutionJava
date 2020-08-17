package LinkedList链表.Basic;
/**
 * Package Name : LinkedList链表.Basic链表;
 * File name : RotateList61;
 * Creator: Kane;
 * Date: 8/16/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: TODO
 */
public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        cur.next = head;
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;


    }
}
