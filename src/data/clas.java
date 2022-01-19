package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.Class;

public class clas {
    /** 成员方法1：通过班级号，获取一个对象 */
    public static Class getClasssById(String Classserno) {
        Class Classs = null;
        if (Classserno != null) {
            // 构造按照编号查询班级的sql查询语句
            String sql = "select * from class where classno='" + Classserno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return Classs;// 返回图书对象
    }

    /** 成员方法2：通过图书名，获取一个图书对象 */
    public static Class getClasssByName(String Classsname) {
        Class Classs = null;
        if (Classsname != null) {
            // 构造按照图书名称查询图书的sql查询语句
            String sql = "select * from Class where courseno='" + Classsname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return Classs;// 返回图书对象
    }

    /** 成员方法3：通过sql查询语句，获取图书对象列表 */
    public static List<Class> selectClasssList(String sql) {
        List<Class> list = new ArrayList<Class>();// 创建列表
        if (sql != null) {
            Class Classs = null;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                while (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return list;// 返回图书列表
    }

    /** 成员方法4：获取所有图书对象列表 */
    public static List<Class> selectClasssList() {
        // 构造查询所有图书的sql查询语句
        String sql = "select * from class";
        return selectClasssList(sql);// 返回图书列表
    }

    public static List<Class> selectClasssList(String field, String value) {
        // 构造默认的sql查询语句
        String sql = "select * from class";
        if ((value != null & value.length() > 0) && field != null) {
            // 构造按照字符属性查询图书的sql查询语句，采用模糊查询
            sql = "select * from class where " + field + " like '%" + value + "%'";
        }
        return selectClasssList(sql);// 返回图书列表
    }

    public static List<Class> selectClasssList(String field, int value) {
        // 构造默认的sql查询语句
        String sql = "select * from class";
        if (field != null && value != 0) {
            // 构造按照整型属性查询图书的sql查询语句，采用区间查询
            sql = "select * from class where " + field + ">="+value;
        }
        return selectClasssList(sql);// 返回图书列表
    }





    /** 成员方法8：添加 */
    public static int insertClasss(Class Classs) {
        if (Classs != null) {
            // 获取图书信息
            String courseno = Classs.getCourseno();
            String tearchername = Classs.getTearchername();
            String classno = Classs.getClassno();
            String coursename= Classs.getCoursename();
            int students = Classs.getStudents();
            String tearchno = Classs.getTearcherno();
            // 构造添加图书的sql更新语句
            String sql = "insert into class values('" + classno + "','" + courseno + "','" + coursename
                    + "','" + tearchno + "','"  + tearchername + "'," + students +")";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法9：修改指定图书信息 */
    public static int updateClasss(Class Classs) {
        if (Classs != null) {
            // 获取图书信息
            String courseno = Classs.getCourseno();
            String tearchername = Classs.getTearchername();
            String classno = Classs.getClassno();
            String coursename= Classs.getCoursename();
            int students = Classs.getStudents();
            String tearchno = Classs.getTearcherno();
            // 构造修改图书的sql更新语句
            String sql = "update class set classno='" + classno + "',courseno='" + courseno
                    + "',coursename='" + coursename + "', tearcherno='" + tearchno
                    + "',tearchername='" + tearchername + "',students=" + students + " where classno='"+classno+"'";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法10：删除指定图书信息 */
    public static int deleteClasss(String id) {
        // 构造删除图书的sql更新语句
        String sql = "delete from class  where calssno='" + id + "'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法11：清空所有图书信息 */
    public static void emptyClasss() {
        // 构造清空图书的sql更新语句
        String sql = "delete from class";
        BaseDao.executeUpdate(sql);// 执行更新语句
    }
}
