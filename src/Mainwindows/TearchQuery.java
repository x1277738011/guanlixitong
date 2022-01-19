package Mainwindows;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.util.List;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.Tearchs;
import entity.tearchs;

public class TearchQuery extends PublicJFrame {
    /** ��Ա������ */
    JLabel lb_query;// ������ѯ��ǩ
    JTextField tf_query;// ������ѯ�����ı���
    JComboBox<String> cb_query;// ������ѯ��Ŀ��Ͽ�
    JButton bt_query;// ������ѯ��ť
    private JTable table;// �������
    // ���÷�������ȡ����ͼ���б�������
    private List<tearchs> list = Tearchs.selecttearchList();
    // ����ͼ�����Ŀ�����ַ���
    private String[] tb_heads = { "���� ", "���� ", "�Ա�", "����Ժϵ", "ְλ",
            "����","����"};
    // ͼ�����Ŀ���ƶ�Ӧ�ı��ֶ�
    private String[] fields = { "tearcherno", "teachername", "sex",
            "departmentname","title" ,"age","salary"};
    // ����ͼ����ģ��
    private DefaultTableModel model = new DefaultTableModel(
            new Object[][] {}, tb_heads);
    private String field = "tearcherno";// ����Ĭ�ϵĵ�ǰ�Ĳ�ѯ�ֶ�
    String valueStr = " ";// �����ַ������Ͳ�ѯ�ֶεĳ�ʼֵ
    int valueInt=0;


    /** ���췽������ʼ������ */
    TearchQuery() {
        this.setTitle("--��ʦ��Ϣ��ѯ-- ");
        this.setVisible(true);
        this.setSize(1200, 500);
        JPanel queryPanel = createQueryPanel();
        this.add(queryPanel, BorderLayout.NORTH);
        JPanel tablePanel = createTablePanel();
        this.add(tablePanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
    }

    /** ��Ա����1��������ѯ���ķ��� */
    private JPanel createQueryPanel() {
        JPanel queryPanel = new JPanel();
        queryPanel.setOpaque(false);
        queryPanel.setLayout(new GridBagLayout());
        ((GridBagLayout) queryPanel
                .getLayout()).columnWidths = new int[] { 0, 100, 200,
                120, 80, 80, 0 };
        ((GridBagLayout) queryPanel
                .getLayout()).columnWeights = new double[] { 0.5, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.5 };

        lb_query = new JLabel("�����빤��");
        queryPanel.add(lb_query,
                new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.EAST,
                        GridBagConstraints.BOTH,
                        new Insets(10, 10, 10, 10), 0, 0));

        tf_query = new JTextField();
        tf_query.requestFocus();
        // Ϊ��ѯ�����ı�����ӻس����¼�������
        tf_query.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                if (arg0.getKeyChar() == '\n') {
                    // ���á���ѯ����ť�¼���Ӧ����
                    bn_query_actionPerformed();
                }
            }
        });
        queryPanel.add(tf_query,
                new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(10, 0, 10, 10), 0, 0));

        cb_query = new JComboBox<String>(tb_heads);
        // Ϊ��ѯ��Ŀ��Ͽ������Ŀ�¼�������
        cb_query.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                // ���á���ѯ��Ŀ����Ͽ���Ŀ״̬���ı��¼���Ӧ����
                cb_query_itemStateChanged(arg0);
            }
        });
        queryPanel.add(cb_query,
                new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(10, 0, 10, 10), 0, 0));

        bt_query = new JButton("��ѯ ");
        // Ϊ����ѯ����ť����ӵ����¼�������
        bt_query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // ���á���ѯ����ť�¼���Ӧ����
                bn_query_actionPerformed();
            }
        });
        queryPanel.add(bt_query,
                new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(10, 0, 10, 10), 0, 0));

        JButton bn_close = new JButton("�ر�");
        // Ϊ���رա���ť����ӵ����¼�������
        bn_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();// �رս���
            }
        });
        queryPanel.add(bn_close,
                new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.BOTH,
                        new Insets(10, 0, 10, 10), 0, 0));
        return queryPanel;// ���ء���ѯ��塱
    }

    /** ��Ա����2������������ķ��� */
    private JPanel createTablePanel() {
        // ���������壬���ñ߽粼��
        JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
        JScrollPane scrollPane = new JScrollPane();// �����������
        tablePanel.add(scrollPane);// ����������ӵ����������
        table = new JTable(model);// ������񣬲�����ָ���ı��ģ��
        addRowToModel(list);
        scrollPane.setViewportView(table);
        return tablePanel;
    }

    /** ��Ա����3������ģ�ͣ����ͼ���б� */
    private void addRowToModel(List<tearchs> list) {
        model.setRowCount(0);// ������ģ���е�����
        for (int i = 0; i < list.size(); i++) {
            tearchs tearch = list.get(i);
            model.addRow(new Object[] { tearch.gettearcherno(), tearch.getTearchername(),
                    tearch.getDepartmentname(), tearch.getSex(),tearch.getTitle(),
                    tearch.getage(), tearch.getSalary(),});
        }
    }

    /** ��Ա����4����ѯ��Ŀ��Ͽ�״̬���ı���¼���Ӧ���� */
    private void cb_query_itemStateChanged(ItemEvent arg0) {
        if (arg0.getStateChange() == ItemEvent.SELECTED) {
            // ����ѡ��ı��ǩ��ʾ����
            lb_query.setText("������" + (String) arg0.getItem() + ":");
            tf_query.setText("");
            // ��ȡ��Ͽ���ѡ������Ŀ����
            for (int i = 0; i < tb_heads.length; i++) {
                if (arg0.getItem().equals(tb_heads[i])) {
                    field = fields[i];// �����Ӧ���ֶΣ���Ϊ��ǰ��ѡ�����ֶ�
                }
            }
            list = Tearchs.selecttearchList();// ���÷�������ȡ����ͼ���б�
            addRowToModel(list);// ���÷�������ͼ���б���ӵ����ģ����
            tf_query.requestFocus();// ���ò�ѯ�����ı��򣬻�ý���
        }
    }

    /** ��Ա����5������ѯ����ť�����¼���Ӧ���� */
    private void bn_query_actionPerformed() {

        switch (field) {
            case "sex":
            case "teachername":
            case "departmentname":
            case "title":
            case "tearcherno":

                // ��ȡ�ַ������͵Ĳ�ѯ����
                valueStr = tf_query.getText();
                // ���ð��գ��ֶ������ַ����ֶ�ֵ����ѯͼ���б�ķ�������ѯͼ����Ϣ
                list = Tearchs.selecttearchList(field,valueStr);
                break;
            case "age":
            case "salary":

                // ��ȡ�������͵Ĳ�ѯ����
                if (" ".equals(tf_query.getText())) {
                    tf_query.setText("0");
                }
                valueInt = new Integer(tf_query.getText()).intValue();
                // ���ð��գ��ֶ����������ֶ�ֵ����ѯͼ���б�ķ�������ѯͼ����Ϣ
                list = Tearchs.selecttearchList(field, valueInt);
                break;
        }
        addRowToModel(list);// ����ѯ��ȡ��ͼ���б���ӵ����ģ����
    }

    /** ���Է����� */
    public static void main(String[] args) {
        new TearchQuery();
    }
}
