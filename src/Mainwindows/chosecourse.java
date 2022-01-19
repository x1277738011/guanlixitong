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

import data.clas;
import sun.applet.Main;

import data.chose;
import entity.score;
import entity.Class;

public class chosecourse extends PublicJFrame {
    /** ��Ա���� */
    private JTextField tf_id;// ����ͼ�����ı���
    private JTextField tf_name;// ���������ı���
    private JTextField tf_no;// ����ͼ�����ı���
    private JTextField tf_coursename;// ���������ı���
    private JTextField tf_score;// ���������ı���
    private JTextField tf_tearchername;// �����������ı���
    private JTextField tf_fillscore;
    // ������ӡ��޸ġ�ȡ�����رա�ɾ������հ�ť
    private JButton jb_insert, jb_update, jb_cancel, jb_close,
            jb_delete, jb_empty;
    private JTable table;// �������
    // ����ͼ����ģ��
    private DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, new String[] { "�༶��", "�γ̺�", "�γ���",
            "��ʦ��", "��ʦ��", "ѧ������", });
    private List<Class> list = clas.selectClasssList();// ��������ͼ���б�������ͼ�����

    /** ���췽�������ڳ�ʼ������ */
    chosecourse() {
        // ��������
        this.setTitle("--ѧ��ѡ��--");
        setBounds(220, 100, 1300, 650);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // ����һ���Ի����,���Ϸ���һ���ⲿ�ָ���壬����������Ϊ��ܵ��������
        JPanel dialogPane = new JPanel();
        dialogPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        dialogPane.setBackground(new Color(198, 236, 253));
        dialogPane.setLayout(new BorderLayout());
        setContentPane(dialogPane);

        // ����һ���ⲿ�ָ���壬ˮƽ���ҷ�����������У�������һ���ڲ��ָ���壬�Ҳ����һ��������
        JSplitPane outerPane = new JSplitPane();// �����ⲿ�ָ����
        outerPane.setOpaque(false);// �����ⲿ�ָ����͸��
        outerPane.setResizeWeight(0.1);// �����ⲿ�ָ�����ȷ���Ȩ��
        outerPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);//�����ⲿ�ָ����ˮƽ����
        outerPane.setOneTouchExpandable(true);//�����ⲿ�ָ���������һ��������չ
        dialogPane.add(outerPane, BorderLayout.CENTER);
        // ����һ���ڲ��ָ���壬��ֱ���·�����������У��Ϸ�����һ��������壬�·�����һ����ť���
        JSplitPane innerPane = new JSplitPane();// �����ڲ��ָ����
        innerPane.setOpaque(false);
        // Ϊһ���ڲ��ָ�������ñ߿�˵��
        innerPane.setBorder(new TitledBorder(
                new EtchedBorder(EtchedBorder.LOWERED, null, null),
                "ѡ��", TitledBorder.LEADING, TitledBorder.TOP,
                new Font("΢���ź�", Font.PLAIN, 14),
                new Color(59, 59, 59)));
        innerPane.setResizeWeight(0.8);
        innerPane.setOrientation(JSplitPane.VERTICAL_SPLIT);//�����ڲ��ָ����Ϊ��ֱ����
        outerPane.setLeftComponent(innerPane);// ���ڲ��ָ�����������ⲿ�ָ��������
        JPanel dataPanel = createDataPanel();// ���ô���������巽���������������
        innerPane.setLeftComponent(dataPanel);// ��������壬�������ڲ��ָ��������
        JPanel buttonPanel = createButtonPanel();// ���ô�����ť��巽����������ť���
        innerPane.setRightComponent(buttonPanel);// ����ť����������ڲ��ָ������·�
        JPanel tablePanel = createTablePanel();// ���ô��������巽��������������
        outerPane.setRightComponent(tablePanel);// �������壬�������ⲿ�ָ������Ҳ�
    }

    /** ��Ա����1�����ڴ������������"�ķ��� */
    private JPanel createDataPanel() {
        JPanel dataPanel = new JPanel(null);
        dataPanel.setBorder(new EmptyBorder(5, 5, 5, 10));
        dataPanel.setOpaque(false);

        JLabel jl_id = new JLabel("ѧ��:");
        jl_id.setBounds(50, 20, 100, 25);
        dataPanel.add(jl_id);

        tf_id = new JTextField();
        tf_id.setBounds(140, 20, 170, 25);

        tf_id.setToolTipText("��������ѧ�ź�");
        tf_id.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                tf_id_focusLost();// ����ͼ�����ı����ʧȥ�����¼���Ӧ����
            }
        });
        dataPanel.add(tf_id);

        JLabel jl_name = new JLabel("ѧ������:");
        jl_name.setBounds(50, 60, 100, 25);
        dataPanel.add(jl_name);

        tf_name = new JTextField(10);
        tf_name.setBounds(140, 60, 170, 25);
        tf_name.setToolTipText("��������ѧ������");
        dataPanel.add(tf_name);
        tf_name.addFocusListener(new FocusAdapter() {//Ϊͼ�����ı������ʧȥ���������
            @Override
            public void focusLost(FocusEvent e) {
                tf_name_focusLost();// ����ͼ�����ı����ʧȥ�����¼���Ӧ����
            }
        });

        JLabel jl_type = new JLabel("�γ̺�:");
        jl_type.setBounds(50, 100, 150, 25);
        dataPanel.add(jl_type);

        tf_no = new JTextField(10);
        tf_no.setBounds(140, 100, 170, 25);
        dataPanel.add(tf_no);

        JLabel jl_author = new JLabel("�γ�����");
        jl_author.setBounds(50, 140, 150, 25);
        dataPanel.add(jl_author);

        tf_coursename = new JTextField(10);
        tf_coursename.setBounds(140, 140, 170, 25);
        dataPanel.add(tf_coursename);

        JLabel jl_translator = new JLabel("����:");
        jl_translator.setBounds(50, 180, 150, 25);
        dataPanel.add(jl_translator);

        tf_score = new JTextField(10);
        tf_score.setBounds(140, 180, 170, 25);
        dataPanel.add(tf_score);


        JLabel jl_publisher = new JLabel("�༶��:");
        jl_publisher.setBounds(50, 220, 150, 25);
        dataPanel.add(jl_publisher);

        tf_tearchername = new JTextField(10);
        tf_tearchername.setBounds(140, 220, 170, 25);
        dataPanel.add(tf_tearchername);

        JLabel jl_score = new JLabel("��������:");
        jl_score.setBounds(50, 260, 150, 25);
        dataPanel.add(jl_score);

        tf_fillscore = new JTextField(10);
        tf_fillscore.setBounds(140, 260, 170, 25);
        dataPanel.add(tf_fillscore);


        return dataPanel;
    }

    /** ��Ա����2�����ڴ���"��ť���"�ķ��� */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());//������ť��壬�����������
        buttonPanel.setOpaque(false);
        ((GridBagLayout) buttonPanel
                .getLayout()).columnWidths = new int[] { 0, 60, 60,
                60, 60, 60, 0 };// ������������ָ��п��
        ((GridBagLayout) buttonPanel
                .getLayout()).columnWeights = new double[] { 0.5, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.5 };// ������������ָ��еĿ��Ȩ��

        jb_insert = new JButton("ѡ��");
        jb_insert.addActionListener(new ActionListener() {//Ϊ��Ӱ�ť��ӵ����¼�������
            @Override
            public void actionPerformed(ActionEvent e) {
                jb_insert_actionPerformed();// ������Ӱ�ť�¼���Ӧ���������ͼ��
            }
        });
        buttonPanel.add(jb_insert,
                new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));



        jb_cancel = new JButton("ȡ��");
        jb_cancel.addActionListener(new ActionListener() {//Ϊȡ����ť��ӵ����¼�������
            @Override
            public void actionPerformed(ActionEvent e) {
                del_content();// ����ɾ�����ݷ����������������е�����
            }
        });
        buttonPanel.add(jb_cancel,
                new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

        jb_close = new JButton("�ر�");
        jb_close.addActionListener(new ActionListener() {//Ϊ�رհ�ť��ӵ����¼�������
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();// �ر�ͼ��ά������
            }
        });
        buttonPanel.add(jb_close,
                new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));


        return buttonPanel;
    }

    /** ��Ա����3�����ڴ���������ķ��� */
    private JPanel createTablePanel() {
        // ���������壬���ñ߽粼��
        JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
        JScrollPane scrollPane = new JScrollPane();// �����������
        tablePanel.add(scrollPane);// ����������ӵ����������
        table = new JTable(model);// ������񣬲�����ָ���ı��ģ��

        for (int i = 0; i < list.size(); i++) {
            Class scores = list.get(i);
            model.addRow(new Object[]   { scores.getClassno(), scores.getCourseno(),
                    scores.getCoursename(),
                    scores.getTearcherno(), scores.getTearchername(),scores.getStudents()});
        }
        table.addMouseListener(new MouseAdapter() {// Ϊ����������¼�������
            @Override
            public void mouseClicked(MouseEvent e) {
                // ���ñ����굥���¼���Ӧ��������������������ʾѡ��ͼ��
                //table_mouseClicked();
            }
        });
        scrollPane.setViewportView(table);
        return tablePanel;
    }

    /** ��Ա����4�����������������е����� */
    public void del_content() {
        tf_id.setText("");
        tf_name.setText("");
        tf_no.setText("");
        tf_coursename.setText("");
        tf_score.setText("");
        tf_tearchername.setText("");
        tf_fillscore.setText("");
        tf_id.setEditable(true);
    }

    /** ��Ա����5��ͼ�����ı���ʧȥ�����¼���Ӧ���巽�� */
    public void tf_id_focusLost() {
        // ͨ��ͼ���ţ���ȡͼ�����
        score scores = chose.getscoresById(new Integer(tf_id.getText().trim()));
        if (scores != null) {// �ж�ͼ������Ƿ���ڣ������ڣ�������ݣ�����������߱��
            JOptionPane.showMessageDialog(null,
                    "����Ѿ����ڣ������������ţ�");
            del_content(); // �����������е�����
        }
    }

    /** ��Ա����6���ı���ʧȥ�����¼���Ӧ���巽�� */
    public void tf_name_focusLost() {
        score scores = chose.getscoresByName(tf_no.getText().trim());
        if (scores != null) {
            //JOptionPane.showMessageDialog(null, "ͼ�����Ѿ����ڣ�����������ͼ������");
            tf_name.setText("");
        }
    }

    /** ��Ա����7�����ڸ��±������ */
    public void refresh() {
        model.setRowCount(0);// ������ģ���е�����
        list = clas.selectClasssList();// ��ȡ�����б�
        for (int i = 0; i < list.size(); i++) {// ��������ģ�����������
            Class scores = list.get(i);
            model.addRow(new Object[]   { scores.getClassno(), scores.getCourseno(),
                     scores.getCoursename(),
                    scores.getTearcherno(), scores.getTearchername(),scores.getStudents()});
        }
        del_content();// �����������е�����

    }


    /** ��Ա����9����ӷ��� */
    public void jb_insert_actionPerformed() {
        score scores = new score();// ����һ��ͼ�����
        // ����ͼ����������ֵ
        scores.setStudentno(new Integer(tf_id.getText().trim()));
        scores.setStudentname(tf_name.getText().trim());
        scores.setCourseno(tf_no.getText().trim());
        scores.setCoursename(tf_coursename.getText().trim());
        scores.setScore(new Integer(tf_score.getText().trim()));
        scores.setTearchername(tf_tearchername.getText().trim());
        scores.setFillscore(new Integer(tf_fillscore.getText().trim()));

        // �ж�ͼ������ͼ���Ų�����Ϊ�գ����գ��������ʾ��������
        if (tf_name.getText().trim().equals("")
                || tf_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "ѡ��ʧ�ܣ�");
            return;
        } else  {// �����գ���ִ�����ͼ��������
            int i = chose.insertscores(scores);
            JOptionPane.showMessageDialog(null, "ѡ�γɹ���");// ִ����Ӳ���
            if (i == 1) {// �ж���Ӳ����Ƿ�ɹ������ɹ���������ģ�������������
                model.addRow(new Object[] {  });
                refresh();
            }
            else { JOptionPane.showMessageDialog(null, "ѡ��ʧ�ܣ�");  }
            del_content();
        }
    }

    /** ��Ա����10���޸���Ϣ��ť�¼���Ӧ���� */
    public void jb_update_actionPerformed() {
        score scores = new score();// ����һ��ͼ�����
        scores.setStudentno(Integer.parseInt(tf_id.getText().trim()));
        scores.setStudentname(tf_name.getText().trim());
        scores.setCourseno(tf_no.getText().trim());
        scores.setCoursename(tf_coursename.getText().trim());
        scores.setScore(new Integer(tf_score.getText().trim()));
        scores.setTearchername(tf_tearchername.getText().trim());
        scores.setFillscore(new Integer(tf_fillscore.getText().trim()));


        if (tf_name.getText().trim().equals("")
                || tf_id.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "��Ϣ����Ϊ�գ�");
            return;
        } else {// �����գ���ִ�����ͼ��������
            int i = chose.updatescores(scores);
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "��Ϣ�޸ĳɹ���");
            }

            refresh();// ���±������
            del_content();
        }
    }

    /** ��Ա����11��ɾ����Ϣ */
    public void jb_delete_actionPerformed() {
        int no = Integer.parseInt(tf_id.getText().trim()); // ��ȡ�û����
        String id=tf_no.getText().trim();
        // ����ȷ�϶Ի���ѯ���Ƿ�ɾ��ͼ�飿
        int m = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ������ͼ����Ϣ��?",
                "ɾ��ͼ����Ϣ", JOptionPane.YES_NO_OPTION);
        if (m == JOptionPane.YES_OPTION) {// ���ȷ������ִ��ɾ������
            if (chose.deletescores(no,id) == 1) {// ִ���û�ɾ������
                refresh();// ���±������
                JOptionPane.showMessageDialog(null, "ͼ����Ϣɾ���ɹ���");
            }
            del_content();// ��������������
        }
    }

    /** ��Ա����12��ɾ����Ϣ */
    public void jb_empty_actionPerformed() {
        int m = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ��������Ϣ��?",
                "�����Ϣ", JOptionPane.YES_NO_OPTION);
        if (m == JOptionPane.YES_OPTION) {
            int n = JOptionPane.showConfirmDialog(null,
                    "���ȷ���������������?", "�����Ϣ�ٴ�ȷ��",
                    JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                chose.emptyscores();
                refresh();// ���±������
                del_content();// ��������������
            }
        }
    }

    // ���Է���������ͼ��ά���Ĳ���
    public static void main(String[] args) {
        new Mainwindows.chosecourse();
    }
}
