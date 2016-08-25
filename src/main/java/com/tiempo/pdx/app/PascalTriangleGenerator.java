package com.tiempo.pdx.app;


public class PascalTriangleGenerator {
    private final PascalTriangleCalculator pascalTriangleCalculator;
    private final PascalTrianglePrinter pascalTrianglePrinter;

    public PascalTriangleGenerator(PascalTriangleCalculator pascalTriangleCalculator, PascalTrianglePrinter pascalTrianglePrinter) {
        this.pascalTriangleCalculator = pascalTriangleCalculator;
        this.pascalTrianglePrinter = pascalTrianglePrinter;
    }

    public void generate(int level) {
        PascalTriangle pascalTriangle = pascalTriangleCalculator.calculate(level);
        pascalTrianglePrinter.print(pascalTriangle);
    }
}
