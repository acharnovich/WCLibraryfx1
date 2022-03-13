/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Collaborator class is used to create an object that represents the author, narrator, or actor associated
 * with an item. This new class is a merged version of the Author, Narrator, and Actor clases, which were nearly
 * identical except for their names. A collaborator may be associated with one or many Item objects.
 * In this object, there is an array of references to Item objects that are related to the Collaborator object.
 *
 * @version 1.0 2022-03-05
 */

package Model;

import java.util.ArrayList;

public class Collaborator
{
        String firstName;       // first name of the Collaborator
        String lastName;        // last name of the Collaborator
        ArrayList<Item> items;  // arraylist of references to Item objects related to this Collaborator
        int totalItems;         // number of items written by the Collaborator in the system

        /**
         * Zero arguments constructor to be used when a Collaborator object is created without set parameters.
         */
        public Collaborator()
        {
                firstName = null;
                lastName = null;
                items = null;
                totalItems = 0;
        }

        /**
         * This constructor is used to create and initialize a Collaborator object when all parameters are set.
         * @param fNameInput The first name of the collaborator.
         * @param lNameInput The last name of the collaborator.
         * @param itemInput The array of items associated with this collaborator.
         * @param totalInput The total number of items associated with this collaborator in our system.
         */
        public Collaborator(String fNameInput, String lNameInput, ArrayList<Item> itemInput, int totalInput)
        {
                firstName = fNameInput;
                lastName = lNameInput;
                items = itemInput;
                totalItems = totalInput;
        }

        // Accessor methods
        public String getFirstName()
        {
                return firstName;
        }

        public String getLastName()
        {
                return lastName;
        }

        public ArrayList<Item> getItems()
        {
                return items;
        }
}
