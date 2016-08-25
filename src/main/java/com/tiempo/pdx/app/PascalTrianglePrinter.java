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
        int numberOfSpacesAtTheBeginningOfLine = LEVEL_START * level - LEVEL_START;
        int x = level - LEVEL_START;
        Iterator<List<Integer>> iterator = pascalTriangle.iterator();
        console.printLine(repeatSpace(numberOfSpacesAtTheBeginningOfLine) + iterator.next().get(0));
        if (level == LEVEL_START) {
            printLevel(level - 0, iterator, --numberOfSpacesAtTheBeginningOfLine, --numberOfSpacesAtTheBeginningOfLine - 1);
        }

        if (level > LEVEL_START)
            for (int currentLevel = 1; currentLevel < level; currentLevel++) {
                int extracted = x--;
                printLevel(level - extracted, iterator, --numberOfSpacesAtTheBeginningOfLine, --numberOfSpacesAtTheBeginningOfLine - 0);
            }
    }

    private void printLevel(int level, Iterator<List<Integer>> iterator, int initialSpacesLength, int numberOfSpacesAtTheBegin) {
        printConnectorLine(level, initialSpacesLength);
        printDataLine(iterator.next(), numberOfSpacesAtTheBegin);
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
        String currentLine = patron() + BLANK_SPACE;
        for (int i = 1; i < level - 1; i++) {
            currentLine += patron() + BLANK_SPACE;
        }
        return currentLine.substring(0, currentLine.length() - 1);
    }

    private String patron() {
        return SLASH + BLANK_SPACE + BACK_SLASH;
    }

    private String repeatSpace(int times) {
        String repeated = "";
        for (int i = 1; i <= times; i++) {
            repeated += BLANK_SPACE;
        }
        return repeated;
    }
}
