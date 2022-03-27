/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Movie class is a class used to create objects that represent a movie circulated by the library. It
 * inherits fields and methods from the abstract superclass Item. This new version replaces the old Actor
 * ArrayList with a Collaborator ArrayList, and no longer makes use of the purgeTransaction method. All references
 * to fields from the Item superclasses now use getter and setter methods.
 *
 * @version 2.2 2022-03-26
 */

package Model;

import java.util.ArrayList;

public class Movie extends Item
{
    String productionCompany;                   // the production company that produced the movie
    String distributor;                         // the distributor of the movie
    ArrayList<Collaborator> starringActors;     // the actors in the movie
    String type;                                // either "Blu-Ray" or "DVD"
    String runtime;                             // runtime in hours and minutes
    String genre;                             // genre or genres -- limit of 3

    /**
     * This zero argument constructor sets all variables to 0, null, or false when a Book object is created with
     * no parameters.
     */
    public Movie()
    {
        setItemID(0);
        setTitle(null);
        setYearPublished(0);
        setDatePublished(null);
        setDescription(null);
        setItemStatus(null);
        productionCompany = null;
        distributor = null;
        starringActors = null;
        type = null;
        runtime = null;
        genre = null;
    }

    /**
     * This constructor initializes the Book object when all parameters are set.
     * @param IDInput The ID number of the item.
     * @param titleInput The title of the movie.
     * @param yearInput The year the movie was published.
     * @param dateInput The date the movie was published.
     * @param descInput The description of the movie.
     * @param statInput The status of this item.
     * @param prodInput The production company that produced the movie.
     * @param distInput The distributor of the movie.
     * @param actInput The actors in the movie.
     * @param typeInput The type of movie. "Blu-Ray" or "DVD".
     * @param runInput The runtime of the movie in hours and minutes.
     * @param genInput The genre or genres of the movie. Limit to 3.
     */
    public Movie(int IDInput, String titleInput, int yearInput, String dateInput, String descInput,
                 String statInput, String prodInput, String distInput, ArrayList<Collaborator> actInput, String typeInput,
                 String runInput, String genInput)
    {
        setItemID(IDInput);
        setTitle(titleInput);
        setYearPublished(yearInput);
        setDatePublished(dateInput);
        setDescription(descInput);
        setItemStatus(statInput);
        productionCompany = prodInput;
        distributor = distInput;
        starringActors = actInput;
        type = typeInput;
        runtime = runInput;
        genre = genInput;
    }

    /**
     * The displayItemDetails method is a void method that overrides the abstract method from the Item superclass.
     * It displays all details about this AudioBook to the console.
     *
     * TO BE FIXED: For now the display just shows the first actor. No genres.
     */
    @Override
    public void displayItemDetails() {
        System.out.println("Item ID Number: " + getItemID() + "\nTitle: "
                + getTitle() + "\nType of Item: " + type + "\nYear Published: " + getYearPublished() + "\nDate Published: " +
                getDatePublished() + "\nRuntime: " + runtime + "\nProduction Company: " + productionCompany +
                "\nDistributor: " + distributor + "\nActors: " + starringActors.get(0).getLastName() + ", " +
                starringActors.get(0).getFirstName() + "\nDescription: " + getDescription() + "\nItem Status: " + getItemStatus());
    }

    /**
     * This method will ask the user for input about details they would like to change and re-initialize the
     * entire Movie object.
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


    // Overridden abstract getters
    @Override
    public String getGenres() {
        return genre;
    }

    @Override
    public String getProductionCompany() {
        return productionCompany;
    }

    @Override
    public String getDistributor()
    {
        return distributor;
    }

    @Override
    public ArrayList<Collaborator> getActors()
    {
        return starringActors;
    }

    @Override
    public String getType()
    {
        return type;
    }

    @Override
    public String getRuntime()
    {
        return runtime;
    }


    // Overridden abstract getters that return null
    @Override
    public ArrayList<Collaborator> getNarrators() {
        return null;
    }

    @Override
    public String getPublisher() {
        return null;
    }

    @Override
    public ArrayList<Collaborator> getAuthors() {
        return null;
    }

    @Override
    public String getLength() {
        return null;
    }
}