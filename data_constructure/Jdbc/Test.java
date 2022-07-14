package Jdbc;
/**
 * #Description 
 * @param 
 * @return 
 * @author jiongyang
 * #Date 2021/12/15
 */
import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException {
        String dbms = "mysql";
        //1、创建连接对象
        Connection conn = null;
        /*Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "123456");*/

        conn = DriverManager.getConnection("jdbc:" + dbms + "://localhost:3306/myemployees", "root", "123456");
        System.out.println("Connected to database");

        //2、创建语句
        try (Statement update = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet uprs = update.executeQuery("SELECT * FROM department_id");

            //3、执行查询与更新语句
            //插入
            uprs.moveToInsertRow();
            uprs.updateInt("hell", 300);
            uprs.insertRow();
            uprs.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //更新
        try (Statement stat2 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
            ResultSet update = stat2.executeQuery("select * from hello");
            while (update.next()) {
                int hell = update.getInt("hell");
                update.updateInt("hell", hell * 2);
                update.updateRow();
            }
        }
        //查询，通过列名或者索引（从1开始）
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery("select * from hello");
        System.out.println(rs);
        while (rs.next()) {
            System.out.println(rs.getInt("hell"));
        }
        System.out.println("----------------");
        try (Statement stat2 = conn.createStatement()) {
            ResultSet rs2 = stat2.executeQuery("select * from hello");
            while (rs2.next()) {
                System.out.println(rs2.getInt(1));
            }

        }

        //4、关闭数据库
        conn.close();


    }
}


