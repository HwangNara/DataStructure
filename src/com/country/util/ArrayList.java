package com.country.util;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_SIZE = 10000;
    private Object[] list;
    private int size;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int createSize) {
        list = new Object[createSize];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : list) {
            if (o.equals(element))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator<E>();
    }

    @Override
    public boolean add(E e) {
        if (size == list.length) return false;
        list[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) throw new ArrayIndexOutOfBoundsException(index + " index is no exist");

        Object temp = list[index];
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[--size] = null;
        return (E) temp;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException(index + " index is over the bound.");
        return (E) list[index];
    }

    @Override
    public void removeAll() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private class ArrayListIterator<E> implements Iterator<E> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return ArrayList.this.size > index;
        }

        @Override
        public E next() {
            return (E) ArrayList.this.list[index++];
        }
    }
}
