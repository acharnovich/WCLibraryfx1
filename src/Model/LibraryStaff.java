package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryStaff extends Person
{
    private String staffId;
    private String pin;
    private String position;
    private String status;
    private NormalDate startDate;
    private int yearsOfService;

    public LibraryStaff()
    {
        super();
        this.staffId = "jdoe";
        this.pin = "1234";
        this.position = "";
        this.status = "";
        this.startDate = new NormalDate();
        this.yearsOfService = 0;
    }

    public LibraryStaff(String name, NormalDate dateofBirth, Address address, ArrayList<PhoneNumber> phoneNumber, String email, String staffId, String pin, String position, String status, NormalDate startDate, int yearsOfService)
    {
        super(name, dateofBirth, address, phoneNumber, email);
        this.staffId = staffId;
        this.pin = pin;
        this.position = position;
        this.status = status;
        this.startDate = startDate;
        setYearsOfService(getYears());
    }

    public String getStaffId()
    {
        return staffId;
    }

    public void setStaffId(String staffId)
    {
        this.staffId = staffId;
    }

    public String getPin()
    {
        return pin;
    }

    public void setPin(String pin)
    {
        this.pin = pin;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public NormalDate getStartDate()
    {
        return startDate;
    }

    public void setStartDate(NormalDate startDate)
    {
        this.startDate = startDate;
    }

    public int getYearsOfService()
    {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService)
    {
        this.yearsOfService = yearsOfService;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n" + "===Staff File===\n" +
                "Staff ID: " + staffId + "\n" +
                "PIN: ****" + "\nPosition: " + position +
                "\nStatus: " + status + "\nStart Date: " + startDate +
                "\nYears of Service: " + yearsOfService;
    }

    @Override
    public int getYears()
    {
        if(getStartDate().getMonth().length() != 2 && getStartDate().getDay().length() != 2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getStartDate().getYear() + "-" +"0" +getStartDate().getMonth() +"-"+ "0"+ getStartDate().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}

        if(getStartDate().getMonth().length() != 2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getStartDate().getYear() + "-" +"0"+getStartDate().getMonth() +"-"+ getStartDate().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}

        if(getStartDate().getDay().length() !=2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getStartDate().getYear() + "-" +  getStartDate().getMonth() +"-"+ "0" +getStartDate().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStart = LocalDate.parse(getStartDate().getYear() + "-" + getStartDate().getMonth() +"-"+ getStartDate().getDay());
        LocalDate localDate = LocalDate.now();
        return Period.between(parseStart, localDate).getYears();


    }







}
