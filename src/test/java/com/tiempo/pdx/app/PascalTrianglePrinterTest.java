package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PascalTrianglePrinterTest {
    @Mock
    private Console console;

    @Test
    public void should_print_a_pascal_triangle() throws Exception {
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        printer.print(new PascalTriangle(1));
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("1");
    }

    @Test
    public void should_print_a_pascal_triangle_2() throws Exception {
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        PascalTriangle pascalTriangle = new PascalTriangle(2);
        pascalTriangle.addLevel(singletonList(1));
        pascalTriangle.addLevel(asList(1, 1));
        printer.print(pascalTriangle);
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("  1");
        inOrder.verify(console).printLine(" / \\");
        inOrder.verify(console).printLine("1   1");
    }

    @Test
    public void should_print_a_pascal_triangle_3() throws Exception {
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        PascalTriangle pascalTriangle = new PascalTriangle(3);
        pascalTriangle.addLevel(singletonList(1));
        pascalTriangle.addLevel(asList(1, 1));
        pascalTriangle.addLevel(asList(1, 2, 1));
        printer.print(pascalTriangle);
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("    1");
        inOrder.verify(console).printLine("   / \\");
        inOrder.verify(console).printLine("  1   1");
        inOrder.verify(console).printLine(" / \\ / \\");
        inOrder.verify(console).printLine("1   2   1");
    }

    @Test
    public void should_print_a_pascal_triangle_4() throws Exception {
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        PascalTriangle pascalTriangle = new PascalTriangle(4);
        pascalTriangle.addLevel(singletonList(1));
        pascalTriangle.addLevel(asList(1, 1));
        pascalTriangle.addLevel(asList(1, 2, 1));
        pascalTriangle.addLevel(asList(1, 3, 3, 1));
        printer.print(pascalTriangle);
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("      1");
        inOrder.verify(console).printLine("     / \\");
        inOrder.verify(console).printLine("    1   1");
        inOrder.verify(console).printLine("   / \\ / \\");
        inOrder.verify(console).printLine("  1   2   1");
        inOrder.verify(console).printLine(" / \\ / \\ / \\");
        inOrder.verify(console).printLine("1   3   3   1");
    }

    @Test
    public void should_print_a_pascal_triangle_5() throws Exception {
        PascalTrianglePrinter printer = new PascalTrianglePrinter(console);
        PascalTriangle pascalTriangle = new PascalTriangle(5);
        pascalTriangle.addLevel(singletonList(1));
        pascalTriangle.addLevel(asList(1, 1));
        pascalTriangle.addLevel(asList(1, 2, 1));
        pascalTriangle.addLevel(asList(1, 3, 3, 1));
        pascalTriangle.addLevel(asList(1, 4, 6, 4, 1));
        printer.print(pascalTriangle);
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("        1");
        inOrder.verify(console).printLine("       / \\");
        inOrder.verify(console).printLine("      1   1");
        inOrder.verify(console).printLine("     / \\ / \\");
        inOrder.verify(console).printLine("    1   2   1");
        inOrder.verify(console).printLine("   / \\ / \\ / \\");
        inOrder.verify(console).printLine("  1   3   3   1");
        inOrder.verify(console).printLine(" / \\ / \\ / \\ / \\");
        inOrder.verify(console).printLine("1   4   6   4   1");
    }
}