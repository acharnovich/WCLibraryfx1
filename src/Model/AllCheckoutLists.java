/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The AllCheckoutsList class is used to create an object that manages all patron checkout lists, serializing them to
 * the json file, and deserializing them for use by the application.
 *
 * @version 1.1 2022-04-10
 */

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

    public boolean updateCheckOutList(String patronToSearchFor, CheckOut checkoutInput)
    {

        try
        {
            // check through Patron checkout lists
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronCheckoutLists.json"));

            // convert JSON array to list of PatronCheckoutLists
            ArrayList<PatronCheckoutList> patronLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronCheckoutList>>()
            {
            }.getType());
            for (int i = 0; i < patronLists.size(); i++)
            {
                // get the patron card number at current index in the json, and assign the value to String tempID
                String tempID = patronLists.get(i).getPatronCardNum();

                // if the patron card number you are searching for matches tempID...
                if (patronToSearchFor.equals(tempID))
                {
                    // deserialize data from json for this specific patron's checkout list and create new PatronCheckoutList
                    // object named temp
                    PatronCheckoutList temp = new PatronCheckoutList(patronLists.get(i).getPatronCardNum(),
                                                                            patronLists.get(i).getCheckouts());

                    // get the checkouts from temp and assign the value to tempCheckoutsList
                    ArrayList<CheckOut> tempCheckoutsList = new ArrayList<CheckOut>();
                    tempCheckoutsList = temp.getCheckouts();

                    // add the checkout sent as an argument to the tempCheckoutsList ArrayList
                    tempCheckoutsList.add(checkoutInput);

                    PatronCheckoutList updatedNewList = new PatronCheckoutList(patronLists.get(i).getPatronCardNum(),
                                                                               tempCheckoutsList);

                    // remove the old record
                    patronLists.remove(i);

                    // add the newly updated record
                    patronLists.add(updatedNewList);

                    // send the ArrayList of records to the json to be serialized
                    saveToFilePatronCheckouts(patronLists);
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

    public boolean removeFromCheckOutList(String patronToSearchFor, String checkoutInput)
    {

        try
        {
            // check through Patron checkout lists
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronCheckoutLists.json"));

            // convert JSON array to list of PatronCheckoutLists
            ArrayList<PatronCheckoutList> patronLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronCheckoutList>>()
            {
            }.getType());
            for (int i = 0; i < patronLists.size(); i++)
            {
                // get the patron card number at current index in the json, and assign the value to String tempID
                String tempID = patronLists.get(i).getPatronCardNum();

                // if the patron card number you are searching for matches tempID...
                if (patronToSearchFor.equals(tempID))
                {
                    // deserialize data from json for this specific patron's checkout list and create new PatronCheckoutList
                    // object named temp
                    PatronCheckoutList temp = new PatronCheckoutList(patronLists.get(i).getPatronCardNum(),
                            patronLists.get(i).getCheckouts());

                    // get the checkouts from temp and assign the value to tempCheckoutsList
                    ArrayList<CheckOut> tempCheckoutsList = new ArrayList<CheckOut>();
                    tempCheckoutsList = temp.getCheckouts();

                    // remove the checkout sent as an argument to the tempCheckoutsList ArrayList
                    tempCheckoutsList.remove(checkoutInput);

                    PatronCheckoutList updatedNewList = new PatronCheckoutList(patronLists.get(i).getPatronCardNum(),
                            tempCheckoutsList);

                    // remove the old record
                    patronLists.remove(i);

                    // add the newly updated record
                    patronLists.add(updatedNewList);

                    // send the ArrayList of records to the json to be serialized
                    saveToFilePatronCheckouts(patronLists);
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
}
