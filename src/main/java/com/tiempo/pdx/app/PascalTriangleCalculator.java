package com.tiempo.pdx.app;


import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class PascalTriangleCalculator {
    PascalTriangle calculate(int level) {
        PascalTriangle pascalTriangle = new PascalTriangle(level);

        List<Integer> level1 = singletonList(1);
        Integer[] previousLevel = new Integer[]{1};
        pascalTriangle.addLevel(level1);
        for (int currentLevel = 2; currentLevel <= level; currentLevel++) {
            List<Integer> currentLevelList = new ArrayList<Integer>(currentLevel);

            for (int currentListElementCount = 0; currentListElementCount < currentLevel; currentListElementCount++) {
                currentLevelList.add(sumConsecutives(previousLevel, currentListElementCount - 1));
            }

            pascalTriangle.addLevel(currentLevelList);
            previousLevel = currentLevelList.toArray(new Integer[]{});
        }


        return pascalTriangle;
    }

    private Integer sumConsecutives(Integer[] integer, int startIndex) {
        Integer firstNumber = startIndex < 0 ? 0 : integer[startIndex];
        int consecutive = startIndex + 1;

        Integer secondNumber = consecutive >= integer.length ? 0 : integer[consecutive];
        return firstNumber + secondNumber;
    }
}
