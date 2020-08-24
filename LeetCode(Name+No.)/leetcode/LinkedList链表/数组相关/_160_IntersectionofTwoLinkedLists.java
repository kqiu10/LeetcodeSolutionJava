package LinkedList链表.数组相关;
/**
 * Package Name : LinkedList链表.数组相关;
 * File name : _160_IntersectionofTwoLinkedLists;
 * Creator: Kane;
 * Date: 8/19/20
 */

/**
 * Time complexity:O(m + n);
 * Space complexity: O(1);
 * Description:
 *
 * A:           a1 -> a2
 *                       ↘
 *                       c1 -> c2 -> c3
 *                       ↗
 * B:     b1 -> b2 -> b3
 *
 * A: a1 -> a2 -> c1 -> c2 -> c3 -> b1 -> b2 -> b3 -> c1 -> c2 -> c3;
 * B: b1 -> b2 -> b3 -> c1 -> c2 -> c3 -> a1 -> a2 -> c1 -> c2 -> c3;
 */
public class _160_IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(1);
 * Description:
 *
 * A:           a1 -> a2
 *                       ↘
 *                       c1 -> c2 -> c3
 *                       ↗
 * B:     b1 -> b2 -> b3
 */
class ntersectionofTwoLinkedListsII {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
    private int len(ListNode head) {
        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
