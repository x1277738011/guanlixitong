package Mainwindows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import data.BaseDao;
import Login.LoginView;
import data.Fillscore;

public class MainFrame extends PublicJFrame{
    /** 成员变量 */
    private JMenuItem mi_user_students;// 声明学生信息菜单项
    private JMenuItem mi_reader_upkeep;// 声明学生成绩
    private JMenuItem mi_book_course;// 声明课程信息菜单项
    private JMenuItem tearcher;
    private JMenuItem Class;
    private JMenuItem mi_students;// 声明借书菜单项
    private JMenuItem mi_tearch;// 声明还书菜单项
    private JMenuItem amend_course;
    private JMenuItem amend_score;
    private JMenuItem mi_reader_query;// 声明读者查询菜单项
    private JMenuItem mi_book_query;// 声明图书查询菜单项
    private JMenuItem mi_update_pass;// 声明修改密码菜单项
    private JMenuItem mi_book_statistics;// 声明图书统计菜单项
    private JMenuItem mi_exit;// 声明退出系统菜单项

    private JButton bt_reader_upkeep;// 声明读者维护按钮
    private JButton bt_book_upkeep;// 声明图书维护按钮
    private JButton bt_borrow;// 声明借书按钮
    private JButton bt_back;// 声明还书按钮
    private JButton bt_reader_query;// 声明读者查询按钮
    private JButton bt_book_query;// 声明图书查询按钮
    private JButton bt_book_statistics;// 声明图书统计按钮
    private JButton bt_exit;// 声明退出系统按钮

    /** 构造方法：系统主界面初始化方法 */
    public MainFrame() {
        //第1步：系统主界面设置
        this.setTitle("教学管理系统");// 设置主界面标题
        this.setExtendedState(Frame.MAXIMIZED_BOTH);// 设置主界面窗口最大化
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //第2步：创建、设置菜单栏。先调用创建系统菜单栏方法，创建系统菜单栏,再在主界面设置菜单栏
        this.setJMenuBar(createMenuBar());
        //第3步： 创建、设置工具栏。先调用创建系统工具栏方法，创建系统工具栏，再将工具栏添加到界面的上方
        this.add(createToolBar(), BorderLayout.NORTH);
        setPurView(LoginView.a);
    }

    /** 成员方法1：创建系统菜单栏方法 */
    private JMenuBar createMenuBar() {
        // 第1步：创建菜单栏对象
        JMenuBar menuBar = new JMenuBar();
        //第2步：创建菜单
        JMenu menu_upkeep = new JMenu("查询"); // 创建"基础维护"菜单
        //第3步：创建菜单项，并为菜单项设置单击事件监听器
        mi_user_students = new JMenuItem("学生信息"); // 创建“用户维护”菜单项
        mi_user_students.addActionListener(new ActionListener() {//添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                user_upkeep_actionPerformed();// 调用“用户维护”响应方法
            }
        });
        //第4步：将菜单项添加到菜单上
        menu_upkeep.add(mi_user_students);// 将“用户维护”菜单项添加到“基础维护”菜单

        mi_reader_upkeep = new JMenuItem("学生成绩"); // 创建“读者维护”菜单项
        mi_reader_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reader_upkeep_actionPerformed();// 调用“读者维护”响应方法
            }
        });
        menu_upkeep.add(mi_reader_upkeep);// 将“读者维护”菜单项添加到“基础维护”菜单

        mi_book_course = new JMenuItem("课程信息"); // 创建"图书维护"菜单项
        mi_book_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                course_quer();// 调用"图书维护"响应方法
            }
        });
        menu_upkeep.add(mi_book_course);

        tearcher = new JMenuItem("教师信息"); // 创建"图书维护"菜单项
        tearcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book_upkeep_actionPerformed();// 调用"图书维护"响应方法
            }
        });
        menu_upkeep.add(tearcher);

        Class = new JMenuItem("班级信息"); // 创建"图书维护"菜单项
        Class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                class_query();// 调用"图书维护"响应方法
            }
        });
        menu_upkeep.add(Class);
        //第5步：将菜单添加到菜单栏上
        menuBar.add(menu_upkeep);// 将"基础维护"菜单添加到系统菜单栏

        JMenu menu_amend = new JMenu("修改信息"); // 创建"借阅管理"菜单
        mi_students = new JMenuItem("学生信息"); // 创建"借书"菜单项
        mi_students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_students();
            }
        });
        menu_amend.add(mi_students);

        mi_tearch = new JMenuItem("教师信息"); // 创建"还书"菜单项
        mi_tearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_tearch();// 调用"还书"响应方法
            }
        });
        menu_amend.add(mi_tearch);

        amend_course = new JMenuItem("课程信息"); // 创建"还书"菜单项
        amend_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_course();// 调用"还书"响应方法
            }
        });
        menu_amend.add(amend_course);

        amend_score = new JMenuItem("学生分数"); // 创建"还书"菜单项
        amend_score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_score();
            }
        });
        menu_amend.add(amend_score);

        menuBar.add(menu_amend);// 将"借阅管理"菜单添加到系统菜单栏


        JMenu menu_management = new JMenu("系统管理");// 创建"系统管理"菜单
        mi_update_pass = new JMenuItem("修改密码"); // 创建"修改密码"菜单项
        mi_update_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_pass_actionPerformed();// 调用"修改密码"响应方法
            }
        });
        menu_management.add(mi_update_pass);

        mi_exit = new JMenuItem("退出系统"); // 创建"退出系统"菜单项
        mi_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_actionPerformed();// 调用"退出系统"响应方法
            }
        });
        menu_management.add(mi_exit);
        menuBar.add(menu_management);
        //第6步：返回菜单栏。
        return menuBar;
    }

    /** 成员方法2： 创建工具栏方法 */
    private JToolBar createToolBar() {
        //第1步：创建、设置工具栏
        JToolBar toolBar = new JToolBar("图书管理系统工具栏");// 创建工具栏对象
        toolBar.setFloatable(false); // 设置工具栏不可浮动
        // 设置工具栏边框导角方式
        toolBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //第2步： 创建、设置工具栏上的快捷按钮
        bt_reader_upkeep = new JButton("新生登记");// 创建"读者维护"按钮
        // 创建"读者维护"图标
        ImageIcon icon_reader_upkeep = new ImageIcon("images/reader_upkeep.png");
        bt_reader_upkeep.setIcon(icon_reader_upkeep);// 为"读者维护"按钮设置图标
        bt_reader_upkeep.setToolTipText("新生登记");// 为"读者维护"按钮设置提示
        // 将"读者维护"按钮注册单击事件监听器
        bt_reader_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_students();// 调用"读者维护’响应方法
            }
        });
        //第3步：将按钮添加到工具栏上
        toolBar.add(bt_reader_upkeep);// 将“读者维护”按钮添加到工具栏

        bt_book_upkeep = new JButton("安排课程");
        ImageIcon icon_book_upkeep = new ImageIcon("images/book_upkeep.png");
        bt_book_upkeep.setIcon(icon_book_upkeep);
        toolBar.add(bt_book_upkeep);
        bt_book_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_course();// 调用“图书维护”响应方法
            }
        });

        bt_book_statistics = new JButton("安排班级");
        ImageIcon icon_book_statistics = new ImageIcon("images/book_statistics.png");
        bt_book_statistics.setIcon(icon_book_statistics);
        toolBar.add(bt_book_statistics);
        bt_book_statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_class();
            }
        });

        bt_borrow = new JButton("录入成绩");
        ImageIcon icon_borrow = new ImageIcon("images/borrow.png");
        bt_borrow.setIcon(icon_borrow);
        toolBar.add(bt_borrow);
        bt_borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_score();// 调用“借书”响应方法
            }
        });

        bt_book_query = new JButton("学生选课");
        ImageIcon icon_choice = new ImageIcon("images/borrow.png");
        bt_book_query.setIcon(icon_choice);
        toolBar.add(bt_book_query);
        bt_book_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choic();// 调用“借书”响应方法
            }
        });

        bt_back = new JButton("补录成绩");
        ImageIcon icon_back = new ImageIcon("images/back.png");
        bt_back.setIcon(icon_back);
        toolBar.add(bt_back);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Fillscore.creat();
              amend_fill();
            }
        });

        bt_reader_query = new JButton("入职登记");
        ImageIcon icon_reader_query = new ImageIcon("images/reader_query.png");
        bt_reader_query.setIcon(icon_reader_query);
        toolBar.add(bt_reader_query);
        bt_reader_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_tearch();// 调用“读者查询”响应方法
            }
        });


        bt_exit = new JButton("退出系统");
        ImageIcon icon_exit = new ImageIcon("images/exit.png");
        bt_exit.setIcon(icon_exit);
        toolBar.add(bt_exit);
        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_actionPerformed();// 调用“退出系统"响应方法
            }
        });
        //第4步：返回工具栏
        return toolBar;
    }

    /** 成员方法3：设置系统功能使用权限的方法 */
    void setPurView(String purView) {
        switch (purView) {
            case "2"://用户权限为0，为操作员
                mi_students.setEnabled(false);
                mi_tearch.setEnabled(false);
                amend_score.setEnabled(false);
                amend_course.setEnabled(false);
                bt_reader_upkeep.setEnabled(false);
                bt_book_upkeep.setEnabled(false);
                bt_reader_query.setEnabled(false);
                bt_book_statistics.setEnabled(false);
                bt_book_query.setEnabled(false);

                break;
            case "1"://用户权限为1，为管理员
                break;

            default://用户权限为其他，为一般访客
                mi_students.setEnabled(false);
                mi_tearch.setEnabled(false);
                amend_score.setEnabled(false);
                amend_course.setEnabled(false);
                bt_reader_upkeep.setEnabled(false);
                bt_book_upkeep.setEnabled(false);
                bt_reader_query.setEnabled(false);
                mi_user_students.setEnabled(false);
                mi_book_course.setEnabled(false);
                tearcher.setEnabled(false);
                Class.setEnabled(false);
                bt_book_statistics.setEnabled(false);
                bt_borrow.setEnabled(false);
                bt_back.setEnabled(false);
        }
    }

    /** 成员方法7：课程查询响应方法 */
    private void course_quer(){
        new coursequery();
    }
    /** 成员方法4：用户维护响应方法 */
    private void user_upkeep_actionPerformed() {
        new StudentsQuery();// 创建“用户维护”界面
    }

    /** 成员方法5：读者维护响应方法 */
    private void reader_upkeep_actionPerformed() {
        new scorequery();// 创建“读者维护”界面
    }

    /** 成员方法6：图书维护响应方法 */
    private void book_upkeep_actionPerformed() {
        new TearchQuery();// 创建“图书维护”界面
    }

    /** 成员方法8：班级查询方法 */
    private void class_query() {
         new classquery();// 创建“借书”界面
    }

    /** 成员方法9：修改学生响应方法 */
    private void amend_students() {
        new addstudent();
    }

    /** 成员方法10：修改教师响应方法 */
    private void amend_tearch() {
        new  amendtearch();// 创建“读者查询”界面
    }

    /** 成员方法11：课程修改响应方法 */
    private void amend_course() {
        new amendcourse();// 创建“图书查询”界面
    }

    /** 成员方法12：修改分数响应方法 */
    private void amend_score() {
        new amendscore();
    }

    /** 成员方法13：修改密码响应方法 */
    private void update_pass_actionPerformed() {
        new UpdatePass();//// 创建“修改用户密码”界面
    }
    /** 成员方法14：补录成绩响应方法 */
    private void amend_fill(){
        new amnedfill();
    }
    /** 成员方法15：补录成绩响应方法 */
    private void amend_class(){
        new amendclass();
    }
    /** 成员方法16：补录成绩响应方法 */
    private void choic(){
        new chosecourse();
    }

    /** 成员方法17：退出系统响应方法 */
    private void exit_actionPerformed() {
        BaseDao.close();// 关闭与数据库的连接
        System.exit(0);// 退出系统
    }


    // 测试方法：用于主界面的测试
    public static void main(String args[]) {
        new MainFrame();;// 创建系统主界面匿名对象
    }
}
