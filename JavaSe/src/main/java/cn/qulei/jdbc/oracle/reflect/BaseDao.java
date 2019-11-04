package cn.qulei.jdbc.oracle.reflect;

import cn.qulei.jdbc.oracle.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用反射封装处理Oracle数据库JDBC
 *
 * @author QuLei
 */
public class BaseDao<T> {
    public List<T> getRows(String sql, Object[] params, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            pstm = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
            }
            resultSet = pstm.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object value = resultSet.getObject(i + 1);
                    String columnName = metaData.getColumnName(i + 1).toLowerCase();
                    Field field = clazz.getDeclaredField(columnName);
                    Method method = clazz.getMethod(getSetName(columnName), field.getType());
                    if (value instanceof Number) {
                        Number number = (Number) value;
                        String fname = field.getType().getName();
                        if ("int".equals(fname) || "java.lang.Integer".equals(fname)) {
                            method.invoke(t, number.intValue());
                        } else if ("byte".equals(fname) || "java.lang.Byte".equals(fname)) {
                            method.invoke(t, number.byteValue());
                        } else if ("short".equals(fname) || "java.lang.Short".equals(fname)) {
                            method.invoke(t, number.shortValue());
                        } else if ("long".equals(fname) || "java.lang.Long".equals(fname)) {
                            method.invoke(t, number.longValue());
                        } else if ("float".equals(fname) || "java.lang.Float".equals(fname)) {
                            method.invoke(t, number.floatValue());
                        } else if ("double".equals(fname) || "java.lang.Double".equals(fname)) {
                            method.invoke(t, number.doubleValue());
                        }
                    } else {
                        method.invoke(t, value);
                    }
                }
                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getSetName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
