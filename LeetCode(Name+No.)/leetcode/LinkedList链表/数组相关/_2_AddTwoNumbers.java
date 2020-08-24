package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : _2_AddTwoNumbers;
 * Creator: Kane;
 * Date: 8/19/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode p = l1, q = l2;
        int carry = 0;
        ListNode cur = dummy;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = carry + x + y;

            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            if (p != null) p = p.next;
            if (q != null) q = q.next;
            cur = cur.next;
        }
        if (carry > 0) cur.next = new ListNode(carry);
        return dummy.next;

    }
}
