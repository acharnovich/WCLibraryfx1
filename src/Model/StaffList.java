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

    public void saveToFileTest(ArrayList<LibraryStaff> staff)
    {

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
        try
        {
            // create Gson instanc

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());

            // print users

            for (int i = 0; i <= users.size(); i++)
            {
                staffimport.add(users.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


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

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("test.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


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

        } catch (Exception ex)
        {
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