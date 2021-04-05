package sample.admin;

public class courseDetails {
    String course_name;
    String course_code;
    String course_credit;
    String department;
    String year_sem;

    public courseDetails(String course_name, String course_code, String course_credit, String department, String year_sem) {
        this.course_name = course_name;
        this.course_code = course_code;
        this.course_credit = course_credit;
        this.department = department;
        this.year_sem = year_sem;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getCourse_credit() {
        return course_credit;
    }

    public void setCourse_credit(String course_credit) {
        this.course_credit = course_credit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear_sem() {
        return year_sem;
    }

    public void setYear_sem(String year_sem) {
        this.year_sem = year_sem;
    }
}
