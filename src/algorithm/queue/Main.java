package algorithm.queue;

import algorithm.queue.impl.ArrayCircularOfQueueImpl;
import algorithm.queue.impl.ArrayOfQueueImpl;
import algorithm.queue.impl.LinkedListOfQueueImpl;

public class Main {

    public static void testLinkedListOfQueue() {
        IMyQueue<Integer> queue = new LinkedListOfQueueImpl<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
            queue.print();
        }
        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayOfQueue(){
        IMyQueue<Integer> queue = new ArrayOfQueueImpl<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
            queue.print();
        }
        System.out.println(queue.poll());
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayCircularOfQueue() {
        IMyQueue<Integer> queue = new ArrayCircularOfQueueImpl<>();
        for (int i = 0; i < 9; i++) {
            queue.offer(i);
        }
        queue.print();
        queue.poll();
        queue.poll();
        queue.poll();
//        System.out.println(queue.poll());
        queue.print();
        queue.offer(11);
        queue.offer(21);
        queue.offer(31);
        queue.print();
        queue.offer(41);
        queue.print();
//        System.out.println(queue.peek());

    }

    public static void main(String[] args) {
//        testArrayOfQueue();
//        testLinkedListOfQueue();
        testArrayCircularOfQueue();
    }

}
