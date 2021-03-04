package com.company.ds;

import java.util.Iterator;

public class HashSet<K extends Comparable<K>> implements Iterable<K> {
    private final HashMap<K,Object> hashMap;
    private static final Object PRESENT = new Object();

    public HashSet(){
        hashMap = new HashMap<K,Object>();
    }

    public HashSet(int tableSize){
        hashMap = new HashMap<K,Object>(tableSize);
    }

    public void add(K element){
        hashMap.put(element,PRESENT);
    }

    public boolean contains(K element){
        return hashMap.contains(element);
    }

    public boolean remove(K element){
        return hashMap.remove(element);
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private class ItertatorHelper<T> implements Iterator<T>{
        private K[] keys;
        public ItertatorHelper(){

        }
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
