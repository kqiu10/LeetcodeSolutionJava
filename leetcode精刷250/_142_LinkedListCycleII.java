/**
 * Date: 11/14/20
 * Question Description
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

 Notice that you should not modify the linked list.
 Example 1:
 Input: head = [3,2,0,-4], pos = 1
 Output: tail connects to node index 1
 Explanation: There is a cycle in the linked list, where tail connects to the second node.
 Example 2:


 Input: head = [1,2], pos = 0
 Output: tail connects to node index 0
 Explanation: There is a cycle in the linked list, where tail connects to the first node.
 Example 3:


 Input: head = [1], pos = -1
 Output: no cycle
 Explanation: There is no cycle in the linked list.
 */

import LinkedList链表.Basic.ListNode;

/**

 * Description: Web:    https://www.cnblogs.com/hygeia/p/4765518.html
 * 设：链表头是X，环的第一个节点是Y，slow和fast第一次的交点是Z。各段的长度分别是a,b,c，如图所示。环的长度是L。slow和fast的速度分别是qs,qf。
 *
 * 下面我们来挨个问题分析。
 * 方法三（最简单) ----使用的方法
 * 第一次相遇时slow走过的距离：a+b，fast走过的距离：a+b+c+b。
 * 因为fast的速度是slow的两倍，所以fast走的距离是slow的两倍，有 2(a+b) = a+b+c+b，可以得到a=c（这个结论很重要！）。
 *
 * 方法一（网上都是这个答案）：
 * 第一次相遇后，让slow,fast继续走，记录到下次相遇时循环了几次。因为当fast第二次到达Z点时，fast走了一圈，slow走了半圈，而当fast第三次到达Z点时，fast
 * 走了两圈，slow走了一圈，正好还在Z点相遇。
 *
 * 方法二：
 * 第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。

 * Time complexity:O(n);
 * Space complexity: O(1);

 */
public class _142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;

    }
}
