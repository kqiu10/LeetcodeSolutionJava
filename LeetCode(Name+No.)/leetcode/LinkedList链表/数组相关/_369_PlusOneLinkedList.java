package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : _369_PlusOneLinkedList;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * corner case : dummy -> 9 -> 9 -> 9;
 */
public class _369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) i = j;
        }
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;


    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 * corner case : use reverse;
 */
class PlusOneLinkedListII {
    public static ListNode plusOne(ListNode head) {
        head = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int carry = 1;
        while (carry > 0 || cur.next != null) {
            if (cur.next != null) {
                cur = cur.next;
                carry += cur.val;
                cur.val = carry % 10;
                carry /= 10;
            } else {
                cur.next = new ListNode(carry);
                cur = cur.next;
                carry = 0;
            }
        }
        return reverse(dummy.next);

    }
    private static  ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        plusOne(new ListNode(9, new ListNode(9, new ListNode(9))));
    }
}
