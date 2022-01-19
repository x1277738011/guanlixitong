package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Login.Login;

public class User {
    /** ��Ա����1��ͨ���û������û����룬��ȡһ���û����� */
    public static Login getUser(String name, String pass) {
        Login user = null;
        if (name != null || pass != null) {
            // ���찴���û����������ѯ�û���sql��ѯ���
            String sql = "select * from register where id=" + "'" + name + "' and password="
                    + "'" + pass + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                // �����ѯ���
                if (rs.next()) {// ���ƽ����ָ�룬�жϼ�¼�Ƿ���ڣ�
                    user = new Login();// �����û����󣬲������û���Ϣ

                    user.setID(rs.getString("id"));
                    user.setPassword(rs.getString("password"));

//					user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//					user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;// �����û�����
    }

    /** ��Ա����2��ͨ���û���ţ���ȡһ���û����� */
    public static Login getUser(int id) {
        Login user = null;
        if (id > 0) {
            // ���찴���û���Ų�ѯ�û���sql��ѯ���
            String sql = "select * from user where id=" + id;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                if (rs.next()) {// ���ƽ����ָ�룬�жϼ�¼�Ƿ���ڣ�
                    user = new Login();// �����û����󣬲������û���Ϣ
                    user.setID(rs.getString("id"));
                    user.setPassword(rs.getString("password"));

//					user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//					user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;// �����û�����
    }


    /** ��Ա����4����ѯ�����û����󣬲������û������б� */
    public static List<Login> selectUserList() {
        Login user = null;
        List<Login> list = new ArrayList<Login>();// ����һ�������û�������б�
        // �����ѯ�����û���sql��ѯ���
        String sql = "select * from register";
        ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ�����������ؽ����
        try {
            while (rs.next()) {
                // �����û����󣬲������û���Ϣ
                user = new Login();// �����û����󣬲������û���Ϣ
                user.setID(rs.getString("id"));
                user.setPassword(rs.getString("password"));
//
//				user.setName(ChangeString.ISOToGBK(rs.getString("name")));
//				user.setPass(ChangeString.ISOToGBK(rs.getString("pass")));
//

                list.add(user);// ������û�������ӵ��û��б���
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;// �����û������б�
    }

    /** ��Ա����5��������û� */
    public static int insertUser(Login user) {
        if (user != null) {
            // ��ȡ�û���Ϣ

            String id = user.getID();
            String pass = user.getPassword();
            // ��������û���sql�������
            String sql = "insert into register values('" + id + "','" + pass
                    + "')";

            return BaseDao.executeUpdate(sql); // ִ�и�����䣬����������
        } else {
            return -1;
        }
    }

    /** ��Ա����6���޸�ָ���û���Ϣ */
    public static int updateUser(Login user) {
        if (user != null) {
            // ��ȡ�û���Ϣ
            String id = user.getID();
            String pass = user.getPassword();
            // �����޸��û���sql�������
            String sql = "update register set password='" + pass
                    + "' where id='"+id+"'";
            return BaseDao.executeUpdate(sql); // ִ�и�����䣬����������
        } else {
            return -1;
        }
    }

    /** ��Ա����7���޸�ָ���û������� */
    public static int updatePass(String id, String pass) {
        if (id != null && pass != null) {
            // ���찴���û����޸��û������sql�������
            String sql = "update register set password='" + pass + "'  where id='"+ id +"'";
            return BaseDao.executeUpdate(sql); // ִ�и�����䣬����������

        } else {
            return -1;
        }
    }

    /** ��Ա����8��ɾ��ָ��id���û� */
    public static int deleteUser(int id) {
        // ����ɾ���û���sql�������
        String sql = "delete from register  where id=" + id ;
        return BaseDao.executeUpdate(sql); // ִ�и�����䣬����������
    }

    /** ��Ա����9����������û���Ϣ */
    public static void emptyUser() {
        // ����ɾ�������û���sql�������
        String sql = "delete from register";
        BaseDao.executeUpdate(sql); // ִ�и������
    }
}
