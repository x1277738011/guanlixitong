package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.students;

public class Students{
    /** 成员方法1：通过图书编号，获取一个图书对象 */
    public static students getstudentById(int studentno) {
        students student = null;
        if (studentno != 0) {
            // 构造按照图书编号查询图书的sql查询语句
            String sql = "select * from students where studentno='" + studentno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return student;// 返回图书对象
    }

    /** 成员方法2：通过图书名，获取一个图书对象 */
    public static students getstudentByName(String studentname) {
        students student = null;
        if (studentname != null) {
            // 构造按照图书名称查询图书的sql查询语句
            String sql = "select * from students where studentname='" + studentname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return student;// 返回图书对象
    }

    /** 成员方法3：通过sql查询语句，获取图书对象列表 */
    public static List<students> selectstudentList(String sql) {
        List<students> list = new ArrayList<students>();// 创建列表
        if (sql != null) {
            students student = null;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                while (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return list;// 返回图书列表
    }

    /** 成员方法4：获取所有图书对象列表 */
    public static List<students> selectstudentList() {
        // 构造查询所有图书的sql查询语句
        String sql = "select * from students";
        return selectstudentList(sql);// 返回图书列表
    }

    public static List<students> selectstudentList(String field, String value) {
        // 构造默认的sql查询语句
        String sql = "select * from students";
        if ((value != null & value.length() > 0) && field != null) {
            // 构造按照字符属性查询图书的sql查询语句，采用模糊查询
            sql = "select * from students where " + field + " like '%" + value + "%'";
        }
        return selectstudentList(sql);// 返回图书列表
    }

    public static List<students> selectstudentList(String field, int value) {
        // 构造默认的sql查询语句
        String sql = "select * from students";
        if (field != null && value != 0) {
            // 构造按照整型属性查询图书的sql查询语句，采用区间查询
            sql = "select * from students where " + field + "="+value;
        }
        return selectstudentList(sql);// 返回图书列表
    }

  



    /** 成员方法8：添加新图书 */
    public static int insertstudent(students student) {
        if (student != null) {
            // 获取图书信息
            int studentno = student.getStudentno();
            String studentnme = student.getStudentnme();
            String sex = student.getSex();
            int age = student.getAge();
            String departmentname = student.getDepartmentname();
            int getcredits = student.getGetcredits();
            // 构造添加图书的sql更新语句
            String sql = "insert into students values(" + studentno + ",'" + studentnme + "','" + sex
                    + "'," + age + ",'" + departmentname + "'," + getcredits + ")";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法9：修改指定信息 */
    public static int updatestudent(students student) {
        if (student != null) {
            // 获取图书信息
            int studentno = student.getStudentno();
            String studentnme = student.getStudentnme();
            String sex = student.getSex();
            int age = student.getAge();
            String departmentname = student.getDepartmentname();
            int getcredits = student.getGetcredits();
            // 构造修改图书的sql更新语句
            String sql = "update students set studentname='" + studentnme + "',sex='" + sex
                    + "',age=" + age + ", departmentname='" + departmentname
                    + "',getcredits=" + getcredits + " where studentno=" + studentno + "";
            String sq="update score set studentname='" + studentnme + "'  where studentno=" + studentno + "";

            return BaseDao.executeUpdate(sql)+BaseDao.executeUpdate(sq);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法10：删除指定图书信息 */
    public static int deletestudent(String id) {
        // 构造删除图书的sql更新语句
        String sql = "delete from students  where studentno='" + id + "'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法11：清空所有图书信息 */
    public static void emptystudent() {
        // 构造清空图书的sql更新语句
        String sql = "delete from students";
        BaseDao.executeUpdate(sql);// 执行更新语句
    }
}
