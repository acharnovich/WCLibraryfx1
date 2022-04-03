package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class AllCheckoutLists
{
    ArrayList<PatronCheckoutList> allCheckoutLists;           // all of the patron checkout lists stored in an ArrayList

    /***
     * This zero-args constructor is used when an AllCheckoutsList object is created without sending any parameters.
     */
    public AllCheckoutLists()
    {
        allCheckoutLists = new ArrayList<PatronCheckoutList>();
    }

    /**
     * This constructor is used when an AllCheckoutsList object is created with all parameters sent.
     * @param listsInput An ArrayList of PatronCheckoutList objects.
     */
    public AllCheckoutLists(ArrayList<PatronCheckoutList> listsInput)
    {
        allCheckoutLists = listsInput;
    }


    public void saveToFilePatronCheckouts(ArrayList<PatronCheckoutList> checkoutListsInput)
    {
        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("patronCheckoutLists.json"));
            gson.toJson(checkoutListsInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }


    public ArrayList<PatronCheckoutList> LoadList(PatronCheckoutList temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronCheckoutLists.json"));

            // convert JSON array to list of checkout lists
            ArrayList<PatronCheckoutList> lists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronCheckoutList>>()
            {
            }.getType());


            for (int i = 0; i <= lists.size() - 1; i++)
            {
                allCheckoutLists.add(lists.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.allCheckoutLists.add(new PatronCheckoutList(temp.getPatronCardNum(), temp.getCheckouts()));

        saveToFilePatronCheckouts(this.allCheckoutLists);

        return allCheckoutLists;


    }
}
