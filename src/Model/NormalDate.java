package Model;

public class NormalDate
{
    private String month;
    private String day;
    private String year;

    public NormalDate()
    {
        this.month = "00";
        this.day = "00";
        this.year = "0000";
    }

    public NormalDate(String year, String month, String day)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getMonth()
    {
        return month;
    }

    public void setMonth(String month)
    {
        this.month = month;
    }

    public String getDay()
    {
        return day;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    @Override
    public String toString()
    {
        return  year +
                "-" + month +
                "-" + day;
    }
}
