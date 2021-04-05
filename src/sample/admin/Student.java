package sample.admin;

public class Student {
    String id;
    String name;
    String semester;
    String year_Sem;
    String email;
    String contact_no;
    int password;
    String father_name;
    String department;
    String program;
    String cgpa;
    String theory_sec;
    String sessional_sec;
    String advisor;


    public Student(String id, String name, String semester, String year_Sem, String email, String contact_no, int password, String father_name, String department, String program, String cgpa, String theory_sec, String sessional_sec, String advisor) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.year_Sem = year_Sem;
        this.email = email;
        this.contact_no = contact_no;
        this.password = password;
        this.father_name = father_name;
        this.department = department;
        this.program = program;
        this.cgpa = cgpa;
        this.theory_sec = theory_sec;
        this.sessional_sec = sessional_sec;
        this.advisor = advisor;
    }

   //get set

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }


    public String getSemester() { return semester; }

    public void setSemester(String semester) { this.semester = semester; }


    public String getYear_Sem() { return year_Sem; }

    public void setYear_Sem(String year_Sem) { this.year_Sem = year_Sem; }


    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }


    public String getContact_no() { return contact_no; }

    public void setContact_no(String contact_no) { this.contact_no = contact_no; }


    public int getPassword() { return password; }

    public void setPassword(int password) { this.password = password; }


    public String getFather_name() { return father_name; }

    public void setFather_name(String father_name) { this.father_name = father_name; }


    public String getDepartment() { return department; }

    public void setDepartment(String department) { this.department = department; }


    public String getProgram() { return program; }

    public void setProgram(String program) { this.program = program; }


    public String getCgpa() { return cgpa; }

    public void setCgpa(String cgpa) {this.cgpa = cgpa; }


    public String getTheory_sec() { return theory_sec; }

    public void setTheory_sec(String theory_sec) { this.theory_sec = theory_sec; }


    public String getSessional_sec() { return sessional_sec; }

    public void setSessional_sec(String sessional_sec) { this.sessional_sec = sessional_sec; }


    public String getAdvisor() { return advisor; }

    public void setAdvisor(String advisor) { this.advisor = advisor; }

}
