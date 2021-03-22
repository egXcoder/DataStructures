package com.company.ds.Contracts;

public interface List<E> {
    public void add(E element);
    public void remove(E element);
    public boolean contains(E element);
    public int getCurrentSize();
    public boolean isEmpty();
}
