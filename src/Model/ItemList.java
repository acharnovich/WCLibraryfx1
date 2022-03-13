/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The ItemList class is used to create an object that represents the entire catalog of items circulated by the
 * Penn State World Campus Library system. It has two attributes - an ArrayList of Item objects and an
 * ArrayList of Collaborator objects. It has methods that can be called to import items from the old system
 * catalog into the new system, and methods to update the ArrayList with new items.
 *
 * @version 1.0 2022-03-06
 */
package Model;

import java.util.ArrayList;

public class ItemList {

    private ArrayList<Item> inventory;              // the current inventory of the library
    private ArrayList<Collaborator> collabs;               // list of collaborators for items

    /**
     * Zero-args constructor. This is the only constructor that will be run when ItemList is created, because
     * the ArrayList is updated via other methods provided in this class.
     */
    public ItemList()
    {
        inventory = new ArrayList<Item>();
        collabs = new ArrayList<Collaborator>();
    }

    // Accessor method
    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    /**
     * The importList method is used to import items from the previous library system into the current library system.
     * It creates Item objects and adds them to the inventory ArrayList.
     */
    public void importList()
    {
        Book bookTemp;                                 // temp variable for initializing Book objects before adding to inventory
        Collaborator collabTemp;                       // temp variable for initializing Collaborator objects before adding to collabs
        ArrayList<Collaborator> collabTempList;        // temp variable for initializing Collaborator ArrayLists before adding to
                                                       // an Item
        ArrayList<Collaborator> secondCollabTempList;  // temp variable for initializing Collaborator ArrayLists before adding to
                                                       // an Item
        Movie movieTemp;                               // temp variable for initializing Movie objects before adding to inventory
        AudioBook audioTemp;                           // temp variable for initializing AudioBook objects before adding to inventory

        // import items
        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("Jason", "Schreier", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);
        // create Book object and assign value to temp variable
        bookTemp = new Book(9101342, "Press Reset", 2021, "May, 11, 2021", "From the bestselling author " +
                "of Blood, Sweat, and Pixels comes the next definitive, behind-the-scenes account of the video game industry: how "
                + "some of the past decade's most renowned studios fell apart—and the stories, both triumphant and tragic, of " +
                "what happened next.", "Checked In", "Grand Central Publishing", collabTempList, "301 " +
                "pages.", "Non-fiction");
        // add temp Book to inventory list
        inventory.add(bookTemp);

        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("Oprah", "Winfrey", new ArrayList<Item>(), 2);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);
        // create Book object and assign value to temp variable
        bookTemp = new Book(1013997, "What I know for sure", 2014, "September, 2, 2014",
                "The inspirational wisdom Oprah Winfrey shares in her monthly O., The Oprah Magazine column" +
                        " updated, curated, and collected for the first time in a beautiful keepsake book.",
                "Checked In", "Flatiron Books", collabTempList, "228 " +
                        "pages.", "Non-fiction");
        // add temp Book to inventory list
        inventory.add(bookTemp);

        // this book has same Collaborator as previous, just create Book and use same collabTempList variable
        bookTemp = new Book(1517122, "The path made clear: discovering your life's direction and purpose",
                    2019, "March 26, 2019", "In her latest book, The Path Made Clear, Oprah " +
                    "shares what she sees as a guide for activating your deepest vision of yourself, offering the framework " +
                    "for creating not just a life of success, but one of significance. ", "Checked In", "Flatiron " +
                    "Books", collabTempList, "208 pages.", "Non-fiction");
        inventory.add(bookTemp);

        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("F. Scott", "Fitzgerald", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);
        // create Book object and assign value to temp variable
        bookTemp = new Book(6734611, "The Great Gatsby", 1996, "June 1, 1996",
                "The Great Gatsby, F. Scott Fitzgerald’s third book, stands as the supreme achievement of his career. " +
                        "First published in 1925, this quintessential novel of the Jazz Age has been acclaimed by generations of readers.",
                "Checked In", "Schribner", collabTempList, "108 " +
                        "pages.", "Historical Fiction");
        // add temp Book to inventory list
        inventory.add(bookTemp);

        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("Will", "Smith", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);

        // create a second Collaborator object with temp variable for this Item
        collabTemp = new Collaborator("Alec", "Baldwin", new ArrayList<Item>(), 1);
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);

        // create Movie object and assign value to temp variable
        movieTemp = new Movie(8912600, "Concussion", 2016, "December 25, 2015", "Will Smith stars in Concussion, " +
                "a dramatic thriller based on the incredible true David vs. Goliath story of American immigrant Dr. " +
                "Bennet Omalu, the brilliant forensic neuropathologist who made the first discovery of CTE, a " +
                "football-related brain trauma, in a pro player and fought for the truth to be known.", "Checked In",
                "Columbia Pictures, LStar Capital, Village Roadshow Pictures, and Scott Free Productions", "Sony Pictures",
                 collabTempList, "DVD", "2h 3min", "Biography, Sport, Drama");
        // add temp Movie to inventory list
        inventory.add(movieTemp);

        // create a Collaborator object with temp variable
        collabTemp = new Collaborator("George", "Orwell", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        collabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        collabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);

        // create a second Collaborator object with temp variable for this Item
        collabTemp = new Collaborator("Richard", "Matthews", new ArrayList<Item>(), 1);
        // make an ArrayList of Collaborators to pass to the Item object
        secondCollabTempList = new ArrayList<Collaborator>();
        // add the temp Collaborator object to the collaborators ArrayList
        secondCollabTempList.add(collabTemp);
        // add the temp Collaborator to collabs list
        collabs.add(collabTemp);

        // create AudioBook object and assign value to temp variable
        audioTemp = new AudioBook(9199622, "1984", 2002, "n.d.", "Written more than 70 years ago, 1984 was George Orwell’s" +
                " chilling prophecy about the future.", "Checked In", "Books on Tape", collabTempList, secondCollabTempList,
                "unknown.", "10 hours", "Political fiction, Science fiction, Dystopian fiction.");
                // add temp AudioBook to inventory list
        inventory.add(bookTemp);


    }
}
