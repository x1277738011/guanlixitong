package entity;

public class students {
    private int studentno;
    private String studentname;
    private String sex;
    private int age;
    private String departmentname;
    private int getcredits;
    public int getStudentno() {// ��ȡ���ĺ�
        return studentno;
    }

    public void setStudentno(int studentno) {// ���ý��ĺ�
        this.studentno = studentno;
    }

    public String getStudentnme() {// ��ȡͼ����
        return studentname;
    }

    public void setStudentnme(String studentname) {// ����ͼ����
        this.studentname = studentname;
    }

    public String getDepartmentname() {// ��ȡͼ����
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {// ����ͼ����
        this.departmentname = departmentname;
    }

    public String getSex() {// ��ȡ���߱��
        return sex;
    }

    public void setSex(String sex) {// ���ö��߱��
        this.sex = sex;
    }
    public int getGetcredits() {
        return getcredits;
    }

    public void setGetcredits(int getcredits) {// ����ͼ����
        this.getcredits = getcredits;
    }

    public int getAge() {// ��ȡ���ĺ�
        return age;
    }

    public void setAge(int age) {// ���ý��ĺ�
        this.age = age;
    }
}
