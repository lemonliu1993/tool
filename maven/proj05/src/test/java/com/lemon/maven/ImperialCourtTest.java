package com.lemon.maven;

import com.lemon.imperial.court.dao.BaseDao;
import com.lemon.imperial.court.entity.Emp;
import com.lemon.imperial.court.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * Created by lemoon on 2024/1/7 22:00
 */
public class ImperialCourtTest {

    private BaseDao<Emp> baseDao = new BaseDao<>();


    @Test
    public void testGetConnection() {

        Connection connection = JDBCUtils.getConnection();
        System.out.println("connection = " + connection);

        JDBCUtils.releaseConnection(connection);

    }

    @Test
    public void testGetSingleBean() {

        String sql = "select emp_id empId,emp_name empName,emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp where emp_id=?";

        Emp emp = baseDao.getSingleBean(sql, Emp.class, 1);

        System.out.println("emp = " + emp);

    }

    @Test
    public void testGetBeanList() {

        String sql = "select emp_id empId,emp_name empName,emp_position empPosition,login_account loginAccount,login_password loginPassword from t_emp";

        List<Emp> empList = baseDao.getBeanList(sql, Emp.class);

        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }

    }

    @Test
    public void testUpdate() {

        String sql = "update t_emp set emp_position=? where emp_id=?";

        String empPosition = "minister";
        String empId = "3";

//        int affectedRowNumber = baseDao.update(sql, empPosition, empId);

//        System.out.println("affectedRowNumber = " + affectedRowNumber);

    }
}
