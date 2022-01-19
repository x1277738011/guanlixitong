package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.course;

public class Courses {
    /** ��Ա����1��ͨ��ͼ���ţ���ȡһ��ͼ����� */
    public static course getcoursesById(String courseno) {
        course courses = null;
        if (courseno != null) {
            // ���찴��ͼ���Ų�ѯͼ���sql��ѯ���
            String sql = "select * from course where course='" + courseno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    courses = new course();
                    courses.setCredits(rs.getInt("credits"));
                    courses.setCourseno(rs.getString("courseno"));
                    courses.setCourses(rs.getString("courses"));
                    courses.setCoursenoname(rs.getString("coursename"));
                    courses.setCoursetime(rs.getInt("coursetime"));
                    courses.setCourses(ChangeString.ISOToGBK(rs.getString("courses")));
                    courses.setCoursenoname(ChangeString.ISOToGBK(rs.getString("coursename")));
                    courses.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courses;// ����ͼ�����
    }

    /** ��Ա����2��ͨ��ͼ��������ȡһ��ͼ����� */
    public static course getcoursesByName(String coursesname) {
        course courses = null;
        if (coursesname != null) {
            // ���찴��ͼ�����Ʋ�ѯͼ���sql��ѯ���
            String sql = "select * from course where coursename='" + coursesname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    courses = new course();
                    courses.setCredits(rs.getInt("credits"));
                    courses.setCourseno(rs.getString("courseno"));
                    courses.setCourses(rs.getString("courses"));
                    courses.setCoursenoname(rs.getString("coursename"));
                    courses.setCoursetime(rs.getInt("coursetime"));
                    courses.setCourses(ChangeString.ISOToGBK(rs.getString("courses")));
                    courses.setCoursenoname(ChangeString.ISOToGBK(rs.getString("coursename")));
                    courses.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courses;// ����ͼ�����
    }

    /** ��Ա����3��ͨ��sql��ѯ��䣬��ȡͼ������б� */
    public static List<course> selectcoursesList(String sql) {
        List<course> list = new ArrayList<course>();// �����б�
        if (sql != null) {
            course courses = null;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                while (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    courses = new course();
                    courses.setCredits(rs.getInt("credits"));
                    courses.setCourseno(rs.getString("courseno"));
                    courses.setCourses(rs.getString("courses"));
                    courses.setCoursenoname(rs.getString("coursename"));
                    courses.setCoursetime(rs.getInt("coursetime"));
                    list.add(courses);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;// ����ͼ���б�
    }

    /** ��Ա����4����ȡ����ͼ������б� */
    public static List<course> selectcoursesList() {
        // �����ѯ����ͼ���sql��ѯ���
        String sql = "select * from course";
        return selectcoursesList(sql);// ����ͼ���б�
    }

    public static List<course> selectcoursesList(String field, String value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from course";
        if ((value != null & value.length() > 0) && field != null) {
            // ���찴���ַ����Բ�ѯͼ���sql��ѯ��䣬����ģ����ѯ
            sql = "select * from course where " + field + " like '%" + value + "%'";
        }
        return selectcoursesList(sql);// ����ͼ���б�
    }

    public static List<course> selectcoursesList(String field, int value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from course";
        if (field != null && value != 0) {
            // ���찴���������Բ�ѯͼ���sql��ѯ��䣬���������ѯ
            sql = "select * from course where " + field + "="+value;
        }
        return selectcoursesList(sql);// ����ͼ���б�
    }





    /** ��Ա����8����� */
    public static int insertcourses(course courseS) {
        if (courseS != null) {
            // ��ȡͼ����Ϣ
            int coursetime = courseS.getCoursetime();
            String coursename = courseS.getCoursenoname();
            String courseno = courseS.getCourseno();
            String courses= courseS.getCourses();
            int credits = courseS.getCredits();
            // �������ͼ���sql�������
            String sql = "insert into course values('" + courseno + "','" + coursename + "','" + courses
                    + "'," + coursetime + "," + credits + ")";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����9���޸�ָ����Ϣ */
    public static int updatecourses(course courseS) {
        if (courseS != null) {
            // ��ȡͼ����Ϣ
            int coursetime = courseS.getCoursetime();
            String coursename = courseS.getCoursenoname();
            String courseno = courseS.getCourseno();
            String courses= courseS.getCourses();
            int credits = courseS.getCredits();
            // �����޸�ͼ���sql�������
            String sql = "update course set courseno='" + courseno + "',coursename='" + coursename
                    + "',courses='" + courses + "',coursetime=" + coursetime
                    + ",credits=" + credits +
                    " where courseno='"+ courseno +"'";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����10��ɾ��ָ��ͼ����Ϣ */
    public static int deletecourses(String id) {
        // ����ɾ��ͼ���sql�������
        String sql = "delete from course  where courseno='" + id + "'";
        return BaseDao.executeUpdate(sql);// ִ�и������
    }

    /** ��Ա����11���������ͼ����Ϣ */
    public static void emptycourses() {
        // �������ͼ���sql�������
        String sql = "delete from course";
        BaseDao.executeUpdate(sql);// ִ�и������
    }
}