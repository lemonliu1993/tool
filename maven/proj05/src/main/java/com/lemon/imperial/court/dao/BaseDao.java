package com.lemon.imperial.court.dao;

import com.lemon.imperial.court.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lemoon on 2024/1/8 23:53
 */
public class BaseDao<T> {
    //DBUtils 工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    /**
     * 查询单个对象
     *
     * @param sql
     * @param enntityClass
     * @param parameters   传给 SQL 语句的参数
     * @return 查询到的实体类对象
     */
    public T getSingleBean(String sql, Class<T> enntityClass, Object... parameters) {
        try {
            Connection connection = JDBCUtils.getConnection();

            return runner.query(connection, sql, new BeanHandler<>(enntityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<T> getBeanList(String sql, Class<T> entityClass, Object ... parameters) {
        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            return runner.query(connection, sql, new BeanListHandler<>(entityClass), parameters);

        } catch (SQLException e) {
            e.printStackTrace();

            // 如果真的抛出异常，则将编译时异常封装为运行时异常抛出
            new RuntimeException(e);
        }

        return null;
    }

}
