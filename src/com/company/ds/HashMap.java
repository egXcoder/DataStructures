package com.company.ds;

import java.util.Iterator;

public class HashMap <K extends Comparable<K>,V> implements Iterable<K>{
    private static class HashElement<K extends Comparable<K>,V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;
        public HashElement(K key,V value){
            this.key = key;
            this.value=value;
        }

        @Override
        public int compareTo(HashElement<K,V> hashElement) {
            return (key).compareTo(hashElement.key);
        }
    }

    LinkedList<HashElement<K,V>>[] hArray;
    int numOfElements;
    int tableSize;
    private static final double MAX_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_TABLE_SIZE = 11;

    public HashMap(){
        this(DEFAULT_TABLE_SIZE);
    }

    public HashMap(int tableSize){
        if(tableSize<1){
            throw new IllegalArgumentException("Hash Map Size should be at least one");
        }
        hArray = (LinkedList<HashElement<K,V>> []) new LinkedList[tableSize];
        for (int i=0;i<tableSize;i++){
            hArray[i] = new LinkedList<HashElement<K,V>>();
        }
        numOfElements = 0;
        this.tableSize=tableSize;
    }

    public boolean add(K key,V value){
        if(loadFactor()>MAX_LOAD_FACTOR){
            resize();
        }

        //wrap k,v in Hashelement
        HashElement<K,V> he = new HashElement<K,V>(key,value);
        //get index of key then get linkedlist at index
        LinkedList<HashElement<K,V>> l = this.hArray[getIndexOfKeyByTableSize(key,tableSize)];
        //add to linkedlist
        l.addLast(he);
        numOfElements++;
        return true;
    }

    public boolean remove(K key){
        //wrap k,v in HashElement, we passed value as null
        HashElement<K,V> he = new HashElement<K,V>(key,null);
        //get index of key then get linkedlist at index
        LinkedList<HashElement<K,V>> l = this.hArray[getIndexOfKeyByTableSize(key,tableSize)];
        //remove from linkedlist, when linkedlist tried to remove, it will call the compareTo on the HashElement
        //HashElement compare to is totally depend on the key, so its value can be null and it won't affect the logic
        l.remove(he);
        numOfElements--;
        return true;
    }

    public V getValue(K key){
        HashElement<K,V> he = new HashElement<K,V>(key,null);
        LinkedList<HashElement<K,V>> l = this.hArray[getIndexOfKeyByTableSize(key,tableSize)];
        HashElement<K,V> found = l.find(he);
        if(found !=null){
            return found.value;
        }
        return null;
    }

    public void resize(){
        int newTableSize = tableSize*2;

        //create new hArray with double the size
        LinkedList<HashElement<K,V>>[] newHArray = (LinkedList<HashElement<K,V>> []) new LinkedList[newTableSize];

        //initiatlize each of element with linkedlist object
        for (int i=0;i<newTableSize;i++){
            newHArray[i] = new LinkedList<HashElement<K,V>>();
        }

        for(K key:this){
            newHArray[getIndexOfKeyByTableSize(key,newTableSize)].addLast(
                    new HashElement<K,V>(key,getValue(key))
            );
        }
        tableSize=newTableSize;
        hArray = newHArray;
    }



    private double loadFactor(){
        return numOfElements/tableSize;
    }

    private int getIndexOfKeyByTableSize(K key,int tableSize){
        //get hashcode of key
        int hashCode = key.hashCode();
        //make sure hashcode is positive integer
        hashCode = hashCode & 0x7FFFFFFF;
        //index=modules hashcode with table size
        return (hashCode%tableSize);
    }

    @Override
    public Iterator<K> iterator() {
        return new IteratorHelper<K>();
    }

    private class IteratorHelper<T> implements Iterator<T>{
        T[] keys;
        int position;

        public IteratorHelper(){
            keys = (T[]) new Object[numOfElements];
            for(int i=0;i<tableSize;i++){
                for(HashElement<K,V> he : hArray[i]){
                    keys[position++] = (T) he.key;
                }
            }
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return position<keys.length;
        }

        @Override
        public T next() {
           if(!hasNext())
               return null;

           return keys[position++];
        }
    }
}
