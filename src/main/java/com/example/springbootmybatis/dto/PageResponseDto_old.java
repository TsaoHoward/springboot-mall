package com.example.springbootmybatis.dto;

import java.util.List;

public class PageResponseDto_old<T> {
    private int total;
    private int limit;
    private int offset;
    private List<T> data;

    public PageResponseDto_old() {}

    public PageResponseDto_old(int total, int limit, int offset, List<T> data) {
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
