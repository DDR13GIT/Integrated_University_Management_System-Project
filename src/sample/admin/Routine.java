package sample.admin;

public class Routine
{
    String dept;
    String semester;
    String section;
    String link;

    public Routine(String dept, String semester, String section, String link) {
        this.dept = dept;
        this.semester = semester;
        this.section = section;
        this.link = link;
    }

    public Routine(String department) {
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
