package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveFilterTest {

    @Test
    public void positiveFilter() {
        Integer num = 2;

        PositiveFilter positiveFilter = new PositiveFilter();

        Assertions.assertTrue(positiveFilter.accept(num));
    }

    @Test
    public void positiveFilter_02() {
        Integer num = 0;

        PositiveFilter positiveFilter = new PositiveFilter();

        Assertions.assertFalse(positiveFilter.accept(num));
    }

}