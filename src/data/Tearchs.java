package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.tearchs;

public class Tearchs {
    /** ��Ա����1��ͨ��ͼ���ţ���ȡһ��ͼ����� */
    public static tearchs gettearchById(String tearcherno) {
        tearchs tearch = null;
        if (tearcherno != null) {
            // ���찴��ͼ���Ų�ѯͼ���sql��ѯ���
            String sql = "select * from tearch where tearcherno='" + tearcherno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    tearch = new tearchs();
                    tearch.setTearcherno(rs.getString("tearcherno"));
                    tearch.setTearchername(rs.getString("teachername"));
                    tearch.setDepartmentname(rs.getString("departmentname"));
                    tearch.setSex(rs.getString("sex"));
                    tearch.setSalary(rs.getInt("salary"));
                    tearch.settitle(rs.getString("title"));
                    tearch.setage(rs.getInt("age"));
                    tearch.setTearcherno(ChangeString.ISOToGBK(rs.getString("tearcherno")));
                    tearch.setTearchername(ChangeString.ISOToGBK(rs.getString("teachername")));
                    tearch.setDepartmentname(ChangeString.ISOToGBK(rs.getString("departmentname")));
                    tearch.setSex(ChangeString.ISOToGBK(rs.getString("sex")));
                    tearch.settitle(ChangeString.ISOToGBK(rs.getString("title")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tearch;// ����ͼ�����
    }

    /** ��Ա����2��ͨ��ͼ��������ȡһ��ͼ����� */
    public static tearchs gettearchByName(String tearchname) {
        tearchs tearch = null;
        if (tearchname != null) {
            // ���찴��ͼ�����Ʋ�ѯͼ���sql��ѯ���
            String sql = "select * from tearch where teachername='" + tearchname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    tearch = new tearchs();
                    tearch.setTearcherno(rs.getString("tearcherno"));
                    tearch.setTearchername(rs.getString("teachername"));
                    tearch.setDepartmentname(rs.getString("departmentname"));
                    tearch.setSex(rs.getString("sex"));
                    tearch.setSalary(rs.getInt("salary"));
                    tearch.settitle(rs.getString("title"));
                    tearch.setage(rs.getInt("age"));
                    tearch.setTearcherno(ChangeString.ISOToGBK(rs.getString("tearcherno")));
                    tearch.setTearchername(ChangeString.ISOToGBK(rs.getString("teachername")));
                    tearch.setDepartmentname(ChangeString.ISOToGBK(rs.getString("departmentname")));
                    tearch.setSex(ChangeString.ISOToGBK(rs.getString("sex")));
                    tearch.settitle(ChangeString.ISOToGBK(rs.getString("title")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tearch;// ����ͼ�����
    }

    /** ��Ա����3��ͨ��sql��ѯ��䣬��ȡͼ������б� */
    public static List<tearchs> selecttearchList(String sql) {
        List<tearchs> list = new ArrayList<tearchs>();// �����б�
        if (sql != null) {
            tearchs tearch = null;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                while (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    tearch = new tearchs();
                    tearch.setTearcherno(rs.getString("tearcherno"));
                    tearch.setTearchername(rs.getString("teachername"));
                    tearch.setDepartmentname(rs.getString("departmentname"));
                    tearch.setSex(rs.getString("sex"));
                    tearch.setSalary(rs.getInt("salary"));
                    tearch.settitle(rs.getString("title"));
                    tearch.setage(rs.getInt("age"));
                    list.add(tearch);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;// ����ͼ���б�
    }

    /** ��Ա����4����ȡ����ͼ������б� */
    public static List<tearchs> selecttearchList() {
        // �����ѯ����ͼ���sql��ѯ���
        String sql = "select * from tearch";
        return selecttearchList(sql);// ����ͼ���б�
    }

    public static List<tearchs> selecttearchList(String field, String value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from tearch";
        if ((value != null & value.length() > 0) && field != null) {
            // ���찴���ַ����Բ�ѯͼ���sql��ѯ��䣬����ģ����ѯ
            sql = "select * from tearch where " + field + " like '%" + value + "%'";
        }
        return selecttearchList(sql);// ����ͼ���б�
    }

    public static List<tearchs> selecttearchList(String field, int value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from tearch";
        if (field != null && value != 0) {
            // ���찴���������Բ�ѯͼ���sql��ѯ��䣬���������ѯ
            sql = "select * from tearch where " + field + "="+value;
        }
        return selecttearchList(sql);// ����ͼ���б�
    }





    /** ��Ա����8�������ͼ�� */
    public static int inserttearch(tearchs tearch) {
        if (tearch != null) {
            // ��ȡͼ����Ϣ
            String tearcherno = tearch.gettearcherno();
            String tearchername = tearch.getTearchername();
            String sex = tearch.getSex();
            String title= tearch.getTitle();
            int salar = tearch.getSalary();
            String departmentname = tearch.getDepartmentname();
            int age = tearch.getage();
            // �������ͼ���sql�������
            String sql = "insert into tearch values('" + tearcherno + "','" + tearchername + "','" + sex
                    + "'," + age + ",'" + departmentname + "','" + title + "',"  + salar + ")";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����9���޸�ָ��ͼ����Ϣ */
    public static int updatetearch(tearchs tearch) {
        if (tearch != null) {
            // ��ȡͼ����Ϣ
            String tearcherno = tearch.gettearcherno();
            String tearchername = tearch.getTearchername();
            String sex = tearch.getSex();
            String title= tearch.getTitle();
            int salar = tearch.getSalary();
            String departmentname = tearch.getDepartmentname();
            int age = tearch.getage();
            // �����޸�ͼ���sql�������
            String sql = "update tearch set tearcherno='" + tearcherno + "',teachername='" + tearchername
                    + "',sex='" + sex + "', age=" + age
                    + ",departmentname='" + departmentname + "',title='" + title + "',salary=" + salar +" where tearcherno='"+tearcherno+"'";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����10��ɾ��ָ��ͼ����Ϣ */
    public static int deletetearch(String id) {
        // ����ɾ��ͼ���sql�������
        String sql = "delete from tearch  where tearcherno='" + id + "'";
        return BaseDao.executeUpdate(sql);// ִ�и������
    }

    /** ��Ա����11���������ͼ����Ϣ */
    public static void emptytearch() {
        // �������ͼ���sql�������
        String sql = "delete from tearch";
        BaseDao.executeUpdate(sql);// ִ�и������
    }
}
