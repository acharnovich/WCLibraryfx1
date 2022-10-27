/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Book class is a class used to create objects that represent a book circulated by the library. It
 * inherits fields and methods from the abstract superclass Item. This new version replaces the old Author
 * ArrayList with a Collaborator ArrayList, and no longer makes use of the purgeTransaction method. All references
 * to fields from the Item superclasses now use getter and setter methods.
 *
 * @version 2.3 2022-04-03
 */

package Model;

import java.util.ArrayList;

public class Book extends Itemggbrb
{
    String publisher;                    // publishing company for the Book
    ArrayList<Collaborator> authors;     // author or authors of book
    String length;                          // length of the book in pages
    String genre;                        // genres

    /**
     * This zero argument constructor sets all variables to 0, null, or false when a Book object is created with
     * no parameters.
     */
    public Book()
    {
        setObjectType("Book");
        setItemID(0);
        setTitle(null);
        setYearPublished(0);
        setDatePublished(null);
        setDescription(null);
        setItemStatus(null);
        publisher = null;
        authors = null;
        length = "0 pages";
        genre = null;
    }

    /**
     * This constructor initializes the Book object when all parameters are set.
     * @param IDInput The ID number of the item.
     * @param titleInput The title of the book.
     * @param yearInput The year the book was published.
     * @param dateInput The date the book was published.
     * @param descInput The description of the book.
     * @param statInput The status of this item.
     * @param pubInput The publisher of the book.
     * @param authInput The author or authors of the book.
     * @param lenInput The length of the book in pages.
     * @param genInput The genre or genres of the book.
     */
    public Book(int IDInput, String titleInput, int yearInput, NormalDate dateInput, String descInput,
                String statInput, String pubInput, ArrayList<Collaborator> authInput, String lenInput, String genInput)
    {
        setObjectType("Book");
        setItemID(IDInput);
        setTitle(titleInput);
        setYearPublished(yearInput);
        setDatePublished(dateInput);
        setDescription(descInput);
        setItemStatus(statInput);
        publisher = pubInput;
        authors = authInput;
        length = lenInput;
        genre = genInput;
    }

    /**
     * The displayItemDetails method is a void method that overrides the abstract method from the Item superclass.
     * It displays all details about this Book to the console.
     *
     * TO BE FIXED: For now the display just shows the first author.
     */
    @Override
    public void displayItemDetails() {

        System.out.println("Item ID Number: " + getItemID() + "\nTitle: "
                + getTitle() + "\nAuthor: " + authors.get(0).getLastName() + ", " +
                authors.get(0).getFirstName() + "\nYear Published: " + getYearPublished() + "\nDate Published: " +
                getDatePublished() + "\nLength: " + length + "\nPublisher: " + publisher + "\nDescription: " +
                getDescription() + "\nItem Status: " + getItemStatus());

    }

    @Override
    public String toString()
    {
        return "Book:" + super.toString() + '\n'+
                "publisher:'" + publisher + '\n' +
                ", authors+" + authors + '\n'+
                ", length='" + length + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    /**
     * This method will ask the user for input about details they would like to change and re-initialize the
     * entire Book object.
     */
    @Override
    public void changeItemDetails() {
        System.out.println("Item details will be changed.");
    }

    /**
     * The changeItemStatus method changes the value stored in the itemStatus variable.
     * @param statInput
     */
    @Override
    public void changeItemStatus(String statInput) {
        setItemStatus(statInput);
    }

    // Overridden abstract getter methods
    public String getPublisher()
    {
        return publisher;
    }

    public ArrayList<Collaborator> getAuthors()
    {
        return authors;
    }

    public String getLength()
    {
        return length;
    }

    public String getGenres()
    {
        return genre;
    }

    // Overridden abstract null methods
    @Override
    public ArrayList<Collaborator> getNarrators() {
        return null;
    }

    @Override
    public String getProductionCompany() {
        return null;
    }

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
