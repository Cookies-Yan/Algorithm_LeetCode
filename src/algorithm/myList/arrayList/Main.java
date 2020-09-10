package algorithm.myList.arrayList;

import algorithm.myList.arrayList.impl.ArrayListImpl;

public class Main {

    public static void main(String[] args) {
        ArrayListImpl arrayList = new ArrayListImpl();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(0, 0);
//        arrayList.remove(1);
//        arrayList.removeElement(0);
//        arrayList.print();
////        System.out.println(arrayList.get(0));
//        arrayList.set(0,1);
//        arrayList.print();
        for (int i = 0; i < 11; i++) {
            arrayList.add(i);
        }
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.print();
    }
}
