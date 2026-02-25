# ZSC_StudentSystem

> 程序设计实践-学生信息管理系统
> 
> 作者：李嘉伟（组长） 陈梓佳 钟家明

## 目录

Main类负责启动程序和关闭程序

在MainWindow继承JFrame下调用PrimePanel类

初步创建面板的布局和大小。窗口的布局，以及生成和位置


### 界面

* JOptionPane

showConfirmDialog()：确认对话框

showInputDialog()：输入对话框

showMessageDialog()：消息对话框

showOptionDialog()：选择对话框

* JButton

* JPanel

* JLabel

* JTextField

* MyButton

* MyLabel

* MyTextFiled


### 主要面板

* PrimePanel


```public PrimePanel(int x, int y, int width, int height){}```

> 重写JPanel的构造方法，清空布局管理器；
> 
> 自定义设置位置长宽，字体样式，按钮，监听，读取；

```private void readStudentFile(){}```

> 读取学生信息到集合中（以txt文件的形式进行存储）
>
> 此处用到IO流的输入流BufferedReader对学生信息进行文件式的存储

```public void paintComponent(Graphics g){}```

> 重写paintComponent(Graphics g)方法以图片进行绘制（设置窗口页面）

```static public void refreshFile(){}```

> 刷新文件中的学生信息，在修改、增加和删除中会被调用



### 增加

AddWin

实现两大监听事件，确定按钮（主要）和清空按钮

> 实现事件监听，在事件中调用MyTextFiled类继承JTextField；
> 
> 判断输入文本框中的名字，性别，籍贯，学号，系别，班级的内容是否合法
> 
> 若输入的六项信息符合并且在students集合中不存在时，则把学生的信息添加到集合中
> 
> 调用创建好的PrimePanel类中的refreshFile方法，将信息读入到students.txt文本中


### 删除

DelWin

实现两大监听事件，确定按钮（主要）和清空按钮

> 实现事件监听，在事件中调用创建好的集合HashMap，以学号作为Key(键），以Student类作为Value（值）；
> 
> 通过判断是否存在以这个学号为键的映射关系和名字是否一致，并且判断该键的映射关系是否还在里面和集合大小是否改变了；
>
> 若判断为true，则调用PrimePanel类的refreshFile方法更新学生的信息


### 查找

* FindWin

> 查找时判断输入姓名和学号是否存在

* FoundWin

> 符合查找的情况，使用关于的信息的标签和文本框显示学生相应的信息

### 修改

* ChangeWIn 

> 修改时判断输入姓名和学号是否存在

* ChangedWIn 

> 符合修改的情况，在填修改信息时判断修改的信息是否正确

### 全部

* WholeWin

> 通过继承JFrame的窗口布局和JTable的表格布局
> 
> 显示学生的五大信息：姓名，性别，籍贯，学号，系别，班级


### 学生

> private 的使用使得变量的调用更加的安全
> 
> Student 负责基本的无参和有参构造器，初始化变量，重写toString方法方便调用输出格式




