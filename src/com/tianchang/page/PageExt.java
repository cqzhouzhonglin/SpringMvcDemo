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
public class PageExt<T> {

    protected int limit; // 页面记录数
    protected List<T> result = Collections.emptyList(); // 查询结果
    protected long totalCount = 0; // 总记录数
    private int start = 0; // 第一条记录在总结果集中的位置

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    /**
     * 将分页对象转换成json
     * @return
     * @throws Exception
     */
    public String toJson() throws Exception {
        return "";
    }

}
