package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;

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

        printFirstLine(initialSpacesLength);

        if (level == 2) {
            initialSpacesLength = printConnectorLine(level, initialSpacesLength);
            console.printLine("1" + repeatSpace(level + 1) + "1");
        }

        if (level == 3) {
            initialSpacesLength = printConnectorLine(level - 1, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "2" + repeatSpace(3) + "1");

        }

        if (level == 4) {
            initialSpacesLength = printConnectorLine(level - 2, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level - 1, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "2" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "3" + repeatSpace(3) + "3" + repeatSpace(3) + "1");

        }

        if (level == 5) {
            initialSpacesLength = printConnectorLine(level - 3, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level - 2, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "2" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level - 1, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "3" + repeatSpace(3) + "3" + repeatSpace(3) + "1");
            initialSpacesLength = printConnectorLine(level, initialSpacesLength);
            console.printLine(repeatSpace(--initialSpacesLength) + "1" + repeatSpace(3) + "4" + repeatSpace(3) + "6" + repeatSpace(3) + "4" + repeatSpace(3) + "1");

        }
    }

    private int printConnectorLine(int level, int initialSpacesLength) {
        console.printLine(repeatSpace(--initialSpacesLength) + conectores(level));
        return initialSpacesLength;
    }

    private void printFirstLine(int initialSpacesLength) {
        console.printLine(repeatSpace(initialSpacesLength) + "1");
    }

    private String conectores(int level) {
        String conector = patron() + BLANK_SPACE;
        for (int i = 1; i < level - 1; i++) {
            conector += patron() + BLANK_SPACE;
        }
        return conector.substring(0, conector.length() - 1);
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
