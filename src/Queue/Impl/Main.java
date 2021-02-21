package Queue.Impl;
/**
 * Description: TODO
 * Package Name : Queue.Impl;
 * File name : Main;
 * Creator: Kane;
 * Date: 7/23/20
 */

/**
 * Time complexity:O();
 * Space complexity: O();
 */
public class Main {
    public static void testArrayOfQueue() {
        ArrayOfQueueImpl<Integer> queue = new ArrayOfQueueImpl<>();
        for (int i = 0; i < 11; i++) {
             queue.offer(i);
             queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testLinkedListQueueImpl() {
        LinkedListQueueImpl queue = new LinkedListQueueImpl();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }
    public static void testArrayCircularOfQueueImpl() {
        ArrayCircularOfQueueImpl queue = new ArrayCircularOfQueueImpl();
        for (int i = 0; i < 9; i++) {
            queue.offer(i);
        }
        queue.print();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.print();
        queue.offer(11);
        queue.offer(21);
        queue.offer(31);
        queue.print();
        queue.offer(41);
        queue.print();

        System.out.println(queue.peek());
    }


    public static void main(String[] args) {
        testArrayCircularOfQueueImpl();
    }

}
