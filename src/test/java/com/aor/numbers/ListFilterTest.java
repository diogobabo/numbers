package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListFilterTest {
    @Test
    public void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, -15, 0, -2);
        PositiveFilter pos = new PositiveFilter();
        DivisibleByFilter div = new DivisibleByFilter(5);

        ListFilterer tdiv= new ListFilterer(div);
        ListFilterer tpos = new ListFilterer(pos);


        Assertions.assertEquals(Arrays.asList(1, 2, 3), tpos.filter(list));
        Assertions.assertEquals(Arrays.asList(-15, 0),tdiv.filter(list));
    }
}