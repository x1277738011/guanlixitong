package entity;

import java.util.Date;

public class tearchs {
    private String tearcherno;
    private String tearchername;
    private String sex;
    private String departmentname;
    private String title;
    private int age;
    private int salary;

    public String gettearcherno() {// ��ȡ���ĺ�
        return tearcherno;
    }

    public void setTearcherno(String tearcherno) {// ���ý��ĺ�
        this.tearcherno = tearcherno;
    }


    public String getTearchername() {// ��ȡͼ����
        return tearchername;
    }

    public void setTearchername(String tearchername) {// ����ͼ����
        this.tearchername = tearchername;
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
    public String getTitle() {
        return title;
    }

    public void settitle(String title) {// ����ͼ����
        this.title = title;
    }

    public int getage() {// ��ȡ��������
        return age;
    }

    public void setage(int age) {// ���ý�������
        this.age = age;
    }
    public int getSalary() {// ��ȡ���ĺ�
        return salary;
    }

    public void setSalary(int salary) {// ���ý��ĺ�
        this.salary = salary;
    }
}

