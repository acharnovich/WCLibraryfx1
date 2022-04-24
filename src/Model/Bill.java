/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Bill class is used to create a Bill object. A Bill object represents an amount owed by a patron for a bill or
 * late fee. It includes getter, setter, serialization, and deserialization methods.
 *
 * @version 1.1 2022-04-17
 */

package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    public void saveToFileBills(ArrayList<Bill> billsInput)
    {
        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("bills.json"));
            gson.toJson(billsInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }


    public ArrayList<Bill> LoadBills(Bill temp)
    {
        ArrayList<Bill> allBills = new ArrayList<Bill>();

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bills.json"));

            // convert JSON to arraylist of bills
            ArrayList<Bill> bills = new Gson().fromJson(reader, new TypeToken<ArrayList<Bill>>()
            {
            }.getType());



            for (int i = 0; i <= bills.size() - 1; i++)
            {
                allBills.add(bills.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        allBills.add(new Bill(temp.getPatronCardNum(), temp.getItemID(), temp.getDateBilled(), temp.getAmtBilled(),
                              temp.getAmtCurrentlyPaid(), temp.getDescription()));

        saveToFileBills(allBills);

        return allBills;


    }

    public boolean removeAllBills(String patronToSearchFor){

        try
        {
            // check through bills
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bills.json"));

            // convert JSON arraylist of Bill objects
            ArrayList<Bill> bills = new Gson().fromJson(reader, new TypeToken<ArrayList<Bill>>()
            {
            }.getType());
            for (int i = 0; i < bills.size(); i++)
            {
                // get the patron ID at current index in the json, and assign the value to String tempID
                String tempID = String.valueOf(bills.get(i).getPatronCardNum());

                // if the patron id you are searching for matches tempID...
                if (patronToSearchFor.equals(tempID))
                {
                    // remove the record
                    bills.remove(i);


                }
            }

            // send the newly updated ArrayList of records to the json to be serialized
            saveToFileBills(bills);

            // close reader
            reader.close();

            return true;

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean partialPay(String patronToSearchFor, double amountToBePaid){

        try
        {
            // check through bills
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bills.json"));

            // convert JSON arraylist of Bill objects
            ArrayList<Bill> bills = new Gson().fromJson(reader, new TypeToken<ArrayList<Bill>>()
            {
            }.getType());

            double amt = amountToBePaid;

            // while there is still an amount to be paid
            while (amountToBePaid > 0)
            {
                // step through the bills arrayList
                for (int i = 0; i < bills.size(); i++)
                {
                    // get the patron ID at current index in the json, and assign the value to String tempID
                    String tempID = String.valueOf(bills.get(i).getPatronCardNum());

                    // if the patron id you are searching for matches tempID...
                    if (patronToSearchFor.equals(tempID))
                    {
                        // take the amount billed for this bill, minus the amount currently paid, and assign the value to billAmountLeft
                        double billAmountLeft = bills.get(i).getAmtBilled() - bills.get(i).getAmtCurrentlyPaid();

                        // if the bill amount is less than or equal to the amountToBePaid
                        if (billAmountLeft <= amountToBePaid)
                        {
                            // remove the bill from the bills arraylist
                            bills.remove(i);

                            // take amountToBePaid, minus the bill amount, and assign the new value to amountToBePaid
                            amountToBePaid = amountToBePaid - billAmountLeft;
                            amt = amountToBePaid;
                        }
                        // if the bill amount is more than the amountToBePaid
                        else
                        {
                            // create a new Bill object with amtCurrentlyPaid updated
                            Bill updatedBill = new Bill(bills.get(i).getPatronCardNum(), bills.get(i).getItemID(), bills.get(i).getDateBilled(),
                                                        bills.get(i).getAmtBilled(), amt, bills.get(i).getDescription());
                            // remove the old bill
                            bills.remove(i);

                            // add the new bill
                            bills.add(updatedBill);

                            // set amountToBePaid to 0 to end the while loop
                            amountToBePaid = 0;
                        }
                    }
                }
            }

            // send the newly updated ArrayList of records to the json to be serialized
            saveToFileBills(bills);

            // close reader
            reader.close();

            return true;

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }
}
