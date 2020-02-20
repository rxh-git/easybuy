package com.easybuy.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtil {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/easybuy?useUnicode=true&amp&characterEncoding=utf-8";
    private static   DruidDataSource druidDataSource=null;

    static{
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * 配置阿里巴巴数据源
     */
    //创建druid数据源对象
    public  static void init() {
        //实例化druidDataSource
        druidDataSource=new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxActive(100);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxWait(1000);
        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    /**
     * 连接数据源的方法
     * @return 连接对象
     */
    public static Connection getConn(){
        Connection conn=null;
        //加载mysql驱动（开启服务）
        try {
            Class.forName(driver);
            //如果数据库处于没有连接状态，则创建一个连接
            if (conn == null) {
                conn = druidDataSource.getConnection(username,password);
                System.out.println("数据库连接成功。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public   static  void closeConn(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
