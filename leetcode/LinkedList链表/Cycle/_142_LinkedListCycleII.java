package LinkedList链表.Cycle;
/**
 * Package Name : LinkedList链表.Cycle;
 * File name : _142_LinkedListCycleII;
 * Creator: Kane;
 * Date: 8/18/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(1;
 * Description: Web:    https://www.cnblogs.com/hygeia/p/4765518.html
 * 设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L。slow和fast的速度分别是qs,qf。
 *
 * 下面我们来挨个问题分析。
 * 方法三（最简单）：
 * 第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。
 * 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
 *
 * 方法一（网上都是这个答案）：
 * 第一次相遇后，让slow,fast继续走，记录到下次相遇时循环了几次。因为当fast第二次到达Z点时，fast走了一圈，slow走了半圈，而当fast第三次到达Z点时，fast
 * 走了两圈，slow走了一圈，正好还在Z点相遇。
 *
 * 方法二：
 * 第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。
 *

 */
public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode slow2 = head;
                ListNode slow3 = fast;
                while (slow2 != slow3){
                    slow2 = slow2.next;
                    slow3 = slow3.next;
                }
                return slow2;
            }
        }
        return null;

    }
}
