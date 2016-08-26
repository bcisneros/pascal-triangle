package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;

public class PascalTriangleGeneratorApp {
    private static PascalTriangleGenerator generator =
            new PascalTriangleGenerator(new PascalTriangleCalculator(),
                    new PascalTrianglePrinter(new Console()));
    private static Console console = new Console();

    public PascalTriangleGeneratorApp(PascalTriangleGenerator generator, Console console) {

        PascalTriangleGeneratorApp.generator = generator;
        PascalTriangleGeneratorApp.console = console;
    }

    public static void main(String[] args) {
        try {
            generator.generate(Integer.parseInt(args[0]));
        } catch (NumberFormatException e) {
            console.printLine("The input parameter is not an integer number, please enter a valid value.");
        }
    }
}
