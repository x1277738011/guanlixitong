package entity;

public class score {
    private String studentname;
    private String courseno;
    private String coursename;
    private int score;
    private String classno;
    private int studentno;
    private int fillscore;

    public int getFillscore() {
        return fillscore;
    }

    public void setFillscore(int fillscore) {
        this.fillscore = fillscore;
    }

    public String getTearchername() {// 获取图书编号
        return classno;
    }

    public void setTearchername(String classno) {// 设置图书编号
        this.classno = classno;
    }

    public String getStudentname() {// 获取图书编号
        return studentname;
    }

    public void setStudentname(String studentname) {// 设置图书编号
        this.studentname = studentname;
    }

    public String getCoursename() {// 获取读者编号
        return coursename;
    }

    public void setCoursename(String coursename) {// 设置读者编号
        this.coursename = coursename;
    }
    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {// 设置图书编号
        this.courseno= courseno;
    }

    public int getScore() {// 获取借阅日期
        return score;
    }

    public void setScore(int score) {// 设置借阅日期
        this.score = score;
    }
    public int getStudentno() {// 获取借阅号
        return studentno;
    }

    public void setStudentno(int studentno) {// 设置借阅号
        this.studentno = studentno;
    }
}
