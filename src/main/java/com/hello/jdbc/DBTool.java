package com.hello.jdbc;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DBTool {

    private static final Logger logger = LoggerFactory.getLogger(DBTool.class);

    /**
     * 请注意:不建议在没有服务器身份验证的情况下建立SSL连接。根据MySQL 5.5.45+、5.6.26+和5.7.6+的要求，如果不设置显式选项，
     * 则必须建立默认的SSL连接。您需要通过设置useSSL=false显式地禁用SSL，或者设置useSSL=true并为服务器证书验证提供信任存储。
     * serverTimezone=GMT 加上这个是因为数据库与系统时区有差异
     */
    private static String url =
        "jdbc:mysql://127.0.0.1:3306/study?useSSL=false&useUnicode=true" + "&characterEncoding=utf8&serverTimezone=UTC";

    private static String username = "root";

    private static String password = "root";

    /**
     * 获取数据库连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭数据库连接
     *
     * @param connection
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        if (null != connection) {
            connection.close();
        }
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        return connection.prepareStatement(sql);
    }

    /**
     * 执行查询操作
     *
     * @param sql
     * @param list
     * @throws SQLException
     */
    public static void executeQuery(String sql, List<Integer> list) throws SQLException {
        PreparedStatement preparedStatement = getPreparedStatement(sql);
        preparedStatement.setInt(1, list.get(0));
        preparedStatement.setInt(2, list.get(1));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
        }
    }

    /**
     * 执行DML操作
     *
     * @param sql
     * @param list
     * @throws SQLException
     */
    public static void executeUpdate(String sql, List<String> list) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, list.get(0));
            int effectiveCount = preparedStatement.executeUpdate();
            System.out.println("effectiveCount: " + effectiveCount);
            int i = 10/0;
        }catch(Exception e){
            System.out.println("发生回滚");
            connection.rollback();
            return;
        }
        System.out.println("发生提交");
        connection.commit();
    }

    public static void main(String[] args) throws SQLException {
        String sql = "select * from study.team limit ?,?";
        List<Integer> list = Arrays.asList(0, 1);
        executeQuery(sql, list);
        System.out.println("-------------------------");
        sql = "insert into study.user(name)value(?)";
        List<String> updateList = Arrays.asList("hello");
        executeUpdate(sql, updateList);
    }

}
