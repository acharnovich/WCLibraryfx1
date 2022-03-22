package Model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class StaffList
{
    private ArrayList<LibraryStaff> staffimport;
    private JsonObject jsonObject;
    private Gson gson;
    private LibraryStaff temp;

    public StaffList()
    {
      staffimport = new ArrayList<>();


    }
    public void saveToFileTest(ArrayList<LibraryStaff> staff){

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("test.json"));
            gson.toJson(staff, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }


    public ArrayList<LibraryStaff> LoadStaff(LibraryStaff temp)
    {
        try {
            // create Gson instanc

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>() {}.getType());

            // print users

            for (int i =0; i <= users.size(); i++)
            {
                staffimport.add(users.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

       // LibraryStaff andyjones = new LibraryStaff("Andy Jones", new NormalDate("1997", "02", "10"),
         //       new Address("245", "Fake", "Street", "", "Pittsburgh", "15206", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(17,232,232,2239), new PhoneNumber(1,219891,234,2342))),
           //     "test@gmail.com", "ajones", "1234", "Library Staff", "Employed",
             //   new NormalDate("2020", "11", "15"), 0);
        //LibraryStaff tsmith = new LibraryStaff("Ted Smith", new NormalDate("1990", "11" ,"11"), new Address("310", "Newcomber", "Street", "", "Coloumbus", "12434", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(1,345,234,2434))), "tsmith@gmail.com", "tsmith", "4321", "Staff", "Employed", new NormalDate("2012","12", "12"), 0);
        //LibraryStaff kdoe = new LibraryStaff("Kate Does", new NormalDate("1985","10","24"), new Address("299","Atkin", "Avenue", "Apt 22","Pittsburgh", "15208", "PA"), new ArrayList<>(Arrays.asList(new PhoneNumber(1, 214,550,4290))), "jdoe@gmail.com", "kdoe", "0000", "Staff", "Employed", new NormalDate("2017","04","01"),0);
        //staffimport.add(tsmith);
      //  staffimport.add(andyjones);
       // staffimport.add(kdoe);

        this.staffimport.add(new LibraryStaff(temp.getName(), new NormalDate(temp.getDateofBirth().getYear(), temp.getDateofBirth().getMonth(), temp.getDateofBirth().getDay()), new Address(temp.getAddress().getNumber(), temp.getAddress().getName(), temp.getAddress().getType(), temp.getAddress().getCity(), temp.getAddress().getState(),
                    temp.getAddress().getZip(), temp.getAddress().getSecondAdd()), new ArrayList<>(Arrays.asList(new PhoneNumber())), temp.getEmail(),
                    temp.getStaffId(), temp.getPin(), temp.getPosition(), temp.getStatus(), new NormalDate(temp.getStartDate().getYear(), temp.getStartDate().getMonth(), temp.getStartDate().getDay()), temp.getYearsOfService()));

       saveToFileTest(this.staffimport);

        return staffimport;



    }


    public StaffList(ArrayList<LibraryStaff> staffimport)
    {
        this.staffimport = staffimport;
    }

    public boolean authenticate(String userstring, String userpin)
    {

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>() {}.getType());
            for (int i =0; i < users.size(); i++){


                if (userstring.toString().contains(users.get(i).getStaffId()) && userpin.toString().contains(users.get(i).getPin()))
                {
                    System.out.println("Works");
                    return true;
                }
            }
            // print users
            users.forEach(System.out::println);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
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