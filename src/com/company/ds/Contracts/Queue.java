package com.company.ds.Contracts;

public interface Queue<E> {
    public void add(E element);
    public E poll();
    public E peek();
}
