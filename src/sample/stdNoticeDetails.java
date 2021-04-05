package sample;

public class stdNoticeDetails extends noticeController {
    String notice_No;
    String notice_Title;
    String notice_Date;
    String action;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public stdNoticeDetails(String notice_No, String notice_Title, String notice_Date) {
        this.notice_No = notice_No;
        this.notice_Title = notice_Title;
        this.notice_Date = notice_Date;
        this.action = action;
    }
}
