package LinkedList链表.综合练习;
/**
 * Package Name : LinkedList链表.综合练习;
 * File name : FlattenaMultilevelDoublyLinkedList430;
 * Creator: Kane;
 * Date: 8/20/20
 */

/**
 * Time complexity:O(n);
 * Space complexity: O(n);
 * Description: TODO
 */
public class FlattenaMultilevelDoublyLinkedList430 {
    public Node flatten(Node head) {
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node right = node.next;

                node.next = flatten(node.child);
                node.next.prev = node;
                node.child = null;
                while (node.next != null) {
                    node = node.next;
                }

                if (right != null) {
                    node.next = right;
                    node.next.prev = node;


                }

            }
            node = node.next;
        }
        return head;

    }
}
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int val, Node prev, Node next, Node child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
};
