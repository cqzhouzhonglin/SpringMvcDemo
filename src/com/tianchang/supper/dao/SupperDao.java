/**
 * Copyright (c) 天畅伟业科技有限公司 
 * 本著作物的著作权归天畅伟业有限公司所有。
 */
package com.tianchang.supper.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianchang.page.Page;
import com.tianchang.page.PageExt;

/**
 * <pre>
 * <b>.</b>
 * <b>Description:</b> 
 * 
 * <b>Author:</b> zhouhong
 * <b>Date:</b> 2016年6月22日 上午9:19:43
 * <b>Copyright:</b> Copyright &copy;2006-2026 天畅 Co., Ltd. All rights reserved.
 * <b>Changelog:</b>
 *   Ver   Date                  Author              Detail
 *   ----------------------------------------------------------------------
 *   1.0   2016-06-01 上午9:19:43   zhouhong       new file.
 * </pre>
 */
public class SupperDao extends SqlSessionDaoSupport {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        // TODO Auto-generated method stub
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 保存
     * @param key
     * @param object
     */
    public int save(String key, Object object) {

        return getSqlSession().insert(key, object);
    }

    /**
     * 修改
     * @param key
     * @param object
     */
    public int update(String key, Object object) {
        return getSqlSession().update(key, object);
    }

    /**
     * 删除
     * @param key
     * @param id
     */
    public int delete(String key, Serializable id) {
        return getSqlSession().delete(key, id);
    }

    /**
     * 删除
     * @param key
     * @param object
     */
    public int delete(String key, Object object) {
        return getSqlSession().delete(key, object);
    }

    /**
     * 查询 返回一个结果
     * @param <T>
     * @param key
     * @param params
     * @return
     */
    public <T> T get(String key, Object params) {
        return (T) getSqlSession().selectOne(key, params);
    }

    /**
     * 查询 返回一个结果
     * @param <T>
     * @param key
     * @param params
     * @return
     */
    public <T> T get(String key) {
        return (T) getSqlSession().selectOne(key);
    }

    /**
     * 查询 返回多个结果
     * @param <T>
     * @param key
     * @return
     */
    public <T> List<T> findList(String key) {
        return getSqlSession().selectList(key);
    }

    /**
     * 分页查询
     * @param <T>
     * @param key
     * @param offset
     * @param pageSize
     * @return
     */
    public <T> List<T> findList(String key, int offset, int pageSize) {
        return getSqlSession().selectList(key, new RowBounds(offset, pageSize));
    }

    /**
     * 分页查询
     * @param <T>
     * @param key
     * @param page
     * @return
     */
    public <T> List<T> findList(String key, Page page) {
        return getSqlSession().selectList(key, new RowBounds(page.getFirst(), page.getPageSize()));
    }

    /**
     * 分页查询
     * @param <T>
     * @param key
     * @param page
     * @return
     */
    public <T> List<T> findList(String key, PageExt pageExt) {
        return getSqlSession().selectList(key, new RowBounds(pageExt.getStart(), pageExt.getLimit()));
    }

    /**
     * 查询 可带参数 返回多个结果
     * @param <T>
     * @param key
     * @param params
     * @return
     */
    public <T> List<T> findList(String key, Object params) {
        return getSqlSession().selectList(key, params);
    }

    /**
     * 分页查询 可带参数
     * @param <T>
     * @param key
     * @param params 参数
     * @param pageOffset 开始记录数
     * @param pageSize 每页记录数
     * @return
     */
    public <T> List<T> findList(String key, Object params, int pageOffset, int pageSize) {
        return getSqlSession().selectList(key, params, new RowBounds(pageOffset, pageSize));
    }

    /**
     * 分页查询 可带参数
     * @param <T>
     * @param key
     * @param params
     * @param page
     * @return
     */
    public <T> List<T> findList(String key, Object params, Page page) {
        return getSqlSession().selectList(key, params, new RowBounds(page.getFirst(), page.getPageSize()));
    }

    /**
     * 分页查询 可带参数
     * @param <T>
     * @param key
     * @param params
     * @param page
     * @return
     */
    public <T> List<T> findList(String key, Object params, PageExt pageExt) {
        return getSqlSession().selectList(key, params, new RowBounds(pageExt.getStart(), pageExt.getLimit()));
    }

}
