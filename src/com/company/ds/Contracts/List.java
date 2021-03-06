package com.company.ds.Contracts;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    public void add(E element);
    public boolean remove(E element);
    public boolean contains(E element);
    public E get(int index);
    public int getSize();
    public boolean isEmpty();
    public Iterator<E> iterator();
}
