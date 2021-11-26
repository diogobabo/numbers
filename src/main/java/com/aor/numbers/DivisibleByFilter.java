package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    int div;
    public DivisibleByFilter(int div) {
        this.div = div;
    }
    public boolean accept(int num) {
        return (num % div == 0);
    }
}
