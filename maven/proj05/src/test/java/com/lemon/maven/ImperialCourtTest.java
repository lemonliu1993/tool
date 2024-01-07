package com.lemon.maven;

import com.lemon.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by lemoon on 2024/1/7 22:00
 */
public class ImperialCourtTest {
    @Test
    public void testGetConnection() {

        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);

    }
}
