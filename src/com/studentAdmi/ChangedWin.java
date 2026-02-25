package com.studentAdmi;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ChangedWin extends JFrame{
	private MyLabel nameLabel;
    private MyTextFiled nameText;

    private MyLabel sexLabel;
    private MyTextFiled sexText;

    private MyLabel placeLabel;
    private MyTextFiled placeText;

    private MyLabel codeLabel;
    private MyTextFiled codeText;

    private MyLabel deptLabel;
    private MyTextFiled deptText;

    private MyLabel banLabel;
    private MyTextFiled banText;

    //确认按钮
    private MyButton OKButton;

    public ChangedWin(String name, String sex, String place, String code, String dept, String ban) {
		super();
		this.setIconImage(Main.icon.getImage());
        this.setSize(500,600);
        //清空布局器
        this.setLayout(null);
        //不可改变大小
        this.setResizable(false);
        this.setVisible(true);
        //设置窗口生成位置
        this.setLocation(450,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("修改学生信息");
        //设置窗口背景颜色
        this.getContentPane().setBackground(Color.pink);

        this.addPart();
        
        this.nameText.setText(name);
        this.sexText.setText(sex);
        this.placeText.setText(place);
        this.codeText.setText(code);
        this.deptText.setText(dept);
        this.banText.setText(ban);
        
        OKButton = new MyButton(200, 400, 80, 40, "确认");
        this.add(OKButton);

        //实现事件监听
        OKButton.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent e) {
        		 if (nameText.getText().length() == 0 || nameText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "名字未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (sexText.getText().length() == 0 || sexText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "性别未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (placeText.getText().length() == 0 || placeText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "籍贯未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (codeText.getText().length() == 0 || codeText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "学号未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (deptText.getText().length() == 0 || deptText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "系别未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (banText.getText().length() == 0 || banText.getText().contains(" ")) {
                     JOptionPane.showMessageDialog(null, "班级未输入或空格非法", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
                 } else if (sexText.getText().equals("男") || sexText.getText().equals("女")) {
                	Main.students.get(codeText.getText()).setName(nameText.getText());
             		Main.students.get(codeText.getText()).setSex(sexText.getText());
             		Main.students.get(codeText.getText()).setPlace(placeText.getText());
             		Main.students.get(codeText.getText()).setCode(codeText.getText());
             		Main.students.get(codeText.getText()).setDept(deptText.getText());
             		Main.students.get(codeText.getText()).setBan(banText.getText());
                    JOptionPane.showMessageDialog(null, "修改完成！", "提示",JOptionPane.WARNING_MESSAGE);   //弹出提示框
                    PrimePanel.refreshFile();
                 }else {
                     JOptionPane.showMessageDialog(null, "请输入正确的性别", "提示", JOptionPane.WARNING_MESSAGE); //弹出提示框
				}

			}
		}); 
    }

    //添加组件
	private void addPart(){
        nameLabel = new MyLabel(80, 15, 80, 40, "姓名");
        this.add(nameLabel);
        nameText = new MyTextFiled(140, 20, 200, 30);
        this.add(nameText);

        sexLabel = new MyLabel(80, 75, 80, 40, "性别");
        this.add(sexLabel);
        sexText = new MyTextFiled(140, 80, 200,30);
        this.add(sexText);

        placeLabel = new MyLabel(80, 135, 80, 40, "籍贯");
        this.add(placeLabel);
        placeText = new MyTextFiled(140, 140, 200, 30);
        this.add(placeText);

        codeLabel = new MyLabel(80, 195, 80, 40, "学号");
        this.add(codeLabel);
        codeText = new MyTextFiled(140, 200, 200, 30);
        codeText.setEditable(false);
        this.add(codeText);

        deptLabel = new MyLabel(80, 255, 80, 40, "系别");
        this.add(deptLabel);
        deptText = new MyTextFiled(140, 260, 200,30);
        this.add(deptText);

        banLabel = new MyLabel(80, 315, 80, 40, "班级");
        this.add(banLabel);
        banText = new MyTextFiled(140, 320, 200, 30);
        this.add(banText);
    }
}
