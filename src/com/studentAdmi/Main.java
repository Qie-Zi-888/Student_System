package com.studentAdmi;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


public class Main {
    static MainWindow mainWindow ;
    static ImageIcon icon = new ImageIcon("src/com/studentAdmi/sigh.jpg");
    static Map<String, Student> students = new HashMap<String, Student>();
    private Main(){}
    public static void main(String[] args) {
        mainWindow = new MainWindow();
    }
}

class MainWindow extends JFrame {
    public static PrimePanel HomePanel;
    MainWindow(){
        super();
        this.setSize(800, 500);
        this.setIconImage(Main.icon.getImage());
        //清空布局器（即为自定义布局的模式）
        this.setLayout(null);
        HomePanel = new PrimePanel(0, 0, 800, 500);
        this.getContentPane().add(HomePanel);
        //不可改变大小
        this.setResizable(false);
        //设置窗口生成位置
        this.setLocation(900,400);
        //自动关闭窗口
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗口标题
        this.setTitle("ZSC学生信息管理系统");
        //设置窗口可视化
        this.setVisible(true);
    }
}


