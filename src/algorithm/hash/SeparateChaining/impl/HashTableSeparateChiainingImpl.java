package algorithm.hash.SeparateChaining.impl;

import algorithm.hash.IHashTable;
import algorithm.hash.SeparateChaining.HashNode;

public class HashTableSeparateChiainingImpl<K, V> implements IHashTable<K, V>{
    //把hash的数组先定义一下
    private HashNode[] hashNodes;

    private int capacity;

    private int size;

    public HashTableSeparateChiainingImpl(){
        this.capacity = 10;
        hashNodes = new HashNode[capacity];
    }

    public HashTableSeparateChiainingImpl(int capacity){
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public void put(K key, V val) {         // 考虑有无两种情况
        HashNode<K, V> hashNode = new HashNode<>(key, val);
        //考虑两种情况，一个是原来就有，一个是原来就没有
        int index = hash(key);

        HashNode curNode = hashNodes[index];
        HashNode preNode = hashNodes[index];

        if(curNode == null) {
            hashNodes[index] = hashNode;
        } else {
            //在同一个index下，如果模7，就可能出现（1，9）(8，9)这种情况，key不同，但在同样的index下
            while (curNode != null){
                if(curNode.key.equals(key)) {
                    curNode.value = val;
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
            preNode.next = hashNode;

        }
        size++;

    }

    @Override
    public V get(K key) {           // 考虑有无两种情况
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        while (curNode != null) {
            if(curNode.key.equals(key)) {
                return (V) curNode.value;
            }
            curNode = curNode.next;
        }

        return null;

    }

    @Override
    public V delete(K key) {        // 考虑有无两种情况
        int index = hash(key);
        HashNode curNode = hashNodes[index];
        HashNode preNode = null;
        while (curNode != null) {
            if(curNode.key.equals(key)) {
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        if(curNode == null) {
            return null;
        } else if (preNode == null) {    //如果找到了的，但是是在链表的最开始处，我们的preNode为空，直接删除。
            hashNodes[index] = curNode.next;
        } else {
            preNode.next = curNode.next;
        }
        size--;
        return (V) curNode.value;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for(HashNode<K, V> hashNode: hashNodes) {
            if(hashNode != null) {
                while (hashNode != null){
                    System.out.print("key : " + hashNode.key + " value " + hashNode.value + " -> ");
                    hashNode = hashNode.next;
                }
                System.out.println("null");
            }
        }
        System.out.println("size " + size);
    }
}
