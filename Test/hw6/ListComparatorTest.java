package hw6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListComparatorTest {
    @Test
    public void testFirstListHasGreaterAverage() {
        assertEquals("Первый список имеет большее среднее значение",
                ListComparator.compare(Arrays.asList(1, 2, 3, 4, 5),
                        Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testSecondListHasGreaterAverage() {
        assertEquals("Второй список имеет большее среднее значение",
                ListComparator.compare(Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void testAveragesAreEqual() {
        assertEquals("Средние значения равны",
                ListComparator.compare(Arrays.asList(1, 2, 3, 4, 5),
                        Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void testEmptyLists() {
        assertEquals("Средние значения равны",
                ListComparator.compare(Collections.emptyList(),
                        Collections.emptyList()));
    }
}