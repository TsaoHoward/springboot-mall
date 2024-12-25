package com.example.springbootmybatis.dto;

import com.example.springbootmybatis.po.ProductExample;

import java.util.List;

public class PageResponseDto<T> {
    private int total;           // 總記錄數
    private int limit;           // 每頁的記錄數
    private int offset;          // 當前頁的偏移量
    private List<T> data;        // 分頁數據
    private boolean distinct;    // 是否 distinct 過濾
    private String orderBy;      // 排序字段
    private List<ProductExample.Criteria> criteria;     // 篩選條件，類似 ProductExample 中的 Criteria

    public PageResponseDto() {}

    public PageResponseDto(int total, int limit, int offset, List<T> data, boolean distinct, String orderBy, List<ProductExample.Criteria> criteria) {
        this.total = total;
        this.limit = limit;
        this.offset = offset;
        this.data = data;
        this.distinct = distinct;
        this.orderBy = orderBy;
        this.criteria = criteria;
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

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<ProductExample.Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<ProductExample.Criteria> criteria) {
        this.criteria = criteria;
    }
}