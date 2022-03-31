package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Patron extends Person implements Search
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
                "patronCardNum='" + patronCardNum + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int getYears()
    {
        LocalDate parseStart = LocalDate.parse(getDateofBirth().toString());

        age = LocalDate.now().getYear() - parseStart.getYear();

        return age;
    }
    //TBD in sprint 2
   public Patron changePatronDetails()
   {
       return null;
   }
   //TBD Sprint 2
   public void issueNewCard(){}

    //below are search methods for searching. Will be developed in sprint 3
    @Override
    public boolean searchByName(String input)
    {
        return false;
    }

    @Override
    public boolean searchByDate(String input)
    {
        return false;
    }

    @Override
    public boolean searchByID(String input)
    {
        return false;
    }
}
