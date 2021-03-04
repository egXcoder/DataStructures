package com.company.ds;

import java.util.Iterator;

public class HashMap <K extends Comparable<K>,V>{
    private static class HashElement<K extends Comparable<K>,V> implements Comparable<HashElement<K,V>>{
        K key;
        V value;
        public HashElement(K key,V value){
            this.key = key;
            this.value=value;
        }

        @Override
        public int compareTo(HashElement<K,V> hashElement) {
            return key.compareTo(hashElement.key);
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

    public void put(K key, V value){
        if(loadFactor()>MAX_LOAD_FACTOR){
            resize(tableSize*2+1);
        }

        LinkedList<HashElement<K,V>> linkedList = this.hArray[getIndexOfKeyByTableSize(key,tableSize)];
        for(HashElement<K,V> hashElement:linkedList){
            if(hashElement.key == key){
                hashElement.value = value;
                return;
            }
        }

        linkedList.addLast(new HashElement<K,V>(key,value));

        numOfElements++;
    }

    public boolean remove(K key){
        if(!contains(key)){
            return false;
        }

        this.hArray[getIndexOfKeyByTableSize(key,tableSize)]
                .remove(new HashElement<K,V>(key,null));

        numOfElements--;
        return true;
    }

    public boolean contains(K key){
        return this.hArray[getIndexOfKeyByTableSize(key,tableSize)]
                .find(new HashElement<K,V>(key,null)) != null;
    }

    public V getValue(K key){
        HashElement<K,V> found = this.hArray[getIndexOfKeyByTableSize(key,tableSize)]
                .find(new HashElement<K,V>(key,null));

        if(found !=null){
            return found.value;
        }

        return null;
    }


    public void resize(int newTableSize){
        LinkedList<HashElement<K,V>>[] newHArray = (LinkedList<HashElement<K,V>> []) new LinkedList[newTableSize];

        for (int i=0;i<newTableSize;i++){
            newHArray[i] = new LinkedList<HashElement<K,V>>();
        }

        for(int i=0;i<tableSize;i++){
            for(HashElement<K,V> hashElement:hArray[i]){
                newHArray[getIndexOfKeyByTableSize(hashElement.key, newTableSize)].addLast(hashElement);
            }
        }

        tableSize = newTableSize;
        hArray = newHArray;
    }

    private double loadFactor(){
        return (double) numOfElements/tableSize;
    }

    private int getIndexOfKeyByTableSize(K key,int tableSize){
        int hashCode = key.hashCode();
        hashCode = getAbsoluteValueOfHashCode(hashCode);
        return (hashCode%tableSize);
    }

    private int getAbsoluteValueOfHashCode(int hashCode){
        return hashCode & 0x7FFFFFFF;
    }

    public int getNumOfElements(){
        return numOfElements;
    }

    public KeySet<K> keySet(){
        return new KeySet<K>();
    }

    class KeySet<K> implements Iterable<K>{
        public boolean contains(K key){
            return contains(key);
        }
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator<K>();
        }
    }

    private final class KeyIterator<T> implements Iterator<T>{
        private K[] keys;
        private int position;
        public KeyIterator(){
            keys = (K[]) new Object[numOfElements];

            int j=0;
            for(int i=0;i<tableSize;i++){
                for(HashElement<K,V> hashElement:hArray[i]){
                  keys[j++] = hashElement.key;
                }
            }

            position=0;
        }
        @Override
        public boolean hasNext() {
            return position< keys.length;
        }

        @Override
        public T next() {
            if(!hasNext()){
                return null;
            }
            return (T) keys[position++];
        }
    }
}
