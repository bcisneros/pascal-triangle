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
        List<Integer> lista = null;


        if (level == 2) {
            printMaster(level, iterator, x--, --initialSpacesLength, --initialSpacesLength - 1);
        }

        if (level == 3) {
            printMaster(level, iterator, x--, --initialSpacesLength, --initialSpacesLength);

            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

        }

        if (level == 4) {
            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

        }

        if (level == 5) {
            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

            lista = iterator.next();
            printConnectorLine(level - x--, --initialSpacesLength);
            printDataLine(lista, --initialSpacesLength);

            printMaster(level, iterator, x--, --initialSpacesLength, --initialSpacesLength);

        }
    }

    private void printMaster(int level, Iterator<List<Integer>> iterator, int y, int z, int w) {
        List<Integer> lista;
        lista = iterator.next();
        printConnectorLine(level - y, z);
        printDataLine(lista, w);
    }

    private void printDataLine(List<Integer> lista, int times) {
        console.printLine(repeatSpace(times) + lineaDatos(lista));
    }

    private String lineaDatos(List<Integer> lista) {
        String linea = "";
        for (Integer numero : lista) {
            linea += numero + repeatSpace(3);
        }
        String substring = linea.substring(0, linea.length() - 3);
        System.out.println("Substring is " + substring + ".");
        return substring;
    }

    private void printConnectorLine(int level, int initialSpacesLength) {
        console.printLine(repeatSpace(initialSpacesLength) + conectores(level));
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
