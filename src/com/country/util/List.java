package com.country.util;

public interface List<E> {

    int size();
    boolean isEmpty();
    boolean contains(E o);
    Iterator<E> iterator();
    boolean add(E e);
    E remove(int index);
    E get(int index);
    void removeAll();
}
