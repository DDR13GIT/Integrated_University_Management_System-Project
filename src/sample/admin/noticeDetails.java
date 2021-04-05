package sample.admin;

public class noticeDetails {
    String notice_No;
    String notice_Title;
    String notice_Date;
    String notice_Link;

    public noticeDetails(String notice_No, String notice_Title, String notice_Date, String notice_Link) {
        this.notice_No = notice_No;
        this.notice_Title = notice_Title;
        this.notice_Date = notice_Date;
        this.notice_Link = notice_Link;
    }

    public String getNotice_No() {
        return notice_No;
    }

    public void setNotice_No(String notice_No) {
        this.notice_No = notice_No;
    }

    public String getNotice_Title() {
        return notice_Title;
    }

    public void setNotice_Title(String notice_Title) {
        this.notice_Title = notice_Title;
    }

    public String getNotice_Date() {
        return notice_Date;
    }

    public void setNotice_Date(String notice_Date) {
        this.notice_Date = notice_Date;
    }

    public String getNotice_Link() {
        return notice_Link;
    }

    public void setNotice_Link(String notice_Link) {
        this.notice_Link = notice_Link;
    }
}
