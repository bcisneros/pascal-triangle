package com.tiempo.pdx.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PascalTriangle {
    private int level;
    private List<List<Integer>> levels;

    PascalTriangle(int level) {
        this.level = level;
        levels = new ArrayList<List<Integer>>(level);
    }

    Iterator<List<Integer>> iterator() {
        return new PascalTriangleIterator(this);
    }

    int getLevel() {
        return level;
    }

    void addLevel(List<Integer> level) {
        levels.add(level);
    }

    List<Integer> getLevelListAt(int level) {
        return level < levels.size() ? levels.get(level) : null;
    }
}
