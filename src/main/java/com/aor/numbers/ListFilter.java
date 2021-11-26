package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    private GenericListFilter filter;
    public ListFilter(GenericListFilter filter) {
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> ffil = new ArrayList<>();
        for (int i : list)
            if (filter.accept(i)) {
                ffil.add(i);
            }
        return ffil;
    }
}
