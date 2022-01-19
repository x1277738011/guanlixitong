package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Class;

public class clas {
    /** ��Ա����1��ͨ���༶�ţ���ȡһ������ */
    public static Class getClasssById(String Classserno) {
        Class Classs = null;
        if (Classserno != null) {
            // ���찴�ձ�Ų�ѯ�༶��sql��ѯ���
            String sql = "select * from class where classno='" + Classserno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    Classs = new Class();
                    Classs.setStudents(rs.getInt("students"));
                    Classs.setClassno(rs.getString("classno"));
                    Classs.setCoursename(rs.getString("coursename"));
                    Classs.setCourseno(rs.getString("courseno"));
                    Classs.setTearcherno(rs.getString("tearcherno"));
                    Classs.setTearchername(rs.getString("tearchername"));
                    Classs.setTearcherno(ChangeString.ISOToGBK(rs.getString("tearcherno")));
                    Classs.setClassno(ChangeString.ISOToGBK(rs.getString("classno")));
                    Classs.setTearchername(ChangeString.ISOToGBK(rs.getString("tearchername")));
                    Classs.setCoursename(ChangeString.ISOToGBK(rs.getString("coursename")));
                    Classs.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Classs;// ����ͼ�����
    }

    /** ��Ա����2��ͨ��ͼ��������ȡһ��ͼ����� */
    public static Class getClasssByName(String Classsname) {
        Class Classs = null;
        if (Classsname != null) {
            // ���찴��ͼ�����Ʋ�ѯͼ���sql��ѯ���
            String sql = "select * from Class where courseno='" + Classsname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    Classs = new Class();
                    Classs.setStudents(rs.getInt("students"));
                    Classs.setClassno(rs.getString("classno"));
                    Classs.setCoursename(rs.getString("coursename"));
                    Classs.setCourseno(rs.getString("courseno"));
                    Classs.setTearcherno(rs.getString("tearcherno"));
                    Classs.setTearchername(rs.getString("tearchername"));
                    Classs.setTearcherno(ChangeString.ISOToGBK(rs.getString("tearcherno")));
                    Classs.setClassno(ChangeString.ISOToGBK(rs.getString("classno")));
                    Classs.setTearchername(ChangeString.ISOToGBK(rs.getString("tearchername")));
                    Classs.setCoursename(ChangeString.ISOToGBK(rs.getString("coursename")));
                    Classs.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Classs;// ����ͼ�����
    }

    /** ��Ա����3��ͨ��sql��ѯ��䣬��ȡͼ������б� */
    public static List<Class> selectClasssList(String sql) {
        List<Class> list = new ArrayList<Class>();// �����б�
        if (sql != null) {
            Class Classs = null;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                while (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    Classs = new Class();
                    Classs.setStudents(rs.getInt("students"));
                    Classs.setClassno(rs.getString("classno"));
                    Classs.setCoursename(rs.getString("coursename"));
                    Classs.setCourseno(rs.getString("courseno"));
                    Classs.setTearcherno(rs.getString("tearcherno"));
                    Classs.setTearchername(rs.getString("tearchername"));
                    list.add(Classs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;// ����ͼ���б�
    }

    /** ��Ա����4����ȡ����ͼ������б� */
    public static List<Class> selectClasssList() {
        // �����ѯ����ͼ���sql��ѯ���
        String sql = "select * from class";
        return selectClasssList(sql);// ����ͼ���б�
    }

    public static List<Class> selectClasssList(String field, String value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from class";
        if ((value != null & value.length() > 0) && field != null) {
            // ���찴���ַ����Բ�ѯͼ���sql��ѯ��䣬����ģ����ѯ
            sql = "select * from class where " + field + " like '%" + value + "%'";
        }
        return selectClasssList(sql);// ����ͼ���б�
    }

    public static List<Class> selectClasssList(String field, int value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from class";
        if (field != null && value != 0) {
            // ���찴���������Բ�ѯͼ���sql��ѯ��䣬���������ѯ
            sql = "select * from class where " + field + ">="+value;
        }
        return selectClasssList(sql);// ����ͼ���б�
    }





    /** ��Ա����8����� */
    public static int insertClasss(Class Classs) {
        if (Classs != null) {
            // ��ȡͼ����Ϣ
            String courseno = Classs.getCourseno();
            String tearchername = Classs.getTearchername();
            String classno = Classs.getClassno();
            String coursename= Classs.getCoursename();
            int students = Classs.getStudents();
            String tearchno = Classs.getTearcherno();
            // �������ͼ���sql�������
            String sql = "insert into class values('" + classno + "','" + courseno + "','" + coursename
                    + "','" + tearchno + "','"  + tearchername + "'," + students +")";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����9���޸�ָ��ͼ����Ϣ */
    public static int updateClasss(Class Classs) {
        if (Classs != null) {
            // ��ȡͼ����Ϣ
            String courseno = Classs.getCourseno();
            String tearchername = Classs.getTearchername();
            String classno = Classs.getClassno();
            String coursename= Classs.getCoursename();
            int students = Classs.getStudents();
            String tearchno = Classs.getTearcherno();
            // �����޸�ͼ���sql�������
            String sql = "update class set classno='" + classno + "',courseno='" + courseno
                    + "',coursename='" + coursename + "', tearcherno='" + tearchno
                    + "',tearchername='" + tearchername + "',students=" + students + " where classno='"+classno+"'";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����10��ɾ��ָ��ͼ����Ϣ */
    public static int deleteClasss(String id) {
        // ����ɾ��ͼ���sql�������
        String sql = "delete from class  where calssno='" + id + "'";
        return BaseDao.executeUpdate(sql);// ִ�и������
    }

    /** ��Ա����11���������ͼ����Ϣ */
    public static void emptyClasss() {
        // �������ͼ���sql�������
        String sql = "delete from class";
        BaseDao.executeUpdate(sql);// ִ�и������
    }
}
