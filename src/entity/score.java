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

    public String getTearchername() {// ��ȡͼ����
        return classno;
    }

    public void setTearchername(String classno) {// ����ͼ����
        this.classno = classno;
    }

    public String getStudentname() {// ��ȡͼ����
        return studentname;
    }

    public void setStudentname(String studentname) {// ����ͼ����
        this.studentname = studentname;
    }

    public String getCoursename() {// ��ȡ���߱��
        return coursename;
    }

    public void setCoursename(String coursename) {// ���ö��߱��
        this.coursename = coursename;
    }
    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {// ����ͼ����
        this.courseno= courseno;
    }

    public int getScore() {// ��ȡ��������
        return score;
    }

    public void setScore(int score) {// ���ý�������
        this.score = score;
    }
    public int getStudentno() {// ��ȡ���ĺ�
        return studentno;
    }

    public void setStudentno(int studentno) {// ���ý��ĺ�
        this.studentno = studentno;
    }
}
