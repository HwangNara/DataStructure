package com.country.util;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayListTest {

    private ArrayList list;

    @Before
    public void setUp() {
        this.list = new ArrayList<String>();
        System.out.println("--- Set up. insert 5 elements...---");
        System.out.println("add(a) : " + list.add("a"));
        System.out.println("add(b) : " + list.add("b"));
        System.out.println("add(c) : " + list.add("c"));
        System.out.println("add(d) : " + list.add("d"));
        System.out.println("add(e) : " + list.add("e"));
        System.out.println("--- End set up! ---");
    }

    @Test
    public void allTest() {
        System.out.println("isEmpty() : " + list.isEmpty());
        System.out.println("size() : " + list.size());
        System.out.println(list);
        System.out.println("get(4) : " +  list.get(4));
        System.out.println("remove(0) : " + list.remove(0));
        System.out.println(list);
        System.out.println("contains(e) : " + list.contains("e"));
        System.out.println("contains(E) : " + list.contains("E"));
        Iterator a = list.iterator();
        while (a.hasNext()) {
            System.out.print(a.next() + " ");
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void failTest() {
        System.out.println(list.remove(1000));
        System.out.println(list.remove(-1));
        System.out.println(list.get(1000));
        System.out.println(list.get(-1));
    }

    @Test
    public void sizeTest() {
        assertThat(list.size(), is(5));
    }

    @Test
    public void isEmptyTest() {
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void containsTest() {
        assertThat(list.contains("e"), is(true));
        assertThat(list.contains("E"), is(false));
    }

    @Test
    public void iteratorTest() {
        List<Object> compareList =  new ArrayList<>();
        Iterator iterator = list.iterator();
        int size = 0;
        while (iterator.hasNext()) {
            compareList.add(iterator.next());
            size++;
        }
        assertThat(size, is(list.size()));
        assertThat(list.toString(), is(compareList.toString()));
    }

    @Test
    public void addTest() {
        list.removeAll();
        list.add("a");
        list.add("b");
        list.add("c");
        assertThat(list.isEmpty(), is(false));
        assertThat(list.size(), is(3));
        assertThat(list.toString(), is("[a, b, c]"));
    }

    @Test
    public void removeTest() {
        try {
            list.remove(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        list.remove(2);
        list.remove(2);

        assertThat(list.size(), is(3));
        assertThat(list.toString(), is("[a, b, e]"));
    }

    @Test
    public void getTest() {
        assertThat(list.get(0), is("a"));
        assertThat(list.get(4), is("e"));
    }

    @Test
    public void removeAllTest() {
        list.removeAll();
        assertThat(list.size(), is(0));
    }

    @Test
    public void toStringTest() {
        assertThat(list.toString(), is("[a, b, c, d, e]"));
    }
}