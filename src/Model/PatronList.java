package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
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

        this.patronimport.add(new Patron(temp.getName(), new NormalDate(temp.getDateofBirth().getYear(), temp.getDateofBirth().getMonth(), temp.getDateofBirth().getDay()), new Address(temp.getAddress().getNumber(), temp.getAddress().getName(), temp.getAddress().getType(), temp.getAddress().getSecondAdd(), temp.getAddress().getCity(), temp.getAddress().getState(),
                temp.getAddress().getZip()), new ArrayList<PhoneNumber>(
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


                if (users.get(i).getEmail().equalsIgnoreCase(email))
                {

                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

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


               if (users.get(i).getEmail().toLowerCase().contains(search.toLowerCase()))
               {

                   return true;
               }
           }
           // close reader
           reader.close();

       } catch (Exception ex)
       {
           ex.printStackTrace();
       }


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


                if (users.get(i).getPatronCardNum().contains(search))
                {

                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


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

        return false;
    }
    public ObservableList searchEmail(String search){

        ObservableList temp = FXCollections.observableArrayList();

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


                if (users.get(i).getEmail().toLowerCase().contains(search.toLowerCase()))
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
    public ObservableList searchCard(String search){
        ObservableList temp = FXCollections.observableArrayList();
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


                if (users.get(i).getPatronCardNum().contains(search))
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
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of users
            ArrayList<Patron> users = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());
            for (int i = 0; i < users.size(); i++)
            {
                for (int x = 0; x == 0; x++){
                    if (users.get(i).getPhoneNumber().get(x).toString().contains(search))
                    {

                        temp.addAll(users.get(i));

                    }}


            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return temp;
    }

    public ObservableList searchCardExact(String search){

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
                    ObservableList temp = FXCollections.observableArrayList();
                    temp.addAll(users.get(i));
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


        return null;
    }

    public boolean foundCardExact(String search){
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

                    return true;
                }
            }
            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }


        return false;
    }

    public Patron getFromJson(String patronToSearchFor)
    {
        Patron patronToReturn = new Patron();

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronimport.json"));

            // convert JSON array to list of patrons
            ArrayList<Patron> patrons = new Gson().fromJson(reader, new TypeToken<ArrayList<Patron>>()
            {
            }.getType());

            // step through the patrons array
            for (int i = 0; i < patrons.size(); i++)
            {
                // get the patron ID from the current index and assign to String id
                String id = patrons.get(i).getPatronCardNum();

                // if id is the same as patronToSearchFor, return the patron object
                if (id.equals(patronToSearchFor))
                {
                    patronToReturn = patrons.get(i);
                }

            }

        } catch (IOException e)
        {
            e.printStackTrace();

        }

        return patronToReturn;

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
