package com.company.ds.Contracts;

public interface List<E> {
    public void add(E element);
    public boolean remove(E element);
    public boolean contains(E element);
    public int getCurrentSize();
    public boolean isEmpty();
}
