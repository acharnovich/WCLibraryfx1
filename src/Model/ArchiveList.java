/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The ArchiveList class is used to create an object that represents the list of items archived in the inventory.
 *
 * @version 2.0 2022-03-05
 */

package Model;

import java.util.ArrayList;

public class ArchiveList
{
    ArrayList<Item> archived;       // ArrayList of references to Items that have been archived

    /**
     * This zero args constructor is the default. There will never be a scenario where ArchiveList is initialized
     * with user input values. Archived items will only be added to the list later.
     */
    public ArchiveList()
    {
        archived = null;
    }

    public ArchiveList(ArrayList<Item> importArchive)
    {
        archived = importArchive;
    }

    /**
     * This method will print all archived books to the user display.
     */
    public void printToDisplay() {

        int x = 0;

        while (x < archived.size())
        {
            System.out.println(archived.get(x));
            x++;
        }
    }


    public void printToFile()
    {
        // This is going to be a more complicated version of the printToDisplay that will print to an actual printer

    }

    // Accessor methods
    public ArrayList<Item> getArchived()
    {
        return archived;
    }

}