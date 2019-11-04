package cn.qulei.jdbc.oracle;

import cn.qulei.jdbc.oracle.entity.Dept;
import cn.qulei.jdbc.oracle.reflect.BaseDao;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * 利用反射封装Oracle的Jdbc
 *
 * @author QuLei
 */
@Setter
public class JdbcOracle {
    public static void main(String[] args) throws Exception {
        BaseDao<Dept> baseDao = new BaseDao<>();
        List<Dept> list = baseDao.getRows("select * from dept where deptno = ?", new Object[]{20}, Dept.class);
        System.out.println(list);

    }


}
