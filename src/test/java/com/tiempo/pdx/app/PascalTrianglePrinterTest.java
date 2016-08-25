package com.tiempo.pdx.app;

import com.tiempo.pdx.util.Console;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.mockito.Mockito.inOrder;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(JUnitParamsRunner.class)
public class PascalTrianglePrinterTest {

    private static final List<Integer> FIRST_LEVEL = singletonList(1);
    private static final List<Integer> SECOND_LEVEL = asList(1, 1);
    private static final List<Integer> THIRD_LEVEL = asList(1, 2, 1);
    private static final List<Integer> FOURTH_LEVEL = asList(1, 3, 3, 1);
    private static final List<Integer> FIFTH_LEVEL = asList(1, 4, 6, 4, 1);

    private List<List<Integer>> levels = asList(FIRST_LEVEL, SECOND_LEVEL, THIRD_LEVEL, FOURTH_LEVEL, FIFTH_LEVEL);
    @Mock
    private Console console;

    private PascalTrianglePrinter printer;
    private PascalTriangle pascalTriangle;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        printer = new PascalTrianglePrinter(console);
        pascalTriangle = new PascalTriangle();
    }

    @Test
    @Parameters(method = "testData")
    public void should_print_a_pascal_triangle_5(Collection<List<Integer>> triangleData, List<String> lines) throws Exception {

        for (List<Integer> dataLine : triangleData) {
            pascalTriangle.addLevel(dataLine);
        }

        printer.print(pascalTriangle);

        InOrder inOrder = inOrder(console);
        for (String line : lines) {
            inOrder.verify(console).printLine(line);
        }
    }

    @SuppressWarnings("unused")
    private Object[] testData() {
        return new Object[]{
                new Object[]{
                        dataForLevel(5),
                        asList(
                                "        1",
                                "       / \\",
                                "      1   1",
                                "     / \\ / \\",
                                "    1   2   1",
                                "   / \\ / \\ / \\",
                                "  1   3   3   1",
                                " / \\ / \\ / \\ / \\",
                                "1   4   6   4   1"

                        )
                },
                new Object[]{
                        dataForLevel(4),
                        asList(
                                "      1",
                                "     / \\",
                                "    1   1",
                                "   / \\ / \\",
                                "  1   2   1",
                                " / \\ / \\ / \\",
                                "1   3   3   1"
                        )
                },

                new Object[]{
                        dataForLevel(3),
                        asList(
                                "    1",
                                "   / \\",
                                "  1   1",
                                " / \\ / \\",
                                "1   2   1"
                        )
                },
                new Object[]{
                        dataForLevel(2),
                        asList(
                                "  1",
                                " / \\",
                                "1   1"
                        )
                },
                new Object[]{
                        dataForLevel(1),
                        singletonList(
                                "1"
                        )
                }
        };
    }

    private Collection<List<Integer>> dataForLevel(int level) {
        Collection<List<Integer>> triangleDataCollection = new ArrayList<List<Integer>>();
        for (int i = 0; i < level; i++) {
            triangleDataCollection.add(levels.get(i));
        }
        return triangleDataCollection;
    }
}