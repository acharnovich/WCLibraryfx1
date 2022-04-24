/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The PatronCheckoutList class is used to create objects that represent a list of all the checkout transactions associated
 * with a Patron's account. It includes methods to add checkouts, remove checkouts, and get a specific checkout from the list.
 *
 * @version 1.1 2022-04-13
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

    // Mutator methods

    public void setCheckouts(ArrayList<CheckOut> checkoutsInput)
    {
        checkouts = checkoutsInput;
    }

    public int getNumOfCheckouts()
    {
        int size = checkouts.size();
        return size;
    }

}
