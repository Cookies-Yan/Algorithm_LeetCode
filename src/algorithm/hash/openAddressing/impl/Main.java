package algorithm.hash.openAddressing.impl;

import algorithm.hash.IHashTable;

public class Main {

    public static void main(String[] args) {
        IHashTable<Integer, Integer> hashTable = new HashTableOpenAddressingImpl<>();
        hashTable.put(1,1);
        hashTable.put(11,1);
        hashTable.put(21,1);
        hashTable.put(31,1);
        hashTable.put(42,1);
        hashTable.print();
        hashTable.put(25,1);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();
    }
}