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

import java.util.ArrayList;

public class PatronCheckoutList
{
    int patronCardNum;                 // the patron's library card number
    ArrayList<CheckOut> checkouts;     // a list of all current check out transactions for this patron

    /**
     * This zero-args constructor is used to set the attributes of PatronCheckoutList to null values.
     */
    public PatronCheckoutList()
    {
        patronCardNum = 0000000;
        checkouts = new ArrayList<CheckOut>();
    }

    /**
     * This constructor is used to initialize PatronCheckoutList when all parameters are sent to the constructor.
     * @param cardInput The patron's library card number.
     * @param checkoutsInput The list of items currently checked out to the Patron.
     */
    public PatronCheckoutList(int cardInput, ArrayList<CheckOut> checkoutsInput)
    {
        patronCardNum = cardInput;
        checkouts = checkoutsInput;
    }

    // Accessor methods

    public int getPatronCardNum()
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





}
