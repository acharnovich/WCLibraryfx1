/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The PatronBillList class is used to create an object that represents all the bills currently associated with a patron's
 * account.
 *
 * @version 1.0 2022-04-17
 */
package Model;

import java.util.ArrayList;

public class PatronBillList
{
    String patronCardNum;               // the card number of the Patron
    ArrayList<Bill> bills;              // the bills associated with this Patron's account

    /**
     * This zero-args constructor is used to initialize the PatronBillList object when no parameters are sent to the
     * constructor.
     */
    public PatronBillList()
    {
        patronCardNum = "0000000";
        bills = new ArrayList<Bill>();
    }

    /**
     * This constructor is used when all parameters are sent to the constructor.
     * @param cardInput The card number of the Patron.
     * @param billsInput An ArrayList of Bill objects representing all the bills associated with the Patron's account.
     */
    public PatronBillList(String cardInput, ArrayList<Bill> billsInput)
    {
        patronCardNum = cardInput;
        bills = billsInput;
    }

    // Accessor methods

    public String getPatronCardNum() { return patronCardNum; }
    public ArrayList<Bill> getBills() { return bills; }

    // Mutator methods

    public void setPatronCardNum(String cardInput) { patronCardNum = cardInput; }
    public void setBills(ArrayList<Bill> billsInput) { bills = billsInput; }
}
