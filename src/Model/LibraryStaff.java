package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryStaff extends Person implements Search
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

        LocalDate parseStart = LocalDate.parse(startDate.toString());

        yearsOfService = LocalDate.now().getYear() - parseStart.getYear();

        return yearsOfService;

    }






    @Override
    public boolean searchByName(String input)
    {


        if (LibraryStaff.super.getName().contains(input))
        {
            System.out.println("Found");
            return true;


        }
        System.out.println("Not Found");
        return false;
    }

    @Override
    public boolean searchByDate(String input)
    {
        if (getStartDate().toString().contains(input))
        {
            System.out.println("Found");
            System.out.println(LibraryStaff.super.toString());
            return true;


        }
        System.out.println("Not Found");
        return false;


    }

    @Override
    public boolean searchByID(String input)
    {
        if (staffId.contains(input))
        {

            System.out.println("Found");

            return true;


        }
        System.out.println("Not Found");
        return false;
    }
}
