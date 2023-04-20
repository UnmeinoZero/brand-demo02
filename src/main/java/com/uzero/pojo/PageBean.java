package com.uzero.pojo;

import java.util.List;

/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-21  19:26:59
 * 分页查询的javaBean
 */
public class PageBean<T> {

    //总记录数
    private int totalCount;

    //当前页数据,自定义泛型，使类型匹配
    private List<T> rows;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
