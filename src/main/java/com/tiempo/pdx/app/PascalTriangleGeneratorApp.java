package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;


@SuppressWarnings("WeakerAccess")
public class PascalTriangleGeneratorApp {
    public static void main(String[] args) {
        PascalTriangleCalculator calculator = new PascalTriangleCalculator();
        Console console = new Console();
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        PascalTriangleGenerator generator = new PascalTriangleGenerator(calculator, printer);

        generator.generate(13);
    }
}
