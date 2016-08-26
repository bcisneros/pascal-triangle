package com.tiempo.pdx.feature;


import com.tiempo.pdx.app.PascalTriangleCalculator;
import com.tiempo.pdx.app.PascalTriangleGenerator;
import com.tiempo.pdx.app.PascalTriangleGeneratorApp;
import com.tiempo.pdx.app.PascalTrianglePrinter;
import com.tiempo.pdx.util.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class PascalTriangleGeneratorAppTest {

    @Mock
    Console console;
    PascalTriangleCalculator pascalTriangleCalculator;
    PascalTrianglePrinter pascalTrianglePrinter;
    PascalTriangleGenerator generator;

    PascalTriangleGeneratorApp app;

    @Before
    public void setUp() throws Exception {
        pascalTriangleCalculator = new PascalTriangleCalculator();
        pascalTrianglePrinter = new PascalTrianglePrinter(console);
        generator = new PascalTriangleGenerator(pascalTriangleCalculator, pascalTrianglePrinter);
        app = new PascalTriangleGeneratorApp(generator, console);
    }

    @Test
    public void should_print_a_triangle_pascal_given_an_integer_number() throws Exception {

        app.main(new String[]{"7"});

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
        verifyNoMoreInteractions(console);
    }

    @Test
    public void should_inform_when_invalid_parameter_is_passed() throws Exception {

        app.main(new String[]{"not a number"});

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printLine("The input parameter is not an integer number, please enter a valid value.");

    }
}
