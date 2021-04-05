package sample;

public class Exam
{
    String examDate;
    String examTime;
    String exam;

    public Exam(String examDate, String examTime, String exam) {
        this.examDate = examDate;
        this.examTime = examTime;
        this.exam = exam;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}
