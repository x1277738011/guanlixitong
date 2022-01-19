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

    public String gettearcherno() {// 获取借阅号
        return tearcherno;
    }

    public void setTearcherno(String tearcherno) {// 设置借阅号
        this.tearcherno = tearcherno;
    }


    public String getTearchername() {// 获取图书编号
        return tearchername;
    }

    public void setTearchername(String tearchername) {// 设置图书编号
        this.tearchername = tearchername;
    }

    public String getDepartmentname() {// 获取图书编号
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {// 设置图书编号
        this.departmentname = departmentname;
    }

    public String getSex() {// 获取读者编号
        return sex;
    }

    public void setSex(String sex) {// 设置读者编号
        this.sex = sex;
    }
    public String getTitle() {
        return title;
    }

    public void settitle(String title) {// 设置图书编号
        this.title = title;
    }

    public int getage() {// 获取借阅日期
        return age;
    }

    public void setage(int age) {// 设置借阅日期
        this.age = age;
    }
    public int getSalary() {// 获取借阅号
        return salary;
    }

    public void setSalary(int salary) {// 设置借阅号
        this.salary = salary;
    }
}

