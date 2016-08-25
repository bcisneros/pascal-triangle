package com.tiempo.pdx.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PascalTriangleGeneratorTest {

    @Mock
    private PascalTriangleCalculator pascalTriangleCalculator;

    @Mock
    private PascalTrianglePrinter pascalTrianglePrinter;

    @Test
    public void should_calculate_and_format_expected_pascal_triangle() throws Exception {
        PascalTriangleGenerator generator = new PascalTriangleGenerator(pascalTriangleCalculator, pascalTrianglePrinter);
        PascalTriangle pascalTriangle = new PascalTriangle(7);
        when(pascalTriangleCalculator.calculate(7)).thenReturn(pascalTriangle);

        generator.generate(7);
        inOrder(pascalTriangleCalculator).verify(pascalTriangleCalculator).calculate(7);
        inOrder(pascalTrianglePrinter).verify(pascalTrianglePrinter).print(pascalTriangle);
    }
}