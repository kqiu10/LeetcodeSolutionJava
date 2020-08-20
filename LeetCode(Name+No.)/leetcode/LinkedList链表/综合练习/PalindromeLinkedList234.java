package LinkedList链表.综合练习;
/**
 * Package Name : LinkedList链表.综合练习;
 * File name : PalindromeLinkedList234;
 * Creator: Kane;
 * Date: 8/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description: findMiddle + reverse
 * Ex 1 -> 2 -> 2 -> 1
 *
 * p 1 -> 2 -> 1 -> 2;
 * q 1 -> 2
 */
public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode p = head;
        ListNode q = middle.next;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return true;

    }
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;

        }
        return prev;
    }

    public static void main(String[] args) {
        isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
    }
}
