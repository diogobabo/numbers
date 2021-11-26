package com.aor.numbers;

public class PositiveFilter implements GenericListFilter{
    public boolean accept(int num) {
        return num > 0;
    }

}
