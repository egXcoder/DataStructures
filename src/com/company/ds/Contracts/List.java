package com.company.ds.Contracts;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    public void add(E element);
    public boolean remove(E element);
    public boolean contains(E element);
    public int getCurrentSize();
    public boolean isEmpty();
    public Iterator<E> iterator();
}
