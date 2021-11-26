package com.aor.numbers;
import com.aor.numbers.DivisibleByFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivisibleByFilterTest {

    @Test
    public void divisibleByFilter() {
        Integer num = 5;

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);

        Assertions.assertTrue(divisibleByFilter.accept(num));
    }

    @Test
    public void divisibleByFilter_02() {
        Integer num = 3;

        DivisibleByFilter divisibleByFilter = new DivisibleByFilter(5);

        Assertions.assertFalse(divisibleByFilter.accept(num));
    }
}