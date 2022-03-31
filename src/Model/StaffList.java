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

    public void saveToFileStaff(ArrayList<LibraryStaff> staff)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("staffimport.json"));
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
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());


            for (int i = 0; i <= users.size() - 1; i++)
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
                temp.getAddress().getZip(), temp.getAddress().getSecondAdd()), new ArrayList<>(Arrays.asList(temp.getPhoneNumber().toArray(new PhoneNumber[0]))), temp.getEmail(),
                temp.getStaffId(), temp.getPin(), temp.getPosition(), temp.getStatus(), new NormalDate(temp.getStartDate().getYear(), temp.getStartDate().getMonth(), temp.getStartDate().getDay()), temp.getYearsOfService()));

        saveToFileStaff(this.staffimport);

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
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

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
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Wrong creds");
        return false;
    }

    public boolean foundEmail(String search){
        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getEmail().contains(search))
                {
                    System.out.println("EMAIL EXISTS!");
                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Email Does Not Exist!");
        return false;
    }

    public boolean foundUserID(String search){
        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getStaffId().contains(search))
                {
                    System.out.println("Name EXISTS!");
                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Name Does Not Exist!");
        return false;
    }

    public boolean foundPhone(String search){
        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getPhoneNumber().toString().contains(search))
                {
                    System.out.println("Phone EXISTS!");
                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Phone Does Not Exist!");
        return false;
    }
    public String searchEmail(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getEmail().contains(search))
                {
                    System.out.println("EMAIL EXISTS!");
                    return users.get(i).toString();
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("No Result");
        return null;
    }
    public String searchUserID(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getStaffId().contains(search))
                {
                    System.out.println("EMAIL EXISTS!");
                    return users.get(i).toString();
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("No Result");
        return null;
    }
    public String searchPhone(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("staffimport.json"));

            // convert JSON array to list of users
            ArrayList<LibraryStaff> users = new Gson().fromJson(reader, new TypeToken<ArrayList<LibraryStaff>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getPhoneNumber().toString().contains(search))
                {
                    System.out.println("EMAIL EXISTS!");
                    return users.get(i).toString();
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("No Result");
        return null;
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