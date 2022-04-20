package Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Patron extends Person
{
    private String patronCardNum;
    //PatronBillList billList; wil be developed in Sprint #3
//PatronCheckoutList checkoutList; To be developed in sprint 4 and 5
    private int age;
    public Patron()
    {
        super();
        this.patronCardNum = "00000";
        this.age = 0;
    }

    public Patron(String name, NormalDate dateofBirth, Address address, ArrayList<PhoneNumber> phoneNumber, String email, String patronCardNum, int age)
    {
        super(name, dateofBirth, address, phoneNumber, email);
        this.patronCardNum = patronCardNum;
        setAge(getYears());

    }


    public String getPatronCardNum()
    {
        return patronCardNum;
    }

    public void setPatronCardNum(String patronCardNum)
    {

        this.patronCardNum = patronCardNum;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Patron Account Information:\n" +
                "Patron Card Number'" + patronCardNum + '\'' +
                ", Age:" + age +
                '}';
    }

    @Override
    public int getYears()
    {
        if(getDateofBirth().getMonth().length() != 2 && getDateofBirth().getDay().length() != 2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getDateofBirth().getYear() + "-" +"0" +getDateofBirth().getMonth() +"-"+ "0"+ getDateofBirth().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}

        if(getDateofBirth().getMonth().length() != 2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getDateofBirth().getYear() + "-" +"0"+getDateofBirth().getMonth() +"-"+ getDateofBirth().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}

        if(getDateofBirth().getDay().length() !=2){

            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parseStart = LocalDate.parse(getDateofBirth().getYear() + "-" +  getDateofBirth().getMonth() +"-"+ "0" +getDateofBirth().getDay());
            LocalDate localDate = LocalDate.now();
            return Period.between(parseStart, localDate).getYears();}
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parseStart = LocalDate.parse(getDateofBirth().getYear() + "-" + getDateofBirth().getMonth() +"-"+ getDateofBirth().getDay());
        LocalDate localDate = LocalDate.now();
        return Period.between(parseStart, localDate).getYears();
    }
    //TBD in sprint 2
   public Patron changePatronDetails()
   {
       return null;
   }
   //TBD Sprint 2
   public void issueNewCard(){}

    //below are search methods for searching. Will be developed in sprint 3

}
