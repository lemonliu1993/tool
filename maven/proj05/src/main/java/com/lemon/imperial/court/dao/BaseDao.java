package com.lemon.imperial.court.dao;

import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by lemoon on 2024/1/8 23:53
 */
public class BaseDao<T> {
    //DBUtils 工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    /**
     * 查询单个对象
     * @param sql
     * @param enntityClass
     * @return
     */
    public T getSingleBean(String sql, Class<T> enntityClass,Object ...){}
}
