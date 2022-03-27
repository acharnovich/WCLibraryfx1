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
