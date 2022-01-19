package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.tearchs;

public class Tearchs {
    /** 成员方法1：通过图书编号，获取一个图书对象 */
    public static tearchs gettearchById(String tearcherno) {
        tearchs tearch = null;
        if (tearcherno != null) {
            // 构造按照图书编号查询图书的sql查询语句
            String sql = "select * from tearch where tearcherno='" + tearcherno + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return tearch;// 返回图书对象
    }

    /** 成员方法2：通过图书名，获取一个图书对象 */
    public static tearchs gettearchByName(String tearchname) {
        tearchs tearch = null;
        if (tearchname != null) {
            // 构造按照图书名称查询图书的sql查询语句
            String sql = "select * from tearch where teachername='" + tearchname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return tearch;// 返回图书对象
    }

    /** 成员方法3：通过sql查询语句，获取图书对象列表 */
    public static List<tearchs> selecttearchList(String sql) {
        List<tearchs> list = new ArrayList<tearchs>();// 创建列表
        if (sql != null) {
            tearchs tearch = null;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                while (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return list;// 返回图书列表
    }

    /** 成员方法4：获取所有图书对象列表 */
    public static List<tearchs> selecttearchList() {
        // 构造查询所有图书的sql查询语句
        String sql = "select * from tearch";
        return selecttearchList(sql);// 返回图书列表
    }

    public static List<tearchs> selecttearchList(String field, String value) {
        // 构造默认的sql查询语句
        String sql = "select * from tearch";
        if ((value != null & value.length() > 0) && field != null) {
            // 构造按照字符属性查询图书的sql查询语句，采用模糊查询
            sql = "select * from tearch where " + field + " like '%" + value + "%'";
        }
        return selecttearchList(sql);// 返回图书列表
    }

    public static List<tearchs> selecttearchList(String field, int value) {
        // 构造默认的sql查询语句
        String sql = "select * from tearch";
        if (field != null && value != 0) {
            // 构造按照整型属性查询图书的sql查询语句，采用区间查询
            sql = "select * from tearch where " + field + "="+value;
        }
        return selecttearchList(sql);// 返回图书列表
    }





    /** 成员方法8：添加新图书 */
    public static int inserttearch(tearchs tearch) {
        if (tearch != null) {
            // 获取图书信息
            String tearcherno = tearch.gettearcherno();
            String tearchername = tearch.getTearchername();
            String sex = tearch.getSex();
            String title= tearch.getTitle();
            int salar = tearch.getSalary();
            String departmentname = tearch.getDepartmentname();
            int age = tearch.getage();
            // 构造添加图书的sql更新语句
            String sql = "insert into tearch values('" + tearcherno + "','" + tearchername + "','" + sex
                    + "'," + age + ",'" + departmentname + "','" + title + "',"  + salar + ")";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法9：修改指定图书信息 */
    public static int updatetearch(tearchs tearch) {
        if (tearch != null) {
            // 获取图书信息
            String tearcherno = tearch.gettearcherno();
            String tearchername = tearch.getTearchername();
            String sex = tearch.getSex();
            String title= tearch.getTitle();
            int salar = tearch.getSalary();
            String departmentname = tearch.getDepartmentname();
            int age = tearch.getage();
            // 构造修改图书的sql更新语句
            String sql = "update tearch set tearcherno='" + tearcherno + "',teachername='" + tearchername
                    + "',sex='" + sex + "', age=" + age
                    + ",departmentname='" + departmentname + "',title='" + title + "',salary=" + salar +" where tearcherno='"+tearcherno+"'";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法10：删除指定图书信息 */
    public static int deletetearch(String id) {
        // 构造删除图书的sql更新语句
        String sql = "delete from tearch  where tearcherno='" + id + "'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法11：清空所有图书信息 */
    public static void emptytearch() {
        // 构造清空图书的sql更新语句
        String sql = "delete from tearch";
        BaseDao.executeUpdate(sql);// 执行更新语句
    }
}
