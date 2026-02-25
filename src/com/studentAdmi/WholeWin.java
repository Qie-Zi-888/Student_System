package com.studentAdmi;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.Map;

public class WholeWin extends JFrame {
    private DefaultTableModel model  = null;
    private JTable table = null ;
    WholeWin(){
        super("学生信息表");
        table = new JTable(this.writingTable(Main.students));
        table.setEnabled(false);
        table.setFont(new Font("宋体", Font.LAYOUT_NO_LIMIT_CONTEXT, 20));

        //表格首行
        JTableHeader tableHeader = table.getTableHeader();
        //行高
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 30));
        //设置表格头行字体
        tableHeader.setFont(new Font("楷体", Font.BOLD, 22));
        tableHeader.setEnabled(false);
        tableHeader.setBackground(Color.orange);

        //行高
        table.setRowHeight(26);
        //设置table内容居中
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        table.setBackground(Color.yellow);
        this.setSize(800, 600);

        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 0, this.getWidth(), this.getHeight());
        jScrollPane.setOpaque(false);

        //设置窗口背景
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        jScrollPane.getViewport().setOpaque(false);
        panel.add(jScrollPane);

        //不可改变大小
        this.setResizable(false);
        this.setIconImage(Main.icon.getImage());
        this.getContentPane().add(panel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    DefaultTableModel writingTable(Map<String , Student> students){
        String[][] datas = new String[students.size()][6];
        String[] titles = { "姓名", "性别", "籍贯", "学号", "系别", "班别" };
        int index = 0;
        //把学生信息加进学生信息表中
        for (String key : students.keySet()){
            datas[index] = new String[]{students.get(key).getName(), students.get(key).getSex(), students.get(key).getPlace(), 
            		students.get(key).getCode(), students.get(key).getDept(), students.get(key).getBan()};
            index++;
        }
        return model = new DefaultTableModel(datas, titles);
    }
}
