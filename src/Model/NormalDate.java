package Model;

import java.time.LocalDate;
import java.time.Period;

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

    public boolean verifyDate(int year, int month, int day){
        LocalDate parseStart = LocalDate.parse(getYear() + "-" + getMonth() + "-" + getDay());
        LocalDate localDate = LocalDate.now();
if(parseStart.isAfter(localDate)){
    System.out.println("DATE IS IN THE FUTURE");
    return true;

    }
        System.out.println("FALSE");
return false;
}}
