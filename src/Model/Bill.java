/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Bill class is used to create a Bill object. A Bill object represents an amount owed by a patron for a bill or
 * late fee. It includes getter, setter, serialization, and deserialization methods.
 *
 * @version 1.0 2022-04-14
 */

package Model;

public class Bill
{
    String patronCardNum;                   // card number of the Patron who was billed
    String itemID;                          // the ID number of the item the Patron was billed for - might be null
    NormalDate dateBilled;                  // reference to a NormalDate object representing the date the bill was created
    double amtBilled;                       // the amount billed to the Patron
    double amtCurrentlyPaid;                // the amount currently paid by the Patron
    String description;                     // a description of the bill - might be null

    /**
     * This zero-args constructor is used to create and initialize a Bill object when no parameters are sent.
     */
    public Bill()
    {
        patronCardNum = "0000000";
        itemID = "0000000";
        dateBilled = new NormalDate();
        amtBilled = 0.0;
        amtCurrentlyPaid = 0.0;
        description = null;
    }

    /**
     * This constructor is used to create and initialize a Bill object when all parameters are sent.
     * @param cardInput The patron's card number.
     * @param idInput The item ID number of the item related to the Bill.
     * @param dateInput The date the patron was billed.
     * @param amtBilledInput The amount the patron was billed for.
     * @param paidInput The amount the patron has currently paid.
     * @param descInput The description of the bill.
     */
    public Bill(String cardInput, String idInput, NormalDate dateInput, double amtBilledInput, double paidInput, String descInput)
    {
        patronCardNum = cardInput;
        itemID = idInput;
        dateBilled = dateInput;
        amtBilled = amtBilledInput;
        amtCurrentlyPaid = paidInput;
        description = descInput;
    }

    // Accessor methods

    public String getPatronCardNum()
    {
        return patronCardNum;
    }

    public String getItemID()
    {
        return itemID;
    }

    public NormalDate getDateBilled()
    {
        return dateBilled;
    }

    public double getAmtBilled()
    {
        return amtBilled;
    }

    public double getAmtCurrentlyPaid()
    {
        return amtCurrentlyPaid;
    }

    public String getDescription()
    {
        return description;
    }

    // Mutator methods

    public void setPatronCardNum(String cardInput)
    {
        patronCardNum = cardInput;
    }

    public void setItemID(String idInput)
    {
        itemID = idInput;
    }

    public void setDateBilled(NormalDate dateInput)
    {
        dateBilled = dateInput;
    }

    public void setAmtBilled(double amtBilledInput)
    {
        amtBilled = amtBilledInput;
    }

    public void setAmtCurrentlyPaid(double paidInput)
    {
        amtCurrentlyPaid = paidInput;
    }

    public void setDescription(String descInput)
    {
        description = descInput;
    }
}