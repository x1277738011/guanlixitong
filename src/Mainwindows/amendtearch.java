package Mainwindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import sun.applet.Main;
import util.Constant;
import data.Tearchs;
import entity.tearchs;

public class amendtearch extends PublicJFrame {
    /** 成员变量 */
    private JTextField tf_id;// 声明图书编号文本框
    private JTextField tf_name;// 声明书名文本框
    private JComboBox<String> cb_type;// 声明图书类型组合框
    private JTextField tf_sex;// 声明作者文本框
    private JTextField tf_title;//职位
    private JTextField tf_age;// 声明译者文本框
    private JTextField tf_salary;// 声明出版社文本框

    // 声明添加、修改、取消、关闭、删除、清空按钮
    private JButton jb_insert, jb_update, jb_cancel, jb_close,
            jb_delete, jb_empty;
    private JTable table;// 声明表格
    // 创建图书表格模型
    private DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, new String[] { "工号", "教师姓名", "性别",
            "年龄", "所属院系", "职位","工资" });
    private List<tearchs> list = Tearchs.selecttearchList();// 创建所有图书列表，并保存图书对象

    /** 构造方法：用于初始化界面 */
    amendtearch() {
        // 界面设置
        this.setTitle("--教师信息编辑--");
        setBounds(220, 100, 1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // 创建一个对话面板,其上放置一个外部分割面板，并将它设置为框架的内容面板
        JPanel dialogPane = new JPanel();
        dialogPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialogPane.setBackground(new Color(198, 236, 253));
        dialogPane.setLayout(new BorderLayout());
        setContentPane(dialogPane);

        // 创建一个外部分割面板，水平左右放置组件。其中，左测放置一个内部分割面板，右测放置一个表格面板
        JSplitPane outerPane = new JSplitPane();// 创建外部分割面板
        outerPane.setOpaque(false);// 设置外部分割面板透明
        outerPane.setResizeWeight(0.1);// 设置外部分割面板宽度分配权限
        outerPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//设置外部分割面板水平分配
        outerPane.setOneTouchExpandable(true);//设置外部分割面板可以有一个触发扩展
        dialogPane.add(outerPane, BorderLayout.CENTER);
        // 创建一个内部分割面板，垂直上下放置组件。其中，上方放置一个数据面板，下方放置一个按钮面板
        JSplitPane innerPane = new JSplitPane();// 创建内部分割面板
        innerPane.setOpaque(false);
        // 为一个内部分割面板设置边框说明
        innerPane.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, null, null),
                "教师信息", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("微软雅黑", Font.PLAIN, 14),
                new Color(59, 59, 59)));
        innerPane.setResizeWeight(0.8);
        innerPane.setOrientation(JSplitPane.VERTICAL_SPLIT);//设置内部分割面板为垂直分配
        outerPane.setLeftComponent(innerPane);// 将内部分割面板设置在外部分割面板的左侧
        JPanel dataPanel = createDataPanel();// 调用创建数据面板方法，创建数据面板
        innerPane.setLeftComponent(dataPanel);// 将数据面板，设置在内部分割面板的左侧
        JPanel buttonPanel = createButtonPanel();// 调用创建按钮面板方法，创建按钮面板
        innerPane.setRightComponent(buttonPanel);// 将按钮面板设置在内部分割面板的下方
        JPanel tablePanel = createTablePanel();// 调用创建表格面板方法，创建表格面板
        outerPane.setRightComponent(tablePanel);// 将表格面板，设置在外部分割面板的右侧
    }

    /** 成员方法1：用于创建“数据面板"的方法 */
    private JPanel createDataPanel() {
        JPanel dataPanel = new JPanel(null);
        dataPanel.setBorder(new EmptyBorder(5, 5, 5, 10));
        dataPanel.setOpaque(false);

        JLabel jl_id = new JLabel("工号:");
        jl_id.setBounds(50, 20, 100, 25);
        dataPanel.add(jl_id);

        tf_id = new JTextField();
        tf_id.setBounds(140, 20, 170, 25);

        tf_id.setToolTipText("必须输入工号");
        tf_id.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                tf_id_focusLost();// 调用图书编号文本框加失去焦点事件响应方法
            }
        });
        dataPanel.add(tf_id);

        JLabel jl_name = new JLabel("教师姓名:");
        jl_name.setBounds(50, 60, 100, 25);
        dataPanel.add(jl_name);

        tf_name = new JTextField(10);
        tf_name.setBounds(140, 60, 170, 25);
        tf_name.setToolTipText("必须输入教师姓名");
        dataPanel.add(tf_name);
        tf_name.addFocusListener(new FocusAdapter() {//为图书名文本框添加失去焦点监听器
            @Override
            public void focusLost(FocusEvent e) {
                tf_name_focusLost();// 调用图书名文本框加失去焦点事件响应方法
            }
        });

        JLabel jl_type = new JLabel("所属学院:");
        jl_type.setBounds(50, 100, 150, 25);
        dataPanel.add(jl_type);

        cb_type = new JComboBox<String>(Constant.BOOK_TYPES);
        cb_type.setBounds(140, 100, 170, 25);
        dataPanel.add(cb_type);

        JLabel jl_sex = new JLabel("性别：");
        jl_sex.setBounds(50, 140, 150, 25);
        dataPanel.add(jl_sex);

        tf_sex = new JTextField(10);
        tf_sex.setBounds(140, 140, 170, 25);
        dataPanel.add(tf_sex);

        JLabel jl_translator = new JLabel("年龄:");
        jl_translator.setBounds(50, 180, 150, 25);
        dataPanel.add(jl_translator);

        tf_age = new JTextField(10);
        tf_age.setBounds(140, 180, 170, 25);
        dataPanel.add(tf_age);

        JLabel jl_publisher = new JLabel("工资 :");
        jl_publisher.setBounds(50, 220, 150, 25);
        dataPanel.add(jl_publisher);

        tf_salary = new JTextField(10);
        tf_salary.setBounds(140, 220, 170, 25);
        dataPanel.add(tf_salary);

        JLabel jl_publish_time = new JLabel("职位:");
        jl_publish_time.setBounds(50, 260, 150, 25);
        dataPanel.add(jl_publish_time);

        tf_title = new JTextField(10);
        tf_title.setBounds(140, 260, 170, 25);
        dataPanel.add(tf_title);



        return dataPanel;
    }

    /** 成员方法2：用于创建"按钮面板"的方法 */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());//创建按钮面板，用网格包布局
        buttonPanel.setOpaque(false);
        ((GridBagLayout) buttonPanel
                .getLayout()).columnWidths = new int[] { 0, 60, 60,
                60, 60, 60, 0 };// 设置网格包布局各列宽度
        ((GridBagLayout) buttonPanel
                .getLayout()).columnWeights = new double[] { 0.5, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.5 };// 设置网格包布局各列的宽度权限

        jb_insert = new JButton("添加");
        jb_insert.addActionListener(new ActionListener() {//为添加按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_insert_actionPerformed();// 调用添加按钮事件响应方法，添加图书
            }
        });
        buttonPanel.add(jb_insert,
                new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_update = new JButton("修改");
        jb_update.addActionListener(new ActionListener() {//为修改按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_update_actionPerformed();// 调用修改按钮事件响应方法，修改图书信息
            }
        });
        buttonPanel.add(jb_update,
                new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_delete = new JButton("删除");
        jb_delete.addActionListener(new ActionListener() {// 为删除按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_delete_actionPerformed();// 调用删除按钮事件响应方法，删除图书对象
            }
        });
        buttonPanel.add(jb_delete,
                new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_cancel = new JButton("取消");
        jb_cancel.addActionListener(new ActionListener() {//为取消按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                del_content();// 调用删除内容方法，清除数据面板中的数据
            }
        });
        buttonPanel.add(jb_cancel,
                new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_close = new JButton("关闭");
        jb_close.addActionListener(new ActionListener() {//为关闭按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();// 关闭图书维护界面
            }
        });
        buttonPanel.add(jb_close,
                new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_empty = new JButton("清空所有信息！");
        jb_empty.addActionListener(new ActionListener() {//为清空按钮添加单击事件监听器
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_empty_actionPerformed();// 调用清空按钮事件响应方法，清空所有图书
            }
        });
        buttonPanel.add(jb_empty,
                new GridBagConstraints(2, 1, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(25, 0, 0, 0), 0, 0));
        return buttonPanel;
    }

    /** 成员方法3：用于创建表格面板的方法 */
    private JPanel createTablePanel() {
        // 创建表格面板，采用边界布局
        JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
        JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
        tablePanel.add(scrollPane);// 将表格面板添加到滚动面板上
        table = new JTable(model);// 创建表格，并采用指定的表格模型

        for (int i = 0; i < list.size(); i++) {
            tearchs tearch = list.get(i);
            model.addRow(new Object[] { tearch.gettearcherno(), tearch.getTearchername(),
                    tearch.getSex(), tearch.getage(),
                    tearch.getDepartmentname(), tearch.getTitle(),tearch.getSalary()});
        }
        table.addMouseListener(new MouseAdapter() {// 为表格添加鼠标事件监听器
            @Override
            public void mouseClicked(MouseEvent e) {
                // 调用表格鼠标单击事件响应方法，向左侧数据面板显示选中图书
                table_mouseClicked();
            }
        });
        scrollPane.setViewportView(table);
        return tablePanel;
    }

    /** 成员方法4：用于清除数据面板中的数据 */
    public void del_content() {
        tf_id.setText("");
        tf_name.setText("");
        cb_type.setSelectedIndex(0);
        tf_sex.setText("");
        tf_age.setText("");
        tf_salary.setText("");
        tf_title.setText("");
        tf_id.setEditable(true);
    }

    /** 成员方法5：图书编号文本框失去焦点事件响应具体方法 */
    public void tf_id_focusLost() {
        // 通过图书编号，获取图书对象
        tearchs tearch = Tearchs.gettearchById(tf_id.getText().trim());
        if (tearch != null) {// 判断图书对象是否存在，若存在，清除数据，重新输入读者编号
            JOptionPane.showMessageDialog(null,
                    "教师工号已经存在，请重新输入教师工号！");
            del_content(); // 清除数据面板中的数据
        }
    }

    /** 成员方法6：图书名文本框失去焦点事件响应具体方法 */
    public void tf_name_focusLost() {
        tearchs tearch = Tearchs.gettearchByName(tf_name.getText().trim());
        if (tearch != null) {
            JOptionPane.showMessageDialog(null, "教师名已经存在，请重新输入教师名！");
            tf_name.setText("");
        }
    }

    /** 成员方法7：用于更新表格数据 */
    public void refresh() {
        model.setRowCount(0);// 清除表格模型中的数据
        list = Tearchs.selecttearchList();// 获取图书对象列表
        for (int i = 0; i < list.size(); i++) {// 重新项表格模型中添加数据
            tearchs tearch = list.get(i);
            model.addRow(new Object[]   { tearch.gettearcherno(), tearch.getTearchername(),
                    tearch.getSex(), tearch.getage(),
                    tearch.getDepartmentname(), tearch.getTitle(),tearch.getSalary()});
        }
        del_content();// 清除数据面板中的数据

    }

    /** 成员方法8：表格鼠标单击事件响应方法 */
    public void table_mouseClicked() {
        // 获取选中图书的信息
        tearchs tearch_old = list.get(table.getSelectedRow());
        // 在数据面板中设置对应的图书数据
        tf_id.setText(tearch_old.gettearcherno());
        tf_name.setText(tearch_old.getTearchername());
        tf_sex.setText(tearch_old.getSex());
        tf_age.setText(String.valueOf(tearch_old.getage()));
        cb_type.setSelectedItem(tearch_old.getDepartmentname());
        tf_salary.setText(String.valueOf(tearch_old.getSalary()));
        tf_title.setText(tearch_old.getTitle());
        tf_id.setEditable(false);// 设置读者图书文本框不可编辑
    }

    /** 成员方法9：添加新图书方法 */
    public void jb_insert_actionPerformed() {
        tearchs tearch = new tearchs();// 创建一个图书对象
        // 设置图书对象的属性值
        tearch.setTearcherno(tf_id.getText().trim());
        tearch.setTearchername(tf_name.getText().trim());
        tearch.setSex(tf_sex.getText().trim());
        tearch.setage(new Integer(tf_age.getText().trim()));
        tearch.setDepartmentname(cb_type.getSelectedItem().toString());
        tearch.setSalary(new Integer(tf_salary.getText().trim()));
        tearch.settitle(tf_title.getText().trim());
        // 判断图书名或图书编号不允许为空？若空，则给出提示，并返回
        if (tf_name.getText().trim().equals("")
                || tf_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "图书信息不能为空！");
            return;
        } else {// 若不空，则执行添加图书对象操作
            int i = Tearchs.inserttearch(tearch);// 执行添加操作
            if (i == 1) {// 判断添加操作是否成功？若成功，则向表格模型添加这条数据
                model.addRow(new Object[] { tearch.gettearcherno(), tearch.getTearchername(),
                        tearch.getSex(), tearch.getage(),
                        tearch.getDepartmentname(), tearch.getTitle(),tearch.getSalary() });
                refresh();
            }
            del_content();
        }
    }

    /** 成员方法10：修改图书信息按钮事件响应方法 */
    public void jb_update_actionPerformed() {
        tearchs tearch = new tearchs();// 创建一个图书对象
        tearch.setTearcherno(tf_id.getText().trim());
        tearch.setTearchername(tf_name.getText().trim());
        tearch.setSex(tf_sex.getText().trim());
        tearch.setage(new Integer(tf_age.getText().trim()));
        tearch.setDepartmentname(cb_type.getSelectedItem().toString());
        tearch.settitle(tf_title.getText().trim());
        tearch.setSalary(new Integer(tf_salary.getText().trim()));


        if (tf_name.getText().trim().equals("")
                || tf_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "教师信息不能为空！");
            return;
        } else {// 若不空，则执行添加图书对象操作
            int i = Tearchs.updatetearch(tearch);
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "教师信息修改成功！");
            }

            refresh();// 更新表格内容
            del_content();
        }
    }

    /** 成员方法11：删除 信息 */
    public void jb_delete_actionPerformed() {
        String id = tf_id.getText().trim(); // 获取用户编号
        // 调用确认对话框，询问是否删除图书？
        int m = JOptionPane.showConfirmDialog(null, "你确认要删除这条信息吗?",
                "删除图书信息", JOptionPane.YES_NO_OPTION);
        if (m == JOptionPane.YES_OPTION) {// 如果确定，则执行删除操作
            if (Tearchs.deletetearch(id) == 1) {// 执行用户删除操作
                refresh();// 更新表格内容
                JOptionPane.showMessageDialog(null, "信息删除成功！");
            }
            del_content();// 清除数据面板内容
        }
    }

    /** 成员方法12：删除所有信息 */
    public void jb_empty_actionPerformed() {
        int m = JOptionPane.showConfirmDialog(null, "你确认要删除所有信息吗?",
                "清空信息", JOptionPane.YES_NO_OPTION);
        if (m == JOptionPane.YES_OPTION) {
            int n = JOptionPane.showConfirmDialog(null,
                    "真的确认清空所有图书数据吗?", "清空信息再次确认",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                Tearchs.emptytearch();
                refresh();// 更新表格内容
                del_content();// 清除数据面板内容
            }
        }
    }

    // 测试方法：用于图书维护的测试
    public static void main(String[] args) {
        new Mainwindows.amendtearch();
    }
}