package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    Integer div;
    public DivisibleByFilter(Integer div) {
        this.div = div;
    }
    public boolean accept(Integer num) {
        return (num % div == 0);
    }
}
