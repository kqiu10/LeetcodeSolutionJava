package LinkedList链表.Reverse;
/**
 * Package Name : LinkedList链表.Reverse;
 * File name : ReverseNodesinkGroup25;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;

    }
}
