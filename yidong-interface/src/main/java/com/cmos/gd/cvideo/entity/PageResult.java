package com.cmos.gd.cvideo.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 返回分页的结果集封装类
 * @Author weipeng
 * @Date 2019/8/2 12:23
 */
public class PageResult<T> implements Serializable {

    private Long total; //总记录数
    private List<T> rows; //分页的结果集

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
