package entity;

public class Department {
    private String departmentno;
    private String departmentname;
    private String principal;
    public String getDepartmentno() {// 获取图书的编号
        return departmentno;
    }


    public void setId(String departmentno) {// 设置图书的编号
        this.departmentno = departmentno;
    }


    public String getdepartmentname() {// 获取图书的名称
        return departmentname;
    }

    public void setName(String departmentname) {// 设置图书的名称
        this.departmentname = departmentname;
    }

    public String getPrincipal() {// 获取图书的类型
        return principal;
    }

    public void setType(String principal) {// 设置图书的类型
        this.principal = principal;
    }
}
