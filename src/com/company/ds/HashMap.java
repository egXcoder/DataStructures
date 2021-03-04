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

    public KeySet keySet(){
       return new KeySet();
    }

    public ValueSet valueSet(){
        return new ValueSet();
    }

    public EntrySet entrySet(){
        return new EntrySet();
    }

    public class KeySet implements Iterable<K>{
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator<K>();
        }
    }

    public class ValueSet implements Iterable<V>{
        @Override
        public Iterator<V> iterator() {
            return new ValuesIterator<V>();
        }
    }

    public class EntrySet implements Iterable<HashElement<K,V>>{
        @Override
        public Iterator<HashElement<K,V>> iterator() {
            return new EntryIterator<HashElement<K,V>>();
        }
    }

    abstract class HashTableIterator{
        private HashElement<K,V>[] hashElements;
        private int position;

        public HashTableIterator(){
            hashElements = (HashElement<K,V>[]) new HashElement[numOfElements];

            int j=0;
            for(int i=0;i<hArray.length;i++){
                for(HashElement hashElement : hArray[i]){
                    hashElements[j++] = hashElement;
                }
            }

            position = 0;
        }

        public boolean hasNext() {
            return position< hashElements.length;
        }

        protected HashElement<K,V> nextNode(){
           return hashElements[position++];
        }
    }

    final class KeyIterator<T> extends HashTableIterator implements Iterator<T>{
        @Override
        public T next() {
            return (T) nextNode().key;
        }
    }

    final class ValuesIterator<T> extends HashTableIterator implements Iterator<T>{
        @Override
        public T next() {
            return (T) nextNode().value;
        }
    }

    final class EntryIterator<T> extends HashTableIterator implements Iterator<T>{
        @Override
        public T next() {
            return (T) nextNode();
        }
    }
}
