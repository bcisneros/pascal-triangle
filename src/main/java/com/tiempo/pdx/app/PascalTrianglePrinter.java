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
        printLevel(pascalTriangle);
    }

    private void printLevel(PascalTriangle pascalTriangle) {
        Iterator<List<Integer>> iterator = pascalTriangle.iterator();
        while (iterator.hasNext()) {
            List<Integer> list = iterator.next();
            int level = pascalTriangle.getLevel();
            int currentLevel = list.size();
            int position = level - currentLevel + 1;

            int spaces = numberOfSpacesFor(position);

            printDataLine(list, spaces - 1);
            if (level > 1 && currentLevel < level)
                printConnectorLine(currentLevel, spaces - 2);
        }
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
        for (int i = 0; i < level - 1; i++) {
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

    private int numberOfSpacesFor(int level) {
        return level > 1 ? 2 * level - 1 : 0;
    }
}
