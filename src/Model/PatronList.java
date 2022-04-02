package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class PatronList
{

    private ArrayList<Patron> patronimport;


    public PatronList()
    {
        patronimport = new ArrayList<>();


    }

    public void saveToFilePatron(ArrayList<Patron> patron)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("patronimport.json"));
            gson.toJson(patron, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    public ArrayList<Patron> LoadPatron(Patron temp)
    {
        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());


            for (int i = 0; i <= users.size() - 1; i++)
            {
                patronimport.add(users.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.patronimport.add(new Patron(temp.getName(), new NormalDate(temp.getDateofBirth().getYear(), temp.getDateofBirth().getMonth(), temp.getDateofBirth().getDay()), new Address(temp.getAddress().getNumber(), temp.getAddress().getName(), temp.getAddress().getType(), temp.getAddress().getCity(), temp.getAddress().getState(),
                temp.getAddress().getZip(), temp.getAddress().getSecondAdd()), new ArrayList<PhoneNumber>(
                        temp.getPhoneNumber()), temp.getEmail(),
                temp.getPatronCardNum(), temp.getAge()));

        saveToFilePatron(this.patronimport);
        System.out.println(temp);

        return patronimport;


    }

    public boolean verifyEmail(String email)
    {
        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getEmail().equals(email))
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
           Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

           // convert JSON array to list of users
           ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
           {
           }.getType());
           for (int i = 0; i < users.size(); i++)
           {


               if (users.get(i).getEmail().equals(search))
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

    public boolean foundCard(String search){
        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getPatronCardNum().equals(search))
                {
                    System.out.println("Card Exists EXISTS!");
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
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {

                {

                    if (users.get(i).getPhoneNumber().toString().contains(search))
                    {
                        System.out.println("Phone EXISTS!");
                        return true;
                    }
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
    public Person searchEmail(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getEmail().equals(search))
                {
                    System.out.println("EMAIL EXISTS!");
                    return users.get(i);
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
    public String searchCard(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {


                if (users.get(i).getPatronCardNum().equals(search))
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

        System.out.println("No Result, Name");
        return null;
    }
    public String searchPhone(String search){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
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
    public PatronList(ArrayList<Patron> patronimport)
    {
        this.patronimport = patronimport;
    }

    public ArrayList<Patron> getPatronimport()
    {
        return patronimport;
    }

    public void setPatronimport(ArrayList<Patron> patronimport)
    {
        this.patronimport = patronimport;
    }
}
