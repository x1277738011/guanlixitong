package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.students;

public class Students{
    /** ��Ա����1��ͨ��ͼ���ţ���ȡһ��ͼ����� */
    public static students getstudentById(int studentno) {
        students student = null;
        if (studentno != 0) {
            // ���찴��ͼ���Ų�ѯͼ���sql��ѯ���
            String sql = "select * from students where studentno='" + studentno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    student = new students();
                    student.setStudentno(rs.getInt("studentno"));
                    student.setStudentnme(rs.getString("studentname"));
                    student.setSex(rs.getString("sex"));
                    student.setAge(rs.getInt("age"));
                    student.setDepartmentname(rs.getString("departmentname"));
                    student.setGetcredits(rs.getInt("getcredits"));
                    student.setStudentnme(ChangeString.ISOToGBK(rs.getString("studentname")));
                    student.setDepartmentname(ChangeString.ISOToGBK(rs.getString("departmentname")));
                    student.setSex(ChangeString.ISOToGBK(rs.getString("sex")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;// ����ͼ�����
    }

    /** ��Ա����2��ͨ��ͼ��������ȡһ��ͼ����� */
    public static students getstudentByName(String studentname) {
        students student = null;
        if (studentname != null) {
            // ���찴��ͼ�����Ʋ�ѯͼ���sql��ѯ���
            String sql = "select * from students where studentname='" + studentname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    student = new students();
                    student.setStudentno(rs.getInt("studentno"));
                    student.setStudentnme(rs.getString("studentnme"));
                    student.setSex(rs.getString("sex"));
                    student.setAge(rs.getInt("age"));
                    student.setDepartmentname(rs.getString("departmentname"));
                    student.setGetcredits(rs.getInt("getcredits"));
                    student.setStudentnme(ChangeString.ISOToGBK(rs.getString("studentnme")));
                    student.setDepartmentname(ChangeString.ISOToGBK(rs.getString("departmentname")));
                    student.setSex(ChangeString.ISOToGBK(rs.getString("sex")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;// ����ͼ�����
    }

    /** ��Ա����3��ͨ��sql��ѯ��䣬��ȡͼ������б� */
    public static List<students> selectstudentList(String sql) {
        List<students> list = new ArrayList<students>();// �����б�
        if (sql != null) {
            students student = null;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                while (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    student = new students();
                    student.setStudentno(rs.getInt("studentno"));
                    student.setStudentnme(rs.getString("studentname"));
                    student.setDepartmentname(rs.getString("departmentname"));
                    student.setSex(rs.getString("sex"));
                    student.setAge(rs.getInt("age"));
                    student.setGetcredits(rs.getInt("getcredits"));
                    list.add(student);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;// ����ͼ���б�
    }

    /** ��Ա����4����ȡ����ͼ������б� */
    public static List<students> selectstudentList() {
        // �����ѯ����ͼ���sql��ѯ���
        String sql = "select * from students";
        return selectstudentList(sql);// ����ͼ���б�
    }

    public static List<students> selectstudentList(String field, String value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from students";
        if ((value != null & value.length() > 0) && field != null) {
            // ���찴���ַ����Բ�ѯͼ���sql��ѯ��䣬����ģ����ѯ
            sql = "select * from students where " + field + " like '%" + value + "%'";
        }
        return selectstudentList(sql);// ����ͼ���б�
    }

    public static List<students> selectstudentList(String field, int value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from students";
        if (field != null && value != 0) {
            // ���찴���������Բ�ѯͼ���sql��ѯ��䣬���������ѯ
            sql = "select * from students where " + field + "="+value;
        }
        return selectstudentList(sql);// ����ͼ���б�
    }

  



    /** ��Ա����8�������ͼ�� */
    public static int insertstudent(students student) {
        if (student != null) {
            // ��ȡͼ����Ϣ
            int studentno = student.getStudentno();
            String studentnme = student.getStudentnme();
            String sex = student.getSex();
            int age = student.getAge();
            String departmentname = student.getDepartmentname();
            int getcredits = student.getGetcredits();
            // �������ͼ���sql�������
            String sql = "insert into students values(" + studentno + ",'" + studentnme + "','" + sex
                    + "'," + age + ",'" + departmentname + "'," + getcredits + ")";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����9���޸�ָ����Ϣ */
    public static int updatestudent(students student) {
        if (student != null) {
            // ��ȡͼ����Ϣ
            int studentno = student.getStudentno();
            String studentnme = student.getStudentnme();
            String sex = student.getSex();
            int age = student.getAge();
            String departmentname = student.getDepartmentname();
            int getcredits = student.getGetcredits();
            // �����޸�ͼ���sql�������
            String sql = "update students set studentname='" + studentnme + "',sex='" + sex
                    + "',age=" + age + ", departmentname='" + departmentname
                    + "',getcredits=" + getcredits + " where studentno=" + studentno + "";
            String sq="update score set studentname='" + studentnme + "'  where studentno=" + studentno + "";

            return BaseDao.executeUpdate(sql)+BaseDao.executeUpdate(sq);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����10��ɾ��ָ��ͼ����Ϣ */
    public static int deletestudent(String id) {
        // ����ɾ��ͼ���sql�������
        String sql = "delete from students  where studentno='" + id + "'";
        return BaseDao.executeUpdate(sql);// ִ�и������
    }

    /** ��Ա����11���������ͼ����Ϣ */
    public static void emptystudent() {
        // �������ͼ���sql�������
        String sql = "delete from students";
        BaseDao.executeUpdate(sql);// ִ�и������
    }
}
