package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.score;

public class Fillscore {
    /** ��Ա����1��ͨ����ţ���ȡһ������ */
    public static score getscoresById(int scoreserno) {
        score scores = null;
        if (scoreserno != 0) {
            // ���찴��ͼ���Ų�ѯͼ���sql��ѯ���
            String sql = "select * from fill where score=" + scoreserno + "";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    scores = new score();
                    scores.setStudentno(rs.getInt("studentno"));
                    scores.setStudentname(rs.getString("studentname"));
                    scores.setCoursename(rs.getString("coursename"));
                    scores.setCourseno(rs.getString("courseno"));
                    scores.setScore(rs.getInt("score"));
                    scores.setTearchername(rs.getString("classno"));
                    scores.setFillscore(rs.getInt("fillscore"));
                    scores.setStudentname(ChangeString.ISOToGBK(rs.getString("studentname")));
                    scores.setTearchername(ChangeString.ISOToGBK(rs.getString("classno")));
                    scores.setCoursename(ChangeString.ISOToGBK(rs.getString("coursename")));
                    scores.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return scores;// ����ͼ�����
    }

    /** ��Ա����2��ͨ��������ȡһ������ */
    public static score getscoresByName(String scoresname) {
        score scores = null;
        if (scoresname != null) {
            // ���찴��ͼ�����Ʋ�ѯͼ���sql��ѯ���
            String sql = "select * from fill where studentname='" + scoresname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            // �����ѯ���
            try {
                if (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    scores = new score();
                    scores.setStudentno(rs.getInt("studentno"));
                    scores.setStudentname(rs.getString("studentname"));
                    scores.setCoursename(rs.getString("coursename"));
                    scores.setCourseno(rs.getString("courseno"));
                    scores.setScore(rs.getInt("score"));
                    scores.setTearchername(rs.getString("tearchname"));
                    scores.setFillscore(rs.getInt("fillscore"));
                    scores.setStudentname(ChangeString.ISOToGBK(rs.getString("studentname")));
                    scores.setTearchername(ChangeString.ISOToGBK(rs.getString("tearchname")));
                    scores.setCoursename(ChangeString.ISOToGBK(rs.getString("coursename")));
                    scores.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return scores;// ����ͼ�����
    }

    /** ��Ա����3��ͨ��sql��ѯ��䣬��ȡ�����б� */
    public static List<score> selectscoresList(String sql) {
        List<score> list = new ArrayList<score>();// �����б�
        if (sql != null) {
            score scores = null;
            ResultSet rs = BaseDao.executeQuery(sql);// ִ�в�ѯ��䣬�����ؽ����
            try {
                while (rs.next()) {
                    // ����ͼ����󣬱���ͼ����Ϣ
                    scores = new score();
                    scores.setStudentno(rs.getInt("studentno"));
                    scores.setStudentname(rs.getString("studentname"));
                    scores.setCoursename(rs.getString("coursename"));
                    scores.setCourseno(rs.getString("courseno"));
                    scores.setScore(rs.getInt("score"));
                    scores.setFillscore(rs.getInt("fillscore"));
                    scores.setTearchername(rs.getString("classno"));
                    list.add(scores);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;// ����ͼ���б�
    }

    /** ��Ա����4����ȡ���ж����б� */
    public static List<score> selectscoresList() {
        // �����ѯ����ͼ���sql��ѯ���
        String sql = "select * from fill";
        return selectscoresList(sql);// ����ͼ���б�
    }

    public static List<score> selectscoresList(String field, String value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from fill";
        if ((value != null & value.length() > 0) && field != null) {
            // ���찴���ַ����Բ�ѯͼ���sql��ѯ��䣬����ģ����ѯ
            sql = "select * from fill where " + field + " like '%" + value + "%'";
        }
        return selectscoresList(sql);// ����ͼ���б�
    }

    public static List<score> selectscoresList(String field, int value) {
        // ����Ĭ�ϵ�sql��ѯ���
        String sql = "select * from fill";
        if (field != null && value != 0) {
            // ���찴���������Բ�ѯͼ���sql��ѯ��䣬���������ѯ
            sql = "select * from fill where " + field + "="+value;
        }
        return selectscoresList(sql);// ����ͼ���б�
    }





    /** ��Ա����8����� */
    public static int insertscores(score scores) {
        if (scores != null) {
            // ��ȡͼ����Ϣ
            int studentno = scores.getStudentno();
            String studentname = scores.getStudentname();
            String courseno = scores.getCourseno();
            String coursename= scores.getCoursename();
            int scor = scores.getScore();
            String tearchname = scores.getTearchername();
            int fillscore=scores.getFillscore();
            // �������ͼ���sql�������
            String sql = "insert into fill values(" + studentno + ",'" + studentname + "','" + courseno
                    + "','" + coursename + "',"  + scor + ",'" + tearchname +"',"+ fillscore +")";
            return BaseDao.executeUpdate(sql);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����9���޸�ָ��ͼ����Ϣ */
    public static int updatescores(score scores) {
        if (scores != null) {
            // ��ȡͼ����Ϣ
            int studentno = scores.getStudentno();
            String studentname = scores.getStudentname();
            String courseno = scores.getCourseno();
            String coursename= scores.getCoursename();
            int scor = scores.getScore();
            String tearchname = scores.getTearchername();
            int fillscore=scores.getFillscore();
            // �����޸�ͼ���sql�������
            String sql = "update fill set studentno="+studentno + ",studentname='"+ studentname
                    + "',courseno='" + courseno + "',coursename='" + coursename + "',score="+scor + ",classno='" + tearchname + "',fillscore="
                    +fillscore+ " where studentno="+studentno+" and courseno='"+courseno+"';";
            String sq="update score set studentno="+studentno + ",studentname='"+ studentname
                    + "',courseno='" + courseno + "',coursename='" + coursename + "',score="+scor + ",classno='" + tearchname + "',fillscore="
                    +fillscore+ " where studentno="+studentno+" and courseno='"+courseno+"';";
            return BaseDao.executeUpdate(sql)-1+BaseDao.executeUpdate(sq);// ִ�и������
        } else {
            return -1;
        }
    }

    /** ��Ա����10��ɾ��ָ����Ϣ */
    public static int deletescores(int no,String id) {
        // ����ɾ��ͼ���sql�������
        String sql = "delete from fill  where studentno=" + no + " and courseno='"+id+"'";
        return BaseDao.executeUpdate(sql);// ִ�и������
    }

    /** ��Ա����11�����������Ϣ */
    public static void emptyscores() {
        // �������ͼ���sql�������
        String sql = "delete from fill";
        BaseDao.executeUpdate(sql);// ִ�и������
    }
    /** �����±�*/
    public static void creat(){
        String sql="create table fill (select * from score where score<60 and fillscore=0)";
        BaseDao.executeUpdate(sql);
    }
    public static void drop(){
        String sql="drop table fill";
        BaseDao.executeUpdate(sql);
    }
}
