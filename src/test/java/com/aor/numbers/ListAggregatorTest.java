package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    private List<Integer> list2;
    private List<Integer> list3;
    @BeforeEach
    public void getList() {
        list = Arrays.asList(1,2,4,2,5);
        list2 = Arrays.asList(-1,-4,-5);
        list3 = Arrays.asList(1,2,4,2);
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator oi = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(oi.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1,2,4,5));
        int distinct = aggregator.distinct(list, oi);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list2);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void bug_distinct() {

        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator oi = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(oi.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(list3, oi);

        Assertions.assertEquals(3, distinct);
    }

    class stubListDeduplicator implements GenericListDeduplicator {

        /**
         * Removes duplicate numbers from a list.
         *
         * @return A list having the same numbers as the original
         * but withou duplicates. The order of the numbers might
         * change.
         */
        public List<Integer> deduplicate(List<Integer> list) {
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                boolean flag = true;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    list2.add(list.get(i));
                }
            }
            return list2;
        }
    }

    @Test
    public void bug_distinct_new() {

        ListAggregator aggregator = new ListAggregator();
        GenericListDeduplicator oi = Mockito.mock(GenericListDeduplicator.class);
        Mockito.when(oi.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        int distinct = aggregator.distinct(list3, oi);

        Assertions.assertEquals(3, distinct);
    }
}
