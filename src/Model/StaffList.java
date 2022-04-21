package Model;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        this.staffimport.add(new LibraryStaff(temp.getName(), new NormalDate(temp.getDateofBirth().getYear(), temp.getDateofBirth().getMonth(), temp.getDateofBirth().getDay()), new Address(temp.getAddress().getNumber(), temp.getAddress().getName(), temp.getAddress().getType(), temp.getAddress().getSecondAdd(),temp.getAddress().getCity(), temp.getAddress().getState(),
                temp.getAddress().getZip()), new ArrayList<>(Arrays.asList(temp.getPhoneNumber().toArray(new PhoneNumber[0]))), temp.getEmail(),
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


                if (userstring.toString().equalsIgnoreCase(users.get(i).getStaffId()) && userpin.toString().equals(users.get(i).getPin()))
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

    public boolean verifyEmail(String email)
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


                if (users.get(i).getEmail().equalsIgnoreCase(email))
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


                if (users.get(i).getStaffId().toLowerCase().contains(search.toLowerCase()))
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

                    if (users.get(i).getPhoneNumber().equals(search));
                    {
                        System.out.println("Phone EXISTS!");
                        return true;
                    }}

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Phone Does Not Exist!");
        return false;
    }
    public ObservableList searchEmail(String search){

        ObservableList temp = FXCollections.observableArrayList();

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
                    temp.addAll(users.get(i));

                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return temp;
    }
    public ObservableList searchUserID(String search){
        ObservableList temp = FXCollections.observableArrayList();
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


                if (users.get(i).getStaffId().toLowerCase().contains(search.toLowerCase()))
                {
                    temp.addAll(users.get(i));

                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


        return temp;
    }
    public ObservableList searchPhone(String search){
        ObservableList temp = FXCollections.observableArrayList();
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


                for (int x = 0; x == 0; x++){
                    if (users.get(i).getPhoneNumber().get(x).toString().contains(search))
                    {

                        temp.addAll(users.get(i));

                    }}}

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


        return temp;
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