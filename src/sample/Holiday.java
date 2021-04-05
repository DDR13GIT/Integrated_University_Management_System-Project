package sample;

public class Holiday
{
    String holiDate;
    String holiDays;

    public Holiday(String holiDate, String holiDays) {
        this.holiDate = holiDate;
        this.holiDays = holiDays;
    }

    public String getHoliDate() {
        return holiDate;
    }

    public void setHoliDate(String holiDate) {
        this.holiDate = holiDate;
    }

    public String getHoliDays() {
        return holiDays;
    }

    public void setHoliDays(String holiDays) {
        this.holiDays = holiDays;
    }
}
