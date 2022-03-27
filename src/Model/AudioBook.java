/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The AudioBook class is a class used to create objects that represent an audiobook circulated by the library. It
 * inherits fields and methods from the abstract superclass Item. This new version replaces the old Author and Narrator
 * ArrayLists with Collaborator ArrayLists, and no longer makes use of the purgeTransaction method. All references
 * to fields from the Item superclasses now use getter and setter methods.
 *
 * @version 2.2 2022-03-26
 */

package Model;

import java.util.ArrayList;

public class AudioBook extends Item {
    String publisher;                        // publishing company for the Book
    ArrayList<Collaborator> authors;         // author or authors of book
    ArrayList<Collaborator> narrators;       // narrator or narrators of the book
    String productionCompany;                // the production company that produced the audiobook
    String length;                           // the length of the book in hours and minutes
    String genre;                            // the genre or genres of the audiobook

    /**
     * This zero argument constructor sets all variables to 0, null, or false when a AudioBook object is created with
     * no parameters.
     */
    public AudioBook() {
        setItemID(0);
        setTitle(null);
        setYearPublished(0);
        setDatePublished(null);
        setDescription(null);
        setItemStatus(null);
        publisher = null;
        authors = null;
        narrators = null;
        productionCompany = null;
        length = null;
        genre = null;
    }

    /**
     * This constructor initializes the AudioBook object when all parameters are set.
     *
     * @param IDInput    The ID number of the item.
     * @param titleInput The title of the audiobook.
     * @param yearInput  The year the audiobook was published.
     * @param dateInput  The date the audiobook was published.
     * @param descInput  The description of the audiobook.
     * @param statInput  The status of this item.
     * @param pubInput   The publisher of the audiobook.
     * @param authInput  The author or authors of the book.
     * @param narrInput  The narrator or narrators of the audiobook.
     * @param prodInput  The production company that produced the audiobook.
     * @param lenInput   The length of the audiobook in hours and minutes.
     * @param genInput   The genre or genres of the audiobook.
     */
    public AudioBook(int IDInput, String titleInput, int yearInput, String dateInput, String descInput,
                     String statInput, String pubInput, ArrayList<Collaborator> authInput, ArrayList<Collaborator> narrInput,
                     String prodInput, String lenInput, String genInput) {
        setItemID(IDInput);
        setTitle(titleInput);
        setYearPublished(yearInput);
        setDatePublished(dateInput);
        setDescription(descInput);
        setItemStatus(statInput);
        publisher = pubInput;
        authors = authInput;
        narrators = narrInput;
        productionCompany = prodInput;
        length = lenInput;
        genre = genInput;
    }

    /**
     * The displayItemDetails method is a void method that overrides the abstract method from the Item superclass.
     * It displays all details about this AudioBook to the console.
     * <p>
     * TO BE FIXED: For now the display just shows the first author and narrator.
     */
    @Override
    public void displayItemDetails() {
        System.out.println("Item ID Number: " + getItemID() + "\nTitle: "
                + getTitle() + "\nAuthor: " + authors.get(0).getLastName() + ", " +
                authors.get(0).getFirstName() + "\nNarrator: " + narrators.get(0).getLastName() + ", " +
                narrators.get(0).getFirstName() + "\nYear Published: " + getYearPublished() + "\nDate Published: " +
                getDatePublished() + "\nLength: " + length + "\nPublisher: " + publisher + "\nProduction Company: " +
                productionCompany + "\nDescription: " + getDescription() + "\nItem Status: " + getItemStatus());
    }

    /**
     * This method will ask the user for input about details they would like to change and re-initialize the
     * entire AudioBook object.
     */
    @Override
    public void changeItemDetails() {
        System.out.println("Item details will be changed.");
    }

    /**
     * The changeItemStatus method changes the value stored in the itemStatus variable.
     *
     * @param statInput
     */
    @Override
    public void changeItemStatus(String statInput) {
        setItemStatus(statInput);
    }

    // Overridden abstract getter methods
    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public ArrayList<Collaborator> getAuthors() {
        return authors;
    }

    @Override
    public String getLength() {
        return length;
    }

    @Override
    public String getGenres() {
        return genre;
    }

    @Override
    public ArrayList<Collaborator> getNarrators() {
        return narrators;
    }

    @Override
    public String getProductionCompany() {
        return productionCompany;
    }

    // Overridden getter methods that return null
    @Override
    public String getDistributor()
    {
        return null;
    }

    @Override
    public ArrayList<Collaborator> getActors()
    {
        return null;
    }

    @Override
    public String getType()
    {
        return null;
    }

    @Override
    public String getRuntime()
    {
        return null;
    }

}
