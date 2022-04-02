/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The PatronCheckoutList class is used to create objects that represent a list of all the checkout transactions associated
 * with a Patron's account. It includes methods to add checkouts, remove checkouts, and get a specific checkout from the list.
 *
 * @version 1.0 2022-04-01
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

public class PatronCheckoutList
{
    String patronCardNum;                 // the patron's library card number
    ArrayList<CheckOut> checkouts;     // a list of all current check out transactions for this patron

    /**
     * This zero-args constructor is used to set the attributes of PatronCheckoutList to null values.
     */
    public PatronCheckoutList()
    {
        patronCardNum = "0000000";
        checkouts = new ArrayList<CheckOut>();
    }

    /**
     * This constructor is used to initialize PatronCheckoutList when all parameters are sent to the constructor.
     * @param cardInput The patron's library card number.
     * @param checkoutsInput The list of items currently checked out to the Patron.
     */
    public PatronCheckoutList(String cardInput, ArrayList<CheckOut> checkoutsInput)
    {
        patronCardNum = cardInput;
        checkouts = checkoutsInput;
    }

    // Accessor methods

    public String getPatronCardNum()
    {
        return patronCardNum;
    }

    public ArrayList<CheckOut> getCheckouts()
    {
        return checkouts;
    }

    /**
     * The addCheckout method adds a CheckOut to the Patron's checkouts ArrayList.
     * @param checkoutInput The CheckOut to be added to the ArrayList.
     */
    public void addCheckout(CheckOut checkoutInput)
    {
        checkouts.add(checkoutInput);
    }

    /**
     * The addCheckout method adds a CheckOut to the Patron's checkouts ArrayList.
     * @param checkoutInput The CheckOut to be removed from the ArrayList.
     */
    public void removeCheckout(CheckOut checkoutInput)
    {
        checkouts.remove(checkoutInput);
    }

    /**
     * The getFromList method is used to get one CheckOut from the checkouts ArrayList.
     * @param indexInput The index in the ArrayList of the CheckOut to be retrieved.
     * @return The CheckOut from the ArrayList.
     */
    public CheckOut getFromList(int indexInput)
    {
        return checkouts.get(indexInput);
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

        ArrayList<PatronCheckoutList> readFromJson = new ArrayList<PatronCheckoutList>();

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronCheckoutLists.json"));

            // convert JSON array to list of patron checkout lists
            ArrayList<PatronCheckoutList> lists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronCheckoutList>>()
            {
            }.getType());


            for (int i = 0; i <= lists.size() - 1; i++)
            {
                readFromJson.add(lists.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        readFromJson.add(new PatronCheckoutList(temp.getPatronCardNum(), temp.getCheckouts()));

        saveToFilePatronCheckouts(readFromJson);

        return readFromJson;


    }

}
