/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Item class is an abstract superclass that defines Item objects. Its fields and methods will
 * be used by its child subclasses. This version no longer includes references to ItemTransaction, which is no
 * longer a part of the design. This version has also gotten rid of the purgeTransaction abstract method.
 * There are some placeholder variables in the fields, in the place of references to future objects not yet created.
 * All fields in this version have been privatized, and getter and setter methods have been added for all fields.
 *
 * @version 3.0 2022-03-05
 */


package Model;

import java.util.ArrayList;

public abstract class Item {

    // fields
    private int itemID;                         // the item's ID number
    private String title;                       // the title of the item
    private int yearPublished;                  // the year the item was published - PLACEHOLDER FOR NORMALDATE
    private String datePublished;               // String of the date the item was published - PLACEHOLDER FOR NORMALDATE
    private String description;                 // the description of the item
    private String itemStatus;                  // the status of the item ("Checked out", "Checked In",
                                                // or "Archived")


    // abstract methods
    public abstract void displayItemDetails();                                  // display item details to the user
    public abstract void changeItemDetails();                                   // change the data stored in an item
    public abstract void changeItemStatus(String statInput);                    // change status of item

    // Mutator methods
    public void setItemID(int idInput)
    {
        itemID = idInput;
    }

    public void setTitle(String titleInput)
    {
        title = titleInput;
    }

    public void setYearPublished(int yearInput)
    {
        yearPublished = yearInput;
    }

    public void setDatePublished(String dateInput)
    {
        datePublished = dateInput;
    }

    public void setDescription(String descInput)
    {
        description = descInput;
    }

    public void setItemStatus(String statInput)
    {
        itemStatus = statInput;
    }

    // Accessor methods
    public int getItemID()
    {
        return itemID;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYearPublished()
    {
        return yearPublished;
    }

    public String getDatePublished()
    {
        return datePublished;
    }

    public String getDescription()
    {
        return description;
    }

    public String getItemStatus()
    {
        return itemStatus;
    }

    public abstract String getPublisher();

    public abstract ArrayList<Collaborator> getAuthors();

    public abstract String getLength();

    public abstract String getGenres();

    public abstract ArrayList<Collaborator> getNarrators();

    public abstract String getProductionCompany();

    public abstract String getDistributor();

    public abstract ArrayList<Collaborator> getActors();

    public abstract String getType();

    public abstract String getRuntime();

}

