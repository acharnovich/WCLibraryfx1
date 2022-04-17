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
}
