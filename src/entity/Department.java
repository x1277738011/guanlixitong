package entity;

public class Department {
    private String departmentno;
    private String departmentname;
    private String principal;
    public String getDepartmentno() {// ��ȡͼ��ı��
        return departmentno;
    }


    public void setId(String departmentno) {// ����ͼ��ı��
        this.departmentno = departmentno;
    }


    public String getdepartmentname() {// ��ȡͼ�������
        return departmentname;
    }

    public void setName(String departmentname) {// ����ͼ�������
        this.departmentname = departmentname;
    }

    public String getPrincipal() {// ��ȡͼ�������
        return principal;
    }

    public void setType(String principal) {// ����ͼ�������
        this.principal = principal;
    }
}
