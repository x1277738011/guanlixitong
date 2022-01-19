package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Login.Login;

public class User {
    /** 成员方法1：通过用户名和用户密码，获取一个用户对象 */
    public static Login getUser(String name, String pass) {
        Login user = null;
        if (name != null || pass != null) {
            // 构造按照用户名和密码查询用户的sql查询语句
            String sql = "select * from register where id=" + "'" + name + "' and password="
                    + "'" + pass + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                // 处理查询结果
                if (rs.next()) {// 下移结果集指针，判断记录是否存在？
                    user = new Login();// 创建用户对象，并保存用户信息

                    user.setID(rs.getString("id"));
                    user.setPassword(rs.getString("password"));

//					user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//					user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;// 返回用户对象
    }

    /** 成员方法2：通过用户编号，获取一个用户对象 */
    public static Login getUser(int id) {
        Login user = null;
        if (id > 0) {
            // 构造按照用户编号查询用户的sql查询语句
            String sql = "select * from user where id=" + id;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                if (rs.next()) {// 下移结果集指针，判断记录是否存在？
                    user = new Login();// 创建用户对象，并保存用户信息
                    user.setID(rs.getString("id"));
                    user.setPassword(rs.getString("password"));

//					user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//					user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;// 返回用户对象
    }


    /** 成员方法4：查询所有用户对象，并返回用户对象列表 */
    public static List<Login> selectUserList() {
        Login user = null;
        List<Login> list = new ArrayList<Login>();// 创建一个放置用户对象的列表
        // 构造查询所有用户的sql查询语句
        String sql = "select * from register";
        ResultSet rs = BaseDao.executeQuery(sql);// 执行查询操作，并返回结果集
        try {
            while (rs.next()) {
                // 创建用户对象，并保存用户信息
                user = new Login();// 创建用户对象，并保存用户信息
                user.setID(rs.getString("id"));
                user.setPassword(rs.getString("password"));
//
//				user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//				user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));
//

                list.add(user);// 将这个用户对象，添加到用户列表中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;// 返回用户对象列表
    }

    /** 成员方法5：添加新用户 */
    public static int insertUser(Login user) {
        if (user != null) {
            // 获取用户信息

            String id = user.getID();
            String pass = user.getPassword();
            // 构造添加用户的sql更新语句
            String sql = "insert into register values('" + id + "','" + pass
                    + "')";

            return BaseDao.executeUpdate(sql); // 执行更新语句，并返回整数
        } else {
            return -1;
        }
    }

    /** 成员方法6：修改指定用户信息 */
    public static int updateUser(Login user) {
        if (user != null) {
            // 获取用户信息
            String id = user.getID();
            String pass = user.getPassword();
            // 构造修改用户的sql更新语句
            String sql = "update register set password='" + pass
                    + "' where id='"+id+"'";
            return BaseDao.executeUpdate(sql); // 执行更新语句，并返回整数
        } else {
            return -1;
        }
    }

    /** 成员方法7：修改指定用户的密码 */
    public static int updatePass(String id, String pass) {
        if (id != null && pass != null) {
            // 构造按照用户名修改用户密码的sql更新语句
            String sql = "update register set password='" + pass + "'  where id='"+ id +"'";
            return BaseDao.executeUpdate(sql); // 执行更新语句，并返回整数

        } else {
            return -1;
        }
    }

    /** 成员方法8：删除指定id的用户 */
    public static int deleteUser(int id) {
        // 构造删除用户的sql更新语句
        String sql = "delete from register  where id=" + id ;
        return BaseDao.executeUpdate(sql); // 执行更新语句，并返回整数
    }

    /** 成员方法9：清空所有用户信息 */
    public static void emptyUser() {
        // 构造删除所有用户的sql更新语句
        String sql = "delete from register";
        BaseDao.executeUpdate(sql); // 执行更新语句
    }
}
