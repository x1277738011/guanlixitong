package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.course;

public class Courses {
    /** 成员方法1：通过图书编号，获取一个图书对象 */
    public static course getcoursesById(String courseno) {
        course courses = null;
        if (courseno != null) {
            // 构造按照图书编号查询图书的sql查询语句
            String sql = "select * from course where course='" + courseno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return courses;// 返回图书对象
    }

    /** 成员方法2：通过图书名，获取一个图书对象 */
    public static course getcoursesByName(String coursesname) {
        course courses = null;
        if (coursesname != null) {
            // 构造按照图书名称查询图书的sql查询语句
            String sql = "select * from course where coursename='" + coursesname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return courses;// 返回图书对象
    }

    /** 成员方法3：通过sql查询语句，获取图书对象列表 */
    public static List<course> selectcoursesList(String sql) {
        List<course> list = new ArrayList<course>();// 创建列表
        if (sql != null) {
            course courses = null;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                while (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return list;// 返回图书列表
    }

    /** 成员方法4：获取所有图书对象列表 */
    public static List<course> selectcoursesList() {
        // 构造查询所有图书的sql查询语句
        String sql = "select * from course";
        return selectcoursesList(sql);// 返回图书列表
    }

    public static List<course> selectcoursesList(String field, String value) {
        // 构造默认的sql查询语句
        String sql = "select * from course";
        if ((value != null & value.length() > 0) && field != null) {
            // 构造按照字符属性查询图书的sql查询语句，采用模糊查询
            sql = "select * from course where " + field + " like '%" + value + "%'";
        }
        return selectcoursesList(sql);// 返回图书列表
    }

    public static List<course> selectcoursesList(String field, int value) {
        // 构造默认的sql查询语句
        String sql = "select * from course";
        if (field != null && value != 0) {
            // 构造按照整型属性查询图书的sql查询语句，采用区间查询
            sql = "select * from course where " + field + "="+value;
        }
        return selectcoursesList(sql);// 返回图书列表
    }





    /** 成员方法8：添加 */
    public static int insertcourses(course courseS) {
        if (courseS != null) {
            // 获取图书信息
            int coursetime = courseS.getCoursetime();
            String coursename = courseS.getCoursenoname();
            String courseno = courseS.getCourseno();
            String courses= courseS.getCourses();
            int credits = courseS.getCredits();
            // 构造添加图书的sql更新语句
            String sql = "insert into course values('" + courseno + "','" + coursename + "','" + courses
                    + "'," + coursetime + "," + credits + ")";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法9：修改指定信息 */
    public static int updatecourses(course courseS) {
        if (courseS != null) {
            // 获取图书信息
            int coursetime = courseS.getCoursetime();
            String coursename = courseS.getCoursenoname();
            String courseno = courseS.getCourseno();
            String courses= courseS.getCourses();
            int credits = courseS.getCredits();
            // 构造修改图书的sql更新语句
            String sql = "update course set courseno='" + courseno + "',coursename='" + coursename
                    + "',courses='" + courses + "',coursetime=" + coursetime
                    + ",credits=" + credits +
                    " where courseno='"+ courseno +"'";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法10：删除指定图书信息 */
    public static int deletecourses(String id) {
        // 构造删除图书的sql更新语句
        String sql = "delete from course  where courseno='" + id + "'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法11：清空所有图书信息 */
    public static void emptycourses() {
        // 构造清空图书的sql更新语句
        String sql = "delete from course";
        BaseDao.executeUpdate(sql);// 执行更新语句
    }
}