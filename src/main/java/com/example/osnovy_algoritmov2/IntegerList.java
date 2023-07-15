package com.example.osnovy_algoritmov2;

public interface IntegerList {

    Integer add(Integer item);
    Integer add(int index, Integer item);
    Integer set(int index, Integer item);
    Integer remove(Integer item) throws ElementNotFoundException;
    Integer remove(int index) throws ElementNotFoundException;
    boolean contains(Integer item);
    int indexOf(Integer item);
    int lastIndexOf(Integer item);
    Integer get(int index);
    boolean equals(IntegerList otherList);
    int size();
    boolean isEmpty();
    void clear();
    Integer[] toArray();
    }
