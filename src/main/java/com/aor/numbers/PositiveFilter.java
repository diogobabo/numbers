package com.aor.numbers;

public class PositiveFilter implements GenericListFilter{
    public boolean accept(Integer num) {
        return num > 0;
    }

}
