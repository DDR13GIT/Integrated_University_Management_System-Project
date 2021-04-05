package sample.admin;

//faculty class:: constructor && getter && setter
public class Faculty {
    String name;
    String department;
    String course_id;
    String contactno;
    String emailadd;
    String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmailadd() {
        return emailadd;
    }

    public void setEmailadd(String emailadd) {
        this.emailadd = emailadd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Faculty(String name, String department, String course_id, String contactno, String emailadd, String password) {
        this.name = name;
        this.department = department;
        this.course_id = course_id;
        this.contactno = contactno;
        this.emailadd = emailadd;
        this.password = password;
    }
}