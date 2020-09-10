package algorithm.myList.linkedList;

import algorithm.myList.IMyList;
import algorithm.myList.arrayList.impl.ArrayListImpl;
import algorithm.myList.linkedList.impl.LinkedListImpl;

public class Main {
    public static void main(String[] args) {
        ILinkedList<Integer> linkedList = new LinkedListImpl<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.print();
        linkedList.add(0,5);
        linkedList.print();
        linkedList.remove(0);
        linkedList.print();

        IMyList<Integer> list = new ArrayListImpl<>();
        IMyList<Integer> list1 = new LinkedListImpl<>();

    }
}
