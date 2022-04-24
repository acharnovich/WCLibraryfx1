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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public void saveToFilePatronBillLists(ArrayList<PatronBillList> listsInput)
    {
        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("patronBillLists.json"));
            gson.toJson(listsInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }


    public ArrayList<PatronBillList> LoadBillLists(PatronBillList temp)
    {
        ArrayList<PatronBillList> allLists = new ArrayList<PatronBillList>();

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronBillLists.json"));

            // convert JSON to arraylist of bill lists
            ArrayList<PatronBillList> billLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronBillList>>()
            {
            }.getType());



            for (int i = 0; i <= billLists.size() - 1; i++)
            {
                allLists.add(billLists.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        allLists.add(new PatronBillList(temp.getPatronCardNum(), temp.getBills()));

        saveToFilePatronBillLists(allLists);

        return allLists;


    }

    public boolean updateBillList(String patronToSearchFor, Bill billInput)
    {

        try
        {
            // check through Patron bill lists
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronBillLists.json"));

            // convert JSON array to list of PatronBillLists
            ArrayList<PatronBillList> patronLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronBillList>>()
            {
            }.getType());
            for (int i = 0; i < patronLists.size(); i++)
            {
                // get the patron card number at current index in the json, and assign the value to String tempID
                String tempID = patronLists.get(i).getPatronCardNum();

                // if the patron card number you are searching for matches tempID...
                if (patronToSearchFor.equals(tempID))
                {
                    // deserialize data from json for this specific patron's bill list and create new PatronBillList
                    // object named temp
                    PatronBillList temp = new PatronBillList(patronLists.get(i).getPatronCardNum(),
                            patronLists.get(i).getBills());

                    // get the bills from temp and assign the value to tempBillList
                    ArrayList<Bill> tempBillList = new ArrayList<Bill>();
                    tempBillList = temp.getBills();

                    // add the bill sent as an argument to the tempBillList ArrayList
                    tempBillList.add(billInput);

                    PatronBillList updatedNewList = new PatronBillList(patronLists.get(i).getPatronCardNum(),
                            tempBillList);

                    // remove the old record
                    patronLists.remove(i);

                    // add the newly updated record
                    patronLists.add(updatedNewList);

                    // send the ArrayList of records to the json to be serialized
                    saveToFilePatronBillLists(patronLists);
                    return true;
                }
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Something went wrong.");
        return false;
    }

    public PatronBillList getFromJson(String patronToSearchFor)
    {
        PatronBillList billListToReturn = new PatronBillList();

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronBillLists.json"));

            // convert JSON array to list of bill lists
            ArrayList<PatronBillList> billLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronBillList>>()
            {
            }.getType());

            // step through the bill lists array
            for (int i = 0; i < billLists.size(); i++)
            {
                // get the patron ID from the current index and assign to String id
                String id = billLists.get(i).getPatronCardNum();

                // if id is the same as patronToSearchFor, return the PatronBillList object
                if (id.equals(patronToSearchFor))
                {
                    billListToReturn = billLists.get(i);
                }

            }

        reader.close();

        } catch (IOException e)
        {
            e.printStackTrace();

        }

        return billListToReturn;

    }

    public Double getAccountBalance()
    {
        // create a temporary variable to hold the total account balance called accountBalance
        double accountBalance = 0.00;
        // create a variable to hold the amount for a specific bill in the arraylist
        double thisBill;

        // step through the bills ArrayList
        for (int i = 0; bills.size() > i; i++)
        {
            // take the amount billed for this specific bill in the array, and minus the amount currently paid
            // assign the resulting value to thisBill
            thisBill = bills.get(i).getAmtBilled() - bills.get(i).getAmtCurrentlyPaid();

            // add accountBalance and thisBill
            // assign the new value to accountBalance
            accountBalance = accountBalance + thisBill;
        }

        return accountBalance;
    }

    public boolean removeAllBills(String patronToSearchFor){

        try
        {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronBillLists.json"));

            // convert JSON array to list of bill lists
            ArrayList<PatronBillList> billLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronBillList>>()
            {
            }.getType());

            // step through the bill lists array
            for (int i = 0; i < billLists.size(); i++)
            {
                // get the patron ID from the current index and assign to String id
                String id = billLists.get(i).getPatronCardNum();

                // if id is the same as patronToSearchFor, return the PatronBillList object
                if (id.equals(patronToSearchFor))
                {
                    billLists.remove(i);
                }

            }

            billLists.add(new PatronBillList(patronToSearchFor, new ArrayList<Bill>()));

            saveToFilePatronBillLists(billLists);

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return true;
    }


    public boolean partialPay(String patronToSearchFor, double amountToBePaid)
    {

        try
        {
            // check through bill lists
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("patronBillLists.json"));

            // convert JSON arraylist of PatronBillList objects
            ArrayList<PatronBillList> billLists = new Gson().fromJson(reader, new TypeToken<ArrayList<PatronBillList>>() {
            }.getType());

            // while there is still an amount to be paid
            while (amountToBePaid > 0)
            {

                // step through the billLists arrayList
                for (int i = 0; i < billLists.size(); i++)
                {

                    // get the patron ID at current index in the json, and assign the value to String tempID
                    String tempID = String.valueOf(billLists.get(i).getPatronCardNum());

                    // if the patron id you are searching for matches tempID...
                    if (patronToSearchFor.equals(tempID))
                    {

                        // step through bills arraylist inside the PatronBillList arrayList
                        for (int j = 0; j < billLists.get(i).getBills().size(); j++)
                        {

                            // take the amount billed for this bill, minus the amount currently paid, and assign the value to billAmountLeft
                            double billAmountLeft = billLists.get(i).getBills().get(j).getAmtBilled() -
                                    billLists.get(i).getBills().get(j).getAmtCurrentlyPaid();

                            // if the bill amount is less than or equal to the amountToBePaid
                            if (billAmountLeft <= amountToBePaid)
                            {
                                // remove the bill from the patron's bills arraylist
                                billLists.get(i).getBills().remove(j);

                                // create a newly updated PatronBillList object
                                PatronBillList newlyUpdatedBillList = new PatronBillList(billLists.get(i).getPatronCardNum(),
                                        billLists.get(i).getBills());

                                // remove old PatronBillList from billLists arraylist
                                billLists.remove(i);

                                // add the new PatronBillList
                                billLists.add(newlyUpdatedBillList);

                                // take amountToBePaid, minus the bill amount, and assign the new value to amountToBePaid
                                amountToBePaid = amountToBePaid - billAmountLeft;
                            }

                            // if the bill amount is more than the amountToBePaid
                            else
                            {
                                // create a new Bill object with amtCurrentlyPaid updated
                                Bill updatedBill = new Bill(billLists.get(i).getBills().get(j).getPatronCardNum(),
                                                            billLists.get(i).getBills().get(j).getItemID(),
                                                            billLists.get(i).getBills().get(j).getDateBilled(),
                                                            billLists.get(i).getBills().get(j).getAmtBilled(), amountToBePaid,
                                                            billLists.get(i).getBills().get(j).getDescription());

                                // remove the old bill from patron's bill list
                                billLists.get(i).getBills().remove(j);

                                // add the new bill to the Patron's Bill List
                                billLists.get(i).getBills().add(updatedBill);

                                // set amountToBePaid to 0 to end the while loop
                                amountToBePaid = 0;
                            }
                        }
                    }
                }
            }


            // send the newly updated ArrayList of records to the json to be serialized
            saveToFilePatronBillLists(billLists);

            // close reader
            reader.close();

            return true;


        }
            catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;

   }
}
