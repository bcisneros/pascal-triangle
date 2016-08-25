package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;

import java.util.Iterator;
import java.util.List;

public class PascalTrianglePrinter {
    private static final String BLANK_SPACE = " ";
    private static final String SLASH = "/";
    private static final String BACK_SLASH = "\\";
    private static final int LEVEL_START = 2;
    private final Console console;


    public PascalTrianglePrinter(Console console) {
        this.console = console;
    }

    void print(PascalTriangle pascalTriangle) {
        int level = pascalTriangle.getLevel();
        Iterator<List<Integer>> iterator = pascalTriangle.iterator();
        for (int currentLevel = 1; currentLevel <= level; currentLevel++) {
            printLevel(iterator.next(), level);
        }
    }

    private void printLevel(List<Integer> list, int realLevel) {
        int currentLevel = list.size();
        int position = getPosition(realLevel - currentLevel);

        if (realLevel > 1)
            printConnectorLine(currentLevel, position);
        printDataLine(list, position - 1);
    }

    private void printDataLine(List<Integer> currentLine, int numberOfSpacesAtTheBegin) {
        console.printLine(repeatSpace(numberOfSpacesAtTheBegin) + formatLine(currentLine));
    }

    private String formatLine(List<Integer> data) {
        String line = "";
        for (Integer number : data) {
            int digitCount = number.toString().length();
            line += number + repeatSpace(digitCount == 1 ? 3 : digitCount == LEVEL_START ? LEVEL_START : 1);
        }
        return line.substring(0, line.length() - 3);
    }

    private void printConnectorLine(int level, int initialSpacesLength) {
        console.printLine(repeatSpace(initialSpacesLength) + connectorsLineFor(level));
    }

    private String connectorsLineFor(int level) {
        String currentLine = lineConnector() + BLANK_SPACE;
        for (int i = 1; i < level - 1; i++) {
            currentLine += lineConnector() + BLANK_SPACE;
        }
        return currentLine.substring(0, currentLine.length() - 1);
    }

    private String lineConnector() {
        return SLASH + BLANK_SPACE + BACK_SLASH;
    }

    private String repeatSpace(int times) {
        String repeated = "";
        if (times < 1)
            return "";
        for (int i = 1; i <= times; i++) {
            repeated += BLANK_SPACE;
        }
        return repeated;
    }

    protected int getPosition(int index) {
        int array[] = {1, 3, 5, 7, 9, 11, 13, 15, 17};
        return array[index];
    }
}
