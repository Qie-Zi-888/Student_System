package com.studentAdmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//通过姓名和学号来删除学生信息
public class DelWin extends JFrame {
    private MyLabel nameLabel;
    private MyTextFiled nameText;

    private MyLabel codeLabel;
    private MyTextFiled codeText;

    //确认按钮
    private MyButton OKButton;
    //清空按钮
    private MyButton clearButton;

    public DelWin(){
        super();
        this.setIconImage(Main.icon.getImage());
        this.setSize(500, 300);
        //清空布局器
        this.setLayout(null);
        //不可改变大小
        this.setResizable(false);
        //设置窗口生成位置
        this.setLocation(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("删除学生信息");
        //
        this.getContentPane().setBackground(Color.pink);
        this.setVisible(true);

        this.addPart();
        this.addListen();
    }

    //添加组件
    private void addPart(){
        nameLabel = new MyLabel(80, 15, 80, 40, "姓名");
        this.add(nameLabel);
        nameText = new MyTextFiled(140, 20, 200, 30);
        this.add(nameText);

        codeLabel = new MyLabel(80, 65, 80, 40, "学号");
        this.add(codeLabel);
        codeText = new MyTextFiled(140, 70, 200, 30);
        this.add(codeText);

        OKButton =new MyButton(40, 200, 80, 40, "确认");
        this.add(OKButton);
        clearButton =new MyButton(360, 200, 80, 40, "清空");
        this.add(clearButton);
    }

    //添加监听
    private void addListen(){
        OKButton.addActionListener(new OKListener());
        clearButton.addActionListener(new ClearListener());
    }

    //监听确定按钮
    private class OKListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //初始的students集合大小
            int startNum = Main.students.size();
            //判断是否存在以这个学号为键的映射关系和名字是否一致
            if((Main.students.containsKey(codeText.getText())) && (Main.students.get(codeText.getText()).getName().equals(nameText.getText()))){
                Main.students.remove(codeText.getText());
                //判断该键的映射关系还在不在里面和集合大小是否变小了
                if(((Main.students.size()) == (startNum -1)) && (!Main.students.containsKey(codeText.getText()))){
                    JOptionPane.showMessageDialog(null, "删除成功！", "提示",JOptionPane.WARNING_MESSAGE); //弹出提示框
                    //调用更新学生信息的方法
                    PrimePanel.refreshFile();
                }
            }else {
                JOptionPane.showMessageDialog(null, "没有该学号信息或名字与学号不匹配", "提示",JOptionPane.WARNING_MESSAGE); //弹出提示框
            }
        }
    }

    //监听清空按钮
    private class ClearListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            nameText.setText("");
            codeText.setText("");
        }
    }
}
