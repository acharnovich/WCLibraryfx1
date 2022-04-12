/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The CheckOut class is used to create objects that represent a checkout transaction for a specific item,
 * on a specific date, by a specific patron. It has a method for calculating due dates.
 *
 * @version 1.0 2022-04-01
 */

package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class CheckOut
{
    int itemID;               // the item ID that has been checked out
    int patronID;             // the library card number of the patron that checked this item out
    NormalDate dateOut;       // the date the item was checked out
    NormalDate dueDate;       // the due date of the item

    /**
     * This zero-args constructor is used when no parameters are sent to the constructor.
     */
    public CheckOut()
    {
        itemID = 0000000;
        patronID = 0000000;
        dateOut = new NormalDate();
        dueDate = new NormalDate();
    }

    /**
     * This constructor is used when the item ID, patron ID, and date checked out are sent to the constructor.
     * @param idInput The item ID number of the item checked out.
     * @param patronIDInput The patron library card number of the patron that checked out the item.
     * @param dateInput The date the item was checked out.
     */
    public CheckOut(int idInput, int patronIDInput, NormalDate dateInput)
    {
        itemID = idInput;
        patronID = patronIDInput;
        dateOut = dateInput;
        dueDate = calculateDueDate(dateOut);
    }

    /**
     * The calculateDueDate method takes the date an Item has been checked out, adds three weeks to the due date, and then
     * takes the due date and creates a NormalDate object for that date. It then returns the NormalDate object.
     * @param dateOutInput The date an Item has been checked out.
     * @return dueDate The NormalDate version of the due date.
     */
    public NormalDate calculateDueDate(NormalDate dateOutInput)
    {
        // Get dateOutInput's toString and assign the value to a String named stringDate
        String stringDate = dateOutInput.toString();

        // Parse stringDate into a LocalDate and assign the value to a LocalDate object named dateOutLocal
        LocalDate dateOutLocal = LocalDate.parse(stringDate);

        // Add 21 days to dateOutLocal and assign the value to a LocalDate object named dueDateLocal
        LocalDate dueDateLocal = dateOutLocal.plusDays(21);

        // Call dueDateLocal's toString and assign the value to a String named stringDueDate
        String stringDueDate = dueDateLocal.toString();

        // Create a String array named brokenUpDueDte and split stringDueDate where dashes appear
        String[] dateSplit = stringDueDate.split("-", 0);

        // Take the year, month, and day from the dateSplit String Array and send them as parameters to create a new
        // NormalDate object named dueDate
        NormalDate dueDate = new NormalDate(dateSplit[0], dateSplit[1], dateSplit[2]);

        return dueDate;
    }

    public void saveToFileCheckouts(ArrayList<CheckOut> checkoutsInput)
    {
        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("checkouts.json"));
            gson.toJson(checkoutsInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }


    public ArrayList<CheckOut> LoadCheckouts(CheckOut temp)
    {
        ArrayList<CheckOut> allCheckouts = new ArrayList<CheckOut>();

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("checkouts.json"));

            // convert JSON array to list of checkout lists
            ArrayList<CheckOut> checkouts = new Gson().fromJson(reader, new TypeToken<ArrayList<CheckOut>>()
            {
            }.getType());



            for (int i = 0; i <= checkouts.size() - 1; i++)
            {
                allCheckouts.add(checkouts.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        allCheckouts.add(new CheckOut(temp.getItemID(), temp.getPatronID(), temp.getDateOut()));

        saveToFileCheckouts(allCheckouts);

        return allCheckouts;


    }

    public CheckOut searchCheckOut(String itemIDInput){


        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("checkouts.json"));

            // convert JSON array to list of checkouts
            ArrayList<CheckOut> checkouts = new Gson().fromJson(reader, new TypeToken<ArrayList<CheckOut>>()
            {
            }.getType());

            // step through the checkouts array
            for (int i = 0; i < checkouts.size(); i++)
            {
                // get the Item ID from the current index, convert to string, and assign to a temporary String named idAsString
                String idAsString = Integer.toString(checkouts.get(i).getItemID());

                // if idAsString is the same as itemIDInput, return the checkout object
                if (idAsString.equals(itemIDInput))
                {
                    return checkouts.get(i);
                }

            }

        } catch (IOException e)
        {
            e.printStackTrace();

        }

        return null;
    }

    // Accessor methods

    public int getItemID() {
        return itemID;
    }

    public int getPatronID() {
        return patronID;
    }

    public NormalDate getDateOut() {
        return dateOut;
    }

    public NormalDate getDueDate() {
        return dueDate;
    }
}
