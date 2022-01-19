package entity;

public class students {
    private int studentno;
    private String studentname;
    private String sex;
    private int age;
    private String departmentname;
    private int getcredits;
    public int getStudentno() {// »ñÈ¡½èÔÄºÅ
        return studentno;
    }

    public void setStudentno(int studentno) {// ÉèÖÃ½èÔÄºÅ
        this.studentno = studentno;
    }

    public String getStudentnme() {// »ñÈ¡Í¼Êé±àºÅ
        return studentname;
    }

    public void setStudentnme(String studentname) {// ÉèÖÃÍ¼Êé±àºÅ
        this.studentname = studentname;
    }

    public String getDepartmentname() {// »ñÈ¡Í¼Êé±àºÅ
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {// ÉèÖÃÍ¼Êé±àºÅ
        this.departmentname = departmentname;
    }

    public String getSex() {// »ñÈ¡¶ÁÕß±àºÅ
        return sex;
    }

    public void setSex(String sex) {// ÉèÖÃ¶ÁÕß±àºÅ
        this.sex = sex;
    }
    public int getGetcredits() {
        return getcredits;
    }

    public void setGetcredits(int getcredits) {// ÉèÖÃÍ¼Êé±àºÅ
        this.getcredits = getcredits;
    }

    public int getAge() {// »ñÈ¡½èÔÄºÅ
        return age;
    }

    public void setAge(int age) {// ÉèÖÃ½èÔÄºÅ
        this.age = age;
    }
}
