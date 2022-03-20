package Model;


import java.util.ArrayList;
import java.util.Arrays;

public class StaffList
{
    private ArrayList<LibraryStaff> staffimport;

    public StaffList()
    {
        staffimport = new ArrayList<LibraryStaff>();
        this.LoadStaff();

    }

    public void LoadStaff()
    {
        LibraryStaff andyjones = new LibraryStaff("Andy Jones", new NormalDate("1997", "02", "10"),
                new Address("245", "Fake", "Street", "", "Pittsburgh", "15206", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(17,232,232,2239), new PhoneNumber(1,219891,234,2342))),
                "test@gmail.com", "ajones", "1234", "Library Staff", "Employed",
                new NormalDate("2020", "11", "15"), 0);
        LibraryStaff tsmith = new LibraryStaff("Ted Smith", new NormalDate("1990", "11" ,"11"), new Address("310", "Newcomber", "Street", "", "Coloumbus", "12434", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(1,345,234,2434))), "tsmith@gmail.com", "tsmith", "4321", "Staff", "Employed", new NormalDate("2012","12", "12"), 0);
LibraryStaff kdoe = new LibraryStaff("Kate Does", new NormalDate("1985","10","24"), new Address("299","Atkin", "Avenue", "Apt 22","Pittsburgh", "15208", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(1, 214,550,4290))), "jdoe@gmail.com", "kdoe", "0000", "Staff", "Employed", new NormalDate("2017","04","01"),0);

        staffimport.add(andyjones);
        staffimport.add(tsmith);
        staffimport.add(kdoe);


    }

    public StaffList(ArrayList<LibraryStaff> staffimport)
    {
        this.staffimport = staffimport;
    }

    public boolean authenticate(String userstring, String userpin)
    {

        for (int i =0; i < staffimport.size(); i++){


            if (userstring.toString().contains(staffimport.get(i).getStaffId()) && userpin.toString().contains(staffimport.get(i).getPin()))
            {
                System.out.println("Works");
                return true;
        }
    }
        System.out.println("Wrong creds");
        return false;
    }
    public ArrayList getStaffimport()
    {
        return staffimport;
    }

    public void setStaffimport(ArrayList staffimport)
    {
        this.staffimport = staffimport;
    }
}