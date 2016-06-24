/**
 * Copyright (c) 2005-2009 springside.org.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * 
 * $Id: Page.java 763 2009-12-27 18:36:21Z calvinxiu $
 */
package com.tianchang.page;

import java.util.Collections;
import java.util.List;

/**
 * 与具体ORM实现无关的分页参数及查询结果封装.
 * 注意所有序号从1开始.
 * 
 * @param <T> Page中记录的类型.
 * 
 * @author calvin
 */
public class Page<T> {
    // -- 分页参数 --//
    protected int pageNo = 1; // 当前页号
    protected int pageSize = 10; // 页面记录数

    // -- 返回结果 --//
    protected List<T> result = Collections.emptyList();
    protected long totalCount = 0; // 总记录数
    protected int totalPages = 0; // 总页数

    private String allPageFilter = "";// 所有查询条件,包括分页条件及页面查询条件
    private String queryFilter = "";// 页面查询条件

    // -- 访问查询参数函数 --//
    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 获得每页的记录数量,默认为1.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为1.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;

        if (pageSize < 1) {
            this.pageSize = 1;
        }
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNo - 1) * pageSize);
    }

    // -- 访问查询结果函数 --//

    /**
     * 取得页内的记录列表.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setResult(final List<T> result) {
        this.result = result;
    }

    /**
     * 取得总记录数, 默认值为0
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总记录数.
     */
    public void setTotalCount(final long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 根据pageSize与totalCount计算总页数, 默认值为-1.
     */
    public int getTotalPages() {
        if (totalCount < 0) {
            return -1;
        }
        long count = (totalCount - 1) / pageSize + 1;
        totalPages = new Integer(new Long(count).toString()).intValue();
        return totalPages;
    }

    /**
     * 是否还有下一页.
     */
    public boolean isHasNext() {
        return (pageNo + 1 <= getTotalPages());
    }

    /**
     * 取得下页的页号, 序号从1开始.
     * 当前页为尾页时仍返回尾页序号.
     */
    public int getNextPage() {
        if (isHasNext()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }

    /**
     * 是否还有上一页.
     */
    public boolean isHasPre() {
        return (pageNo - 1 >= 1);
    }

    /**
     * 取得上页的页号, 序号从1开始.
     * 当前页为首页时返回首页序号.
     */
    public int getPrePage() {
        if (isHasPre()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    public String getQueryFilter() {
        return queryFilter;
    }

    public void setQueryFilter(String queryFilter) {
        this.queryFilter = queryFilter;
    }

    public String getAllPageFilter() {
        return allPageFilter;
    }

    public void setAllPageFilter(String allPageFilter) {
        this.allPageFilter = allPageFilter;
    }

}
