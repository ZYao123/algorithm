package com.leetcode;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution_284 {

}

class PeekingIterator implements Iterator {

    Iterator<Integer> it;
    Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
        if (it.hasNext()) {
            next = it.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
// Override them if needed.
    @Override
    public Integer next() {
        Integer res = next;
        if (it.hasNext()) {
            next = it.next();
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
