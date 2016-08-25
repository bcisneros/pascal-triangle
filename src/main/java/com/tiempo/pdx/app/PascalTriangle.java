package com.tiempo.pdx.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PascalTriangle {
    private final List<List<Integer>> levels;

    PascalTriangle() {
        levels = new ArrayList<List<Integer>>();
    }

    Iterator<List<Integer>> iterator() {
        return new PascalTriangleIterator(this);
    }

    int getLevel() {
        return levels.size();
    }

    void addLevel(List<Integer> level) {
        levels.add(level);
    }

    List<Integer> getLevelListAt(int level) {
        return level < levels.size() ? levels.get(level) : null;
    }
}
