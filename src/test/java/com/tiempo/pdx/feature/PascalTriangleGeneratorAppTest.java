package com.tiempo.pdx.feature;


import com.tiempo.pdx.app.PascalTriangleCalculator;
import com.tiempo.pdx.app.PascalTriangleGenerator;
import com.tiempo.pdx.app.PascalTrianglePrinter;
import com.tiempo.pdx.util.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PascalTriangleGeneratorAppTest {

    @Mock
    Console console;

    @Test
    public void should_print_a_triangle_pascal_given_an_integer_number() throws Exception {
        PascalTriangleCalculator pascalTriangleCalculator = new PascalTriangleCalculator();
        PascalTrianglePrinter pascalTrianglePrinter = new PascalTrianglePrinter(console);
        PascalTriangleGenerator generator = new PascalTriangleGenerator(pascalTriangleCalculator, pascalTrianglePrinter);

        generator.generate(7);
        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printLine("            1");
        inOrder.verify(console).printLine("           / \\");
        inOrder.verify(console).printLine("          1   1");
        inOrder.verify(console).printLine("         / \\ / \\");
        inOrder.verify(console).printLine("        1   2   1");
        inOrder.verify(console).printLine("       / \\ / \\ / \\");
        inOrder.verify(console).printLine("      1   3   3   1");
        inOrder.verify(console).printLine("     / \\ / \\ / \\ / \\");
        inOrder.verify(console).printLine("    1   4   6   4   1");
        inOrder.verify(console).printLine("   / \\ / \\ / \\ / \\ / \\");
        inOrder.verify(console).printLine("  1   5   10  10  5   1");
        inOrder.verify(console).printLine(" / \\ / \\ / \\ / \\ / \\ / \\");
        inOrder.verify(console).printLine("1   6   15  20  15  6   1");

    }
}
