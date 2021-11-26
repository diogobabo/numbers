package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSorterTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(3, 2, 6, 1, 4, 5, 7);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
    class stubListDeduplicator implements GenericListSorter {
        public List<Integer> sort(List<Integer> list) {
            List<Integer> sorted = new ArrayList<>();
            for (Integer number : list)
                sorted.add(number);

            for (int i = 0; i < sorted.size() - 1; i++)
                for (int j = i + 1; j < sorted.size() - 1; j++)
                    if (sorted.get(i) > sorted.get(j))
                        Collections.swap(sorted, i, j);

            return sorted;
        }
    }
    @Test
    public void sort_2() {
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1,2,2,4);

        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }
}
