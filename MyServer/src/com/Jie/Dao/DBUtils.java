package com.Jie.Dao;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * Created by Jie on 2016/01/15.
 */
public class DBUtils {
    //���ݿ����ӵ�ַ
    public static String URL;
    //�û���
    public static String USERNAME;
    //����
    public static String PASSWORD;
    //mysql��������
    public static String DRIVER;
    private DBUtils(){
    	
    }
    //ʹ�þ�̬�������������
    static{
        URL = "jdbc:mysql://localhost:3306/shop";
        USERNAME = "root";
        PASSWORD = "root";
        DRIVER = "com.mysql.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //����һ����ȡ���ݿ����ӵķ���
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("��ȡ����ʧ��");
        }
        finally {
            return conn;
        }
    }
    /**
     * �ر����ݿ�����
     */
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
