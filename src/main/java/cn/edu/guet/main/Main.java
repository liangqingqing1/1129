package cn.edu.guet.main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @Author liangjinmei
 * @Date: 2022/12/01/ 14:50
 * @Description
 */
public class Main {
    public static void main(String[] args) {
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
