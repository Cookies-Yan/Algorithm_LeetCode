package algorithm.hash.SeparateChaining.impl;

import algorithm.hash.IHashTable;

public class Main {

    public static void main(String[] args) {
        IHashTable<Integer, Integer> hashTable = new HashTableSeparateChiainingImpl<>();
        hashTable.put(1,1);
        hashTable.put(11,1);
        hashTable.put(21,1);
        hashTable.put(12,1);
        hashTable.put(22,1);
        hashTable.put(25,1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();


    }
}
