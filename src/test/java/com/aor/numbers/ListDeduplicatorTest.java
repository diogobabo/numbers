package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;
    private List<Integer> expected;
    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        GenericListSorter deduplicator = Mockito.mock(GenericListSorter.class);
        Mockito.when(deduplicator.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2,4,5));
        ListDeduplicator deduplicatore = new ListDeduplicator(deduplicator);
        List<Integer> distinct = deduplicatore.deduplicate(list);
        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        GenericListSorter deduplicator = Mockito.mock(GenericListSorter.class);
        Mockito.when(deduplicator.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2,4));
        ListDeduplicator deduplicatore = new ListDeduplicator(deduplicator);
        List<Integer> distinct = deduplicatore.deduplicate(list);
        Assertions.assertEquals(Arrays.asList(1, 2, 4), distinct);
    }
}
