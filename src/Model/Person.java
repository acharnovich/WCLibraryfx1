package Model;

import java.util.ArrayList;

public abstract class Person
{
    private String name;
    private NormalDate dateofBirth;
    private Address address;
    private ArrayList<PhoneNumber> phoneNumber;
    private String email;
    public Person()
    {
        this.name = "";
        this.dateofBirth = new NormalDate();
        this.address = new Address();
        this.phoneNumber = new ArrayList<>();
        this.email = "";
    }

    public Person(String name, NormalDate dateofBirth, Address address, ArrayList<PhoneNumber> phoneNumber, String email)
    {
        this.name = name;
        this.dateofBirth = dateofBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public NormalDate getDateofBirth()
    {
        return dateofBirth;
    }

    public void setDateofBirth(NormalDate dateofBirth)
    {
        this.dateofBirth = dateofBirth;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public ArrayList<PhoneNumber> getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(ArrayList<PhoneNumber> phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
      
        return "Personal Account Details:\n" +
                "Name: " + name + "\n" +
                "Birthday: " + dateofBirth + "\n" +
                address.toString() + "\n"   + phoneNumber +
                "\nEmail: " + email + "\n";
    }
    public boolean checkPhoneNumLimit(){
        if (phoneNumber.size() > 2){
            System.out.println("Too many phone Numbers. Limit is two");
            return true;
            }
        return false;
    }
    public abstract int getYears();
}
