package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;

import java.util.Iterator;
import java.util.List;

public class PascalTrianglePrinter {
    private static final String BLANK_SPACE = " ";
    private static final String SLASH = "/";
    private static final String BACK_SLASH = "\\";
    private Console console;

    public PascalTrianglePrinter(Console console) {
        this.console = console;
    }

    void print(PascalTriangle pascalTriangle) {
        int level = pascalTriangle.getLevel();
        int initialSpacesLength = 2 * level - 2;
        int x = level - 2;

        printFirstLine(initialSpacesLength);

        Iterator<List<Integer>> iterator = pascalTriangle.iterator();
        iterator.next();

        if (level == 2) {
            printMaster(level, iterator, x--, --initialSpacesLength, --initialSpacesLength - 1);
        }

        if (level > 2)
            for (int currentLevel = 1; currentLevel < level; currentLevel++) {
                printMaster(level, iterator, x--, --initialSpacesLength, --initialSpacesLength);
            }
    }

    private void printMaster(int level, Iterator<List<Integer>> iterator, int y, int z, int w) {
        printConnectorLine(level - y, z);
        printDataLine(iterator.next(), w);
    }

    private void printDataLine(List<Integer> currentLine, int times) {
        console.printLine(repeatSpace(times) + formatLine(currentLine));
    }

    private String formatLine(List<Integer> data) {
        String line = "";
        for (Integer number : data) {
            int digitCount = number.toString().length();
            line += number + repeatSpace(digitCount == 1 ? 3: digitCount == 2 ? 2 : 1);
        }
        return line.substring(0, line.length() - 3);
    }

    private void printConnectorLine(int level, int initialSpacesLength) {
        console.printLine(repeatSpace(initialSpacesLength) + connectorsLineFor(level));
    }

    private void printFirstLine(int initialSpacesLength) {
        console.printLine(repeatSpace(initialSpacesLength) + "1");
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
