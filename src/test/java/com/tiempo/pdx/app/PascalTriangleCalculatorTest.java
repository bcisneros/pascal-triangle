package com.tiempo.pdx.app;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PascalTriangleCalculatorTest {

    private final PascalTriangleCalculator pascalCalculator = new PascalTriangleCalculator();

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(1);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_2() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(2);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_3() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(3);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 2, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_4() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(4);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 2, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 3, 3, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_5() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(5);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 2, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 3, 3, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 4, 6, 4, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_6() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(6);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 2, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 3, 3, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 4, 6, 4, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 5, 10, 10, 5, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }

    @Test
    public void should_calculate_pascal_triangle_given_a_level_number_7() throws Exception {
        PascalTriangle triangle = pascalCalculator.calculate(7);
        Iterator<List<Integer>> triangleIterator = triangle.iterator();
        assertThat(triangleIterator.hasNext(), is(true));
        assertThat(triangleIterator.next(), is(singletonList(1)));
        assertThat(triangleIterator.next(), is(asList(1, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 2, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 3, 3, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 4, 6, 4, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 5, 10, 10, 5, 1)));
        assertThat(triangleIterator.next(), is(asList(1, 6, 15, 20, 15, 6, 1)));
        assertThat(triangleIterator.hasNext(), is(false));
    }
}