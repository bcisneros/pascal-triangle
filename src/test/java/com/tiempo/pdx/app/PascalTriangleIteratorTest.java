package com.tiempo.pdx.app;

import org.junit.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class PascalTriangleIteratorTest {

    @Test
    public void should_return_true_when_triangle_has_next() throws Exception {
        PascalTriangleIterator iterator = new PascalTriangleIterator(new PascalTriangle(1));
        assertThat(iterator.hasNext(), is(true));
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void should_obtain_next_list_of_integers_from_pascal_triangle() throws Exception {
        PascalTriangle triangle = new PascalTriangle(3);

        triangle.addLevel(singletonList(1));
        triangle.addLevel(asList(1, 1));
        triangle.addLevel(asList(1, 2, 1));
        PascalTriangleIterator iterator = new PascalTriangleIterator(triangle);

        assertThat(iterator.next(), is(singletonList(1)));
        assertThat(iterator.next(), is(asList(1, 1)));
        assertThat(iterator.next(), is(asList(1, 2, 1)));

        assertNull(iterator.next());

    }
}