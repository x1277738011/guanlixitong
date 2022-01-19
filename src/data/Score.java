package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entity.score;

public class Score {
    /** 成员方法1：通过编号，获取一个对象 */
    public static score getscoresById(int scoreserno) {
        score scores = null;
        if (scoreserno != 0) {
            // 构造按照图书编号查询图书的sql查询语句
            String sql = "select * from score where score=" + scoreserno + "";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return scores;// 返回图书对象
    }

    /** 成员方法2：通过名，获取一个对象 */
    public static score getscoresByName(String scoresname) {
        score scores = null;
        if (scoresname != null) {
            // 构造按照图书名称查询图书的sql查询语句
            String sql = "select * from score where studentname='" + scoresname + "'";
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            // 处理查询结果
            try {
                if (rs.next()) {
                    // 创建图书对象，保存图书信息
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
                    scores.setCourseno(ChangeString.ISOToGBK(rs.getString("courseno")));;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return scores;// 返回图书对象
    }

    /** 成员方法3：通过sql查询语句，获取对象列表 */
    public static List<score> selectscoresList(String sql) {
        List<score> list = new ArrayList<score>();// 创建列表
        if (sql != null) {
            score scores = null;
            ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
            try {
                while (rs.next()) {
                    // 创建图书对象，保存图书信息
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
        return list;// 返回图书列表
    }

    /** 成员方法4：获取所有对象列表 */
    public static List<score> selectscoresList() {
        // 构造查询所有图书的sql查询语句
        String sql = "select * from score";
        return selectscoresList(sql);// 返回图书列表
    }

    public static List<score> selectscoresList(String field, String value) {
        // 构造默认的sql查询语句
        String sql = "select * from score";
        if ((value != null & value.length() > 0) && field != null) {
            // 构造按照字符属性查询的sql查询语句，采用模糊查询
            sql = "select * from score where " + field + " like '%" + value + "%'";
        }
        return selectscoresList(sql);// 返回列表
    }

    public static List<score> selectscoresList(String field, int value) {
        // 构造默认的sql查询语句
        String sql = "select * from score";
        if (field != null && value != 0) {
            // 构造按照整型属性查询的sql查询语句，采用区间查询
            sql = "select * from score where " + field + "="+value;
        }
        return selectscoresList(sql);// 返回列表
    }





    /** 成员方法8：添加 */
    public static int insertscores(score scores) {
        if (scores != null) {
            // 获取信息
            int studentno = scores.getStudentno();
            String studentname = scores.getStudentname();
            String courseno = scores.getCourseno();
            String coursename= scores.getCoursename();
            int scor = scores.getScore();
            String classno = scores.getTearchername();
            int fillscore=scores.getFillscore();
            // 构造添加的sql更新语句
            String sql = "insert into score values(" + studentno + ",'" + studentname + "','" + courseno
                    + "','" + coursename + "',"  + scor + ",'" + classno +"',"+ fillscore +")";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法9：修改指定 */
    public static int updatescores(score scores) {
        if (scores != null) {
            // 获取信息
            int studentno = scores.getStudentno();
            String studentname = scores.getStudentname();
            String courseno = scores.getCourseno();
            String coursename= scores.getCoursename();
            int scor = scores.getScore();
            String classno = scores.getTearchername();
            int fillscore=scores.getFillscore();
            // 构造修改的sql更新语句
            String sql = "update score set studentno="+studentno + ",studentname='"+ studentname
                    + "',courseno='" + courseno + "',coursename='" + coursename + "',score="+scor + ",classno='" + classno + "',fillscore="
                    +fillscore+ " where studentno="+studentno+" and courseno='"+courseno+"'";
            return BaseDao.executeUpdate(sql);// 执行更新语句
        } else {
            return -1;
        }
    }

    /** 成员方法10：删除指定图书信息 */
    public static int deletescores(int no,String id) {
        // 构造删除的sql更新语句
        String sql = "delete from score  where studentno=" + no + " and courseno='"+id+"'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法11：清空所有图书信息 */
    public static void emptyscores() {
        // 构造清空的sql更新语句
        String sql = "delete from score";
        BaseDao.executeUpdate(sql);// 执行更新语句
    }
}

