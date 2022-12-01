package cn.edu.guet.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;

/**
 * @Author liangjinmei
 * @Date: 2022/12/01/ 14:50
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM users";// 用Java去执行这条SQL语句来获取数据
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;// 表示数据库的连接对象
        PreparedStatement pstmt = null;// 表示SQL语句的对象
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);// 把pstmt和sql语句做一个关联，pstmt就代表上面的sql语句

            rs = pstmt.executeQuery();

            while (rs.next()){

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        JFrame jFrame = new JFrame("主界面");
        jFrame.setSize(1200,700);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String head[] = {"id","用户名","密码"};
        Object[][] data = new Object[5][3];

        JTable jTable = new JTable(data,head);
        //滚动面板
        JScrollPane jscrollPane = new JScrollPane();
        jscrollPane.setBounds(20,20,1100,600);
        jscrollPane.setViewportView(jTable);//把表格添加到面板中
        jTable.setRowHeight(35);//行高

        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        jTable.setDefaultRenderer(Object.class,r);//每行内容中显示

        JPanel jPanel = (JPanel) jFrame.getContentPane();
        jPanel.add(jscrollPane);
    }
}
