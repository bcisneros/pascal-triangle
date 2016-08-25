package com.tiempo.pdx.app;


public class PascalTriangleGenerator {
    private PascalTriangleCalculator pascalTriangleCalculator;
    private PascalTrianglePrinter pascalTrianglePrinter;

    public PascalTriangleGenerator(PascalTriangleCalculator pascalTriangleCalculator, PascalTrianglePrinter pascalTrianglePrinter) {
        this.pascalTriangleCalculator = pascalTriangleCalculator;
        this.pascalTrianglePrinter = pascalTrianglePrinter;
    }

    public void generate(int level) {
        PascalTriangle pascalTriangle = pascalTriangleCalculator.calculate(level);
        pascalTrianglePrinter.print(pascalTriangle);
    }
}
