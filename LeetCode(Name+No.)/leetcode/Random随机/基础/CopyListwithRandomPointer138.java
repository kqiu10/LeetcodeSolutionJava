package Random随机.基础;
/**
 * Package Name : Random随机.基础;
 * File name : CopyListwithRandomPointer138;
 * Creator: Kane;
 * Date: 8/20/20
 */

import java.util.HashMap;

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: HashMap
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListwithRandomPointer138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: usual way
 * 1 -> 1' -> 2 -> 2' -> 3 -> 3'
 */
class CopyListwithRandomPointerII{
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node next;
        //handle next
        while (cur != null) {
            next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        //handle random
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //divide list to two list
        cur = head;
        Node dummy = new Node(0);
        Node copy;
        Node copycur = dummy;
        /**
         * 1 -> 1' -> 2 -> 2' -> 3 -> 3'
         * cur        next
         *      copy
         * traverse to
         * 1 -> 2 -> 3 -> 4
         * dummy -> 1' -> 2' -> 3' -> 4'
         */
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copycur.next = copy;
            copycur = copy;
            cur.next = next;
            cur = cur.next;
        }
        return dummy.next;

    }
}