package com.tiempo.pdx.app;

import java.util.Iterator;
import java.util.List;

class PascalTriangleIterator implements Iterator<List<Integer>> {

    private int cursor = 0;
    private PascalTriangle pascalTriangle;

    PascalTriangleIterator(PascalTriangle pascalTriangle) {
        this.pascalTriangle = pascalTriangle;
    }

    public boolean hasNext() {
        return cursor < pascalTriangle.getLevel();
    }

    public List<Integer> next() {
        return pascalTriangle.getLevelListAt(cursor++);
    }

    public void remove() {

    }
}
