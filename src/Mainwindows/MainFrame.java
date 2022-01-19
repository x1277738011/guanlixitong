package Mainwindows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import data.BaseDao;
import Login.LoginView;
import data.Fillscore;

public class MainFrame extends PublicJFrame{
    /** ��Ա���� */
    private JMenuItem mi_user_students;// ����ѧ����Ϣ�˵���
    private JMenuItem mi_reader_upkeep;// ����ѧ���ɼ�
    private JMenuItem mi_book_course;// �����γ���Ϣ�˵���
    private JMenuItem tearcher;
    private JMenuItem Class;
    private JMenuItem mi_students;// ��������˵���
    private JMenuItem mi_tearch;// ��������˵���
    private JMenuItem amend_course;
    private JMenuItem amend_score;
    private JMenuItem mi_reader_query;// �������߲�ѯ�˵���
    private JMenuItem mi_book_query;// ����ͼ���ѯ�˵���
    private JMenuItem mi_update_pass;// �����޸�����˵���
    private JMenuItem mi_book_statistics;// ����ͼ��ͳ�Ʋ˵���
    private JMenuItem mi_exit;// �����˳�ϵͳ�˵���

    private JButton bt_reader_upkeep;// ��������ά����ť
    private JButton bt_book_upkeep;// ����ͼ��ά����ť
    private JButton bt_borrow;// �������鰴ť
    private JButton bt_back;// �������鰴ť
    private JButton bt_reader_query;// �������߲�ѯ��ť
    private JButton bt_book_query;// ����ͼ���ѯ��ť
    private JButton bt_book_statistics;// ����ͼ��ͳ�ư�ť
    private JButton bt_exit;// �����˳�ϵͳ��ť

    /** ���췽����ϵͳ�������ʼ������ */
    public MainFrame() {
        //��1����ϵͳ����������
        this.setTitle("��ѧ����ϵͳ");// �������������
        this.setExtendedState(Frame.MAXIMIZED_BOTH);// ���������洰�����
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //��2�������������ò˵������ȵ��ô���ϵͳ�˵�������������ϵͳ�˵���,�������������ò˵���
        this.setJMenuBar(createMenuBar());
        //��3���� ���������ù��������ȵ��ô���ϵͳ����������������ϵͳ���������ٽ���������ӵ�������Ϸ�
        this.add(createToolBar(), BorderLayout.NORTH);
        setPurView(LoginView.a);
    }

    /** ��Ա����1������ϵͳ�˵������� */
    private JMenuBar createMenuBar() {
        // ��1���������˵�������
        JMenuBar menuBar = new JMenuBar();
        //��2���������˵�
        JMenu menu_upkeep = new JMenu("��ѯ"); // ����"����ά��"�˵�
        //��3���������˵����Ϊ�˵������õ����¼�������
        mi_user_students = new JMenuItem("ѧ����Ϣ"); // �������û�ά�����˵���
        mi_user_students.addActionListener(new ActionListener() {//��ӵ����¼�������
            @Override
            public void actionPerformed(ActionEvent e) {
                user_upkeep_actionPerformed();// ���á��û�ά������Ӧ����
            }
        });
        //��4�������˵�����ӵ��˵���
        menu_upkeep.add(mi_user_students);// �����û�ά�����˵�����ӵ�������ά�����˵�

        mi_reader_upkeep = new JMenuItem("ѧ���ɼ�"); // ����������ά�����˵���
        mi_reader_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reader_upkeep_actionPerformed();// ���á�����ά������Ӧ����
            }
        });
        menu_upkeep.add(mi_reader_upkeep);// ��������ά�����˵�����ӵ�������ά�����˵�

        mi_book_course = new JMenuItem("�γ���Ϣ"); // ����"ͼ��ά��"�˵���
        mi_book_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                course_quer();// ����"ͼ��ά��"��Ӧ����
            }
        });
        menu_upkeep.add(mi_book_course);

        tearcher = new JMenuItem("��ʦ��Ϣ"); // ����"ͼ��ά��"�˵���
        tearcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book_upkeep_actionPerformed();// ����"ͼ��ά��"��Ӧ����
            }
        });
        menu_upkeep.add(tearcher);

        Class = new JMenuItem("�༶��Ϣ"); // ����"ͼ��ά��"�˵���
        Class.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                class_query();// ����"ͼ��ά��"��Ӧ����
            }
        });
        menu_upkeep.add(Class);
        //��5�������˵���ӵ��˵�����
        menuBar.add(menu_upkeep);// ��"����ά��"�˵���ӵ�ϵͳ�˵���

        JMenu menu_amend = new JMenu("�޸���Ϣ"); // ����"���Ĺ���"�˵�
        mi_students = new JMenuItem("ѧ����Ϣ"); // ����"����"�˵���
        mi_students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_students();
            }
        });
        menu_amend.add(mi_students);

        mi_tearch = new JMenuItem("��ʦ��Ϣ"); // ����"����"�˵���
        mi_tearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_tearch();// ����"����"��Ӧ����
            }
        });
        menu_amend.add(mi_tearch);

        amend_course = new JMenuItem("�γ���Ϣ"); // ����"����"�˵���
        amend_course.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_course();// ����"����"��Ӧ����
            }
        });
        menu_amend.add(amend_course);

        amend_score = new JMenuItem("ѧ������"); // ����"����"�˵���
        amend_score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_score();
            }
        });
        menu_amend.add(amend_score);

        menuBar.add(menu_amend);// ��"���Ĺ���"�˵���ӵ�ϵͳ�˵���


        JMenu menu_management = new JMenu("ϵͳ����");// ����"ϵͳ����"�˵�
        mi_update_pass = new JMenuItem("�޸�����"); // ����"�޸�����"�˵���
        mi_update_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_pass_actionPerformed();// ����"�޸�����"��Ӧ����
            }
        });
        menu_management.add(mi_update_pass);

        mi_exit = new JMenuItem("�˳�ϵͳ"); // ����"�˳�ϵͳ"�˵���
        mi_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_actionPerformed();// ����"�˳�ϵͳ"��Ӧ����
            }
        });
        menu_management.add(mi_exit);
        menuBar.add(menu_management);
        //��6�������ز˵�����
        return menuBar;
    }

    /** ��Ա����2�� �������������� */
    private JToolBar createToolBar() {
        //��1�������������ù�����
        JToolBar toolBar = new JToolBar("ͼ�����ϵͳ������");// ��������������
        toolBar.setFloatable(false); // ���ù��������ɸ���
        // ���ù������߿򵼽Ƿ�ʽ
        toolBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //��2���� ���������ù������ϵĿ�ݰ�ť
        bt_reader_upkeep = new JButton("�����Ǽ�");// ����"����ά��"��ť
        // ����"����ά��"ͼ��
        ImageIcon icon_reader_upkeep = new ImageIcon("images/reader_upkeep.png");
        bt_reader_upkeep.setIcon(icon_reader_upkeep);// Ϊ"����ά��"��ť����ͼ��
        bt_reader_upkeep.setToolTipText("�����Ǽ�");// Ϊ"����ά��"��ť������ʾ
        // ��"����ά��"��ťע�ᵥ���¼�������
        bt_reader_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_students();// ����"����ά������Ӧ����
            }
        });
        //��3��������ť��ӵ���������
        toolBar.add(bt_reader_upkeep);// ��������ά������ť��ӵ�������

        bt_book_upkeep = new JButton("���ſγ�");
        ImageIcon icon_book_upkeep = new ImageIcon("images/book_upkeep.png");
        bt_book_upkeep.setIcon(icon_book_upkeep);
        toolBar.add(bt_book_upkeep);
        bt_book_upkeep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_course();// ���á�ͼ��ά������Ӧ����
            }
        });

        bt_book_statistics = new JButton("���Ű༶");
        ImageIcon icon_book_statistics = new ImageIcon("images/book_statistics.png");
        bt_book_statistics.setIcon(icon_book_statistics);
        toolBar.add(bt_book_statistics);
        bt_book_statistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_class();
            }
        });

        bt_borrow = new JButton("¼��ɼ�");
        ImageIcon icon_borrow = new ImageIcon("images/borrow.png");
        bt_borrow.setIcon(icon_borrow);
        toolBar.add(bt_borrow);
        bt_borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_score();// ���á����顱��Ӧ����
            }
        });

        bt_book_query = new JButton("ѧ��ѡ��");
        ImageIcon icon_choice = new ImageIcon("images/borrow.png");
        bt_book_query.setIcon(icon_choice);
        toolBar.add(bt_book_query);
        bt_book_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choic();// ���á����顱��Ӧ����
            }
        });

        bt_back = new JButton("��¼�ɼ�");
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

        bt_reader_query = new JButton("��ְ�Ǽ�");
        ImageIcon icon_reader_query = new ImageIcon("images/reader_query.png");
        bt_reader_query.setIcon(icon_reader_query);
        toolBar.add(bt_reader_query);
        bt_reader_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_tearch();// ���á����߲�ѯ����Ӧ����
            }
        });


        bt_exit = new JButton("�˳�ϵͳ");
        ImageIcon icon_exit = new ImageIcon("images/exit.png");
        bt_exit.setIcon(icon_exit);
        toolBar.add(bt_exit);
        bt_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit_actionPerformed();// ���á��˳�ϵͳ"��Ӧ����
            }
        });
        //��4�������ع�����
        return toolBar;
    }

    /** ��Ա����3������ϵͳ����ʹ��Ȩ�޵ķ��� */
    void setPurView(String purView) {
        switch (purView) {
            case "2"://�û�Ȩ��Ϊ0��Ϊ����Ա
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
            case "1"://�û�Ȩ��Ϊ1��Ϊ����Ա
                break;

            default://�û�Ȩ��Ϊ������Ϊһ��ÿ�
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

    /** ��Ա����7���γ̲�ѯ��Ӧ���� */
    private void course_quer(){
        new coursequery();
    }
    /** ��Ա����4���û�ά����Ӧ���� */
    private void user_upkeep_actionPerformed() {
        new StudentsQuery();// �������û�ά��������
    }

    /** ��Ա����5������ά����Ӧ���� */
    private void reader_upkeep_actionPerformed() {
        new scorequery();// ����������ά��������
    }

    /** ��Ա����6��ͼ��ά����Ӧ���� */
    private void book_upkeep_actionPerformed() {
        new TearchQuery();// ������ͼ��ά��������
    }

    /** ��Ա����8���༶��ѯ���� */
    private void class_query() {
         new classquery();// ���������顱����
    }

    /** ��Ա����9���޸�ѧ����Ӧ���� */
    private void amend_students() {
        new addstudent();
    }

    /** ��Ա����10���޸Ľ�ʦ��Ӧ���� */
    private void amend_tearch() {
        new  amendtearch();// ���������߲�ѯ������
    }

    /** ��Ա����11���γ��޸���Ӧ���� */
    private void amend_course() {
        new amendcourse();// ������ͼ���ѯ������
    }

    /** ��Ա����12���޸ķ�����Ӧ���� */
    private void amend_score() {
        new amendscore();
    }

    /** ��Ա����13���޸�������Ӧ���� */
    private void update_pass_actionPerformed() {
        new UpdatePass();//// �������޸��û����롱����
    }
    /** ��Ա����14����¼�ɼ���Ӧ���� */
    private void amend_fill(){
        new amnedfill();
    }
    /** ��Ա����15����¼�ɼ���Ӧ���� */
    private void amend_class(){
        new amendclass();
    }
    /** ��Ա����16����¼�ɼ���Ӧ���� */
    private void choic(){
        new chosecourse();
    }

    /** ��Ա����17���˳�ϵͳ��Ӧ���� */
    private void exit_actionPerformed() {
        BaseDao.close();// �ر������ݿ������
        System.exit(0);// �˳�ϵͳ
    }


    // ���Է���������������Ĳ���
    public static void main(String args[]) {
        new MainFrame();;// ����ϵͳ��������������
    }
}
