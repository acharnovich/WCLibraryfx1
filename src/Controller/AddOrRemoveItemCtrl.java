package Controller;

import Model.ItemList;
import psu.wc.wclibrary.View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AddOrRemoveItemCtrl
{
    private NewItemUI newItemUI;
    private String itemType;                // the item type to be created
    private ItemList itemList;              // list of items in inventory
    private RemoveItemUI removeItemUI;
    private Component frame;

    /**
     * Zero-args constructor for if there is no existing item list. It creates a new catalog from scratch.
     */
    public AddOrRemoveItemCtrl()
    {
        itemType = null;
        itemList = new ItemList();
    }

    /**
     * This constructor is used when the existing catalog of items is passed to the AddOrRemoveItemCtrl controller.
     * The constructor sets itemType to null and assigns the ItemList reference to itemList.
     * @param items A reference to the ItemList object that stores the library catalog.
     */
    public AddOrRemoveItemCtrl(ItemList items)
    {
        itemType = null;
        itemList = items;
    }

    public void itemTypePrompt()
    {
        newItemUI = new NewItemUI();
        newItemUI.setVisible(true);
        addItemTypeListeners(newItemUI);

    }

    public void archive()
    {
        removeItemUI = new RemoveItemUI();
        removeItemUI.setVisible(true);
        addArchiveListeners(removeItemUI);

    }

    private void addArchiveListeners(RemoveItemUI removeItemUI)
    {

        // User clicks archiveItemButton
        removeItemUI.getArchiveItemButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                // if the add item button is clicked then...
                try {
                    if (e.getSource() == removeItemUI.getArchiveItemButton()) {

                        int itemID;
                        int x;

                        itemID = Integer.valueOf(removeItemUI.getItemIDField().getText());

                        for (x = 0; x < itemList.getInventory().size(); x++) {
                            if (itemList.getInventory().get(x).getItemID() == itemID) {
                                itemList.getInventory().get(x).changeItemStatus("Archived");
                                JOptionPane.showMessageDialog(frame, "Item successfully archived.");}

                        }

                    }

                }
                catch(Exception evt)
                {
                    JOptionPane.showMessageDialog(frame, "Item does not exist.");
                }
            }

        });
    }

    private void addItemTypeListeners(NewItemUI newItemUI)
    {

        // User clicks bookRadioButton
        newItemUI.getBookRadioButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add item button is clicked then...
                if (e.getSource() == newItemUI.getBookRadioButton()) {

                    // unselect audioBookRadioButton
                    newItemUI.getAudioBookRadioButton().setSelected(false);
                    // unselect movieRadioButton
                    newItemUI.getMovieRadioButton().setSelected(false);

                    // set item type to be created to "Book"
                    itemType = "Book";
                    System.out.println("Item type has been set to " + itemType);

                }
            }
        });


        // User clicks audioBookRadioButton
        newItemUI.getAudioBookRadioButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == newItemUI.getAudioBookRadioButton()) {

                    // unselect BookRadioButton
                    newItemUI.getBookRadioButton().setSelected(false);
                    // unselect movieRadioButton
                    newItemUI.getMovieRadioButton().setSelected(false);

                    // set item type to be created to "Audiobook"
                    itemType = "Audiobook";
                    System.out.println("Item type has been set to " + itemType);

                }
            }
        });

        // User clicks movieRadioButton
        newItemUI.getMovieRadioButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == newItemUI.getMovieRadioButton()) {

                    // unselect BookRadioButton
                    newItemUI.getBookRadioButton().setSelected(false);
                    // unselect AudioBookRadioButton
                    newItemUI.getAudioBookRadioButton().setSelected(false);

                    // set item type to be created to "Movie"
                    itemType = "Movie";
                    System.out.println("Item type has been set to " + itemType);

                }
            }
        });

        /**
         * ASH ON GOD YOU NEED TO DO THIS DO NOT FORGET TO FILL THESE OUT!!!!!!!!!!!!!!!!!!!!!!!!!! DOOFUS!!!!
         */



        // User clicks OK button
        newItemUI.getOkButton().addMouseListener(new MouseAdapter() {
            private Component frame;

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == newItemUI.getOkButton()) {

                    
                    // check what item type is currently set to
                    if (itemType == "Book")                                     // if the item type is a Book
                    {
                        // create NewBookDetailsUI
                        NewBookDetailsUI bookDetailsUI = new NewBookDetailsUI();

                        // addListener to NewBookDetailsUI Create New Item button
                        addBookSubmitListener(bookDetailsUI);

                    }
                    else if (itemType == "Audiobook")                           // if the item type is an AudioBook
                    {
                        // create NewAudioBookDetailsUI
                        NewAudioBookDetailsUI audioBooksDetailsUI = new NewAudioBookDetailsUI();

                        // addListeners to NewAudioBookDetailsUI Create New Item button
                        addAudioBookSubmitListener(audioBooksDetailsUI);
                    }
                    else if (itemType == "Movie")                               // if the item type is a Movie
                    {
                        // create NewMovieDetailsUI
                        NewMovieDetailsUI movieDetailsUI = new NewMovieDetailsUI();

                        // addListeners to NewMovieDetailsUI Create New Item button
                        addMovieSubmitListener(movieDetailsUI);
                    }
                    else
                    { 
                        
                        JOptionPane.showMessageDialog(frame, "Please select an option.");
                    }

                }
            }
        });

    }

    private void addBookSubmitListener(NewBookDetailsUI bookUI)
    {
        // get the Create New Item button from the Book Details UI
        bookUI.getCreateNewItemButton().addMouseListener(new MouseAdapter()
        {
            private Component frame;     // frame for error dialog box

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the create new item button is clicked then...
                if (e.getSource() == bookUI.getCreateNewItemButton()) {
                    try {
                        Collaborator collabTemp;                   // temp variable for initializing Collaborator objects before adding to
                        // collabs
                        ArrayList<Collaborator> collabTempList;    // temp variable for initializing Collaborator ArrayLists before adding to
                        // an Item
                        int itemID;                                // ID of an item
                        String title;                              // title of an item
                        int yearPublished;                         // year published
                        String datePublished;                      // date published
                        String itemStatus;                         // status of item
                        String publisher;                          // publisher of item
                        String length;                             // length in pages
                        String genres;                             // genres
                        String desc;                               // description
                        String firstName;                          // author first name
                        String lastName;                           // author last name

                        // create collabTempList
                        collabTempList = new ArrayList<Collaborator>();

                        // Get the String value in authorField and lastNameField and convert it to a String, assign to authors
                        firstName = bookUI.getAuthorField().getText();
                        lastName = bookUI.getLastNameField().getText();

                        // create and initialize a collaborator object for this author
                        collabTemp = new Collaborator(firstName, lastName, new ArrayList<Item>(), 1);
                        collabTempList.add(collabTemp);

                        // get data in item ID text field, convert to String, then int, assign to itemID
                        String str = bookUI.getItemIDField().getText();
                        itemID = Integer.valueOf(str);

                        // get data in title field, convert to String, assign to title
                        title = bookUI.getTitleField().getText();

                        // get data in yearPublished field, convert to String, then int, assign to yearPublished
                        String year;
                        year = bookUI.getYearPublishedField().getText();
                        yearPublished = Integer.valueOf(year);

                        // get data in date published field, convert to String, assign to datePublished
                        datePublished = bookUI.getDatePublishedField().getText();

                        // get data in itemStatus field, convert to String, assign to itemStatus
                        itemStatus = bookUI.getItemStatusComboBox().getSelectedItem().toString();

                        // get data in title publisher, convert to String, assign to publisher
                        publisher = bookUI.getPublisherField().getText();

                        // get data in the length field, convert to String, assign to length
                        length = bookUI.getLengthField().getText();

                        // get data in the genres field, convert to string, assign to genres
                        genres = bookUI.getGenreField().getText();

                        // get data in the description field, convert to string, assign to desc
                        desc = bookUI.getDescriptionField().getText();

                        // create Book with all that lovely data we collected
                        Book book = new Book(itemID, title, yearPublished, datePublished, desc, itemStatus, publisher,
                                collabTempList, length, genres);

                        // add the book to the inventory list
                        itemList.getInventory().add(book);

                        // display the item details of the most recently created item in the console
                        itemList.getInventory().get(itemList.getInventory().size() - 1).displayItemDetails();
                        System.out.println(itemList.getInventory().get(6).getDatePublished()+"this works!");
                    }
                    // If for some reason the object can't be created...
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, "Please make sure all fields are filled with valid data.");
                    }
                }
            }
        });
    }

    private void addAudioBookSubmitListener(NewAudioBookDetailsUI audiobookUI)
    {
        // get the Create New Item button from the Book Details UI
        audiobookUI.getCreateNewItemButton().addMouseListener(new MouseAdapter()
        {
            private Component frame;     // frame for error dialog box

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the create new item button is clicked then...
                if (e.getSource() == audiobookUI.getCreateNewItemButton()) {
                    try {
                        Collaborator collabTemp;                   // temp variable for initializing Collaborator objects before adding to
                        // collabs
                        ArrayList<Collaborator> collabTempList;    // temp variable for initializing Collaborator ArrayLists before adding to
                        // an Item
                        ArrayList<Collaborator> secondCollabTempList;

                        int itemID;                         // the item's ID number
                        String title;                       // the title of the item
                        int yearPublished;                  // the year the item was published
                        String datePublished;               // String of the date the item was published
                        String description;                 // the description of the item
                        String itemStatus;                  // item status
                        String authorFirstName;             // author's first name
                        String authorLastName;              // author's last name
                        String narratorFirstName;           // narrator's first name
                        String narratorLastName;            // narrator's last name
                        String publisher;                   // publisher
                        String production;                  // production company
                        String length;                      // length
                        String genres;                      // genres

                        // create collabTempList
                        collabTempList = new ArrayList<Collaborator>();
                        secondCollabTempList = new ArrayList<Collaborator>();

                        // Get the String value in authorField and authorLastNameField
                        authorFirstName = audiobookUI.getAuthorField().getText();
                        authorLastName = audiobookUI.getAuthorLastNameField().getText();

                        // create and initialize a collaborator object for this author
                        collabTemp = new Collaborator(authorFirstName, authorLastName, new ArrayList<Item>(), 1);
                        collabTempList.add(collabTemp);

                        // Get the String value in narratorField and narratorLastNameField
                        narratorFirstName = audiobookUI.getNarratorField().getText();
                        narratorLastName = audiobookUI.getNarratorLastNameField().getText();

                        // create and initialize a collaborator object for this author
                        collabTemp = new Collaborator(narratorFirstName, narratorLastName, new ArrayList<Item>(), 1);
                        secondCollabTempList.add(collabTemp);

                        // get data in item ID text field, convert to int, assign to itemID
                        String str = audiobookUI.getItemIDField().getText();
                        itemID = Integer.valueOf(str);

                        // get data in title field, convert to String, assign to title
                        title = audiobookUI.getTitleField().getText();

                        // get data in yearPublished field, convert to String, then int, assign to yearPublished
                        String year;
                        year = audiobookUI.getYearPublishedField().getText();
                        yearPublished = Integer.valueOf(year);

                        // get data in date published field, convert to String, assign to datePublished
                        datePublished = audiobookUI.getDatePublishedField().getText();

                        // get data in itemStatus field, convert to String, assign to itemStatus
                        itemStatus = audiobookUI.getItemStatusComboBox().getSelectedItem().toString();

                        // get data in title publisher, convert to String, assign to publisher
                        publisher = audiobookUI.getPublisherField().getText();

                        // get data in the length field, convert to String, assign to length
                        length = audiobookUI.getLengthField().getText();

                        // get data in the genres field, convert to string, assign to genres
                        genres = audiobookUI.getGenreField().getText();

                        // get data in the description field, convert to string, assign to description
                        description = audiobookUI.getDescriptionField().getText();

                        // get data in the production company frield, assign to production
                        production = audiobookUI.getProductionCompanyField().getText();

                        // create AudioBook with all that lovely data we collected
                        AudioBook audio = new AudioBook(itemID, title, yearPublished, datePublished, description, itemStatus,
                                                        publisher, collabTempList, secondCollabTempList, production, length, genres);

                        // add the audiobook to the inventory list
                        itemList.getInventory().add(audio);

                        // display the item details of the most recently created item in the console
                        itemList.getInventory().get(itemList.getInventory().size() - 1).displayItemDetails();

                    }
                    // If for some reason the object can't be created...
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, "Please make sure all fields are filled with valid data.");
                    }
                }
            }
        });
    }

    private void addMovieSubmitListener(NewMovieDetailsUI movieUI)
    {
        // get the Create New Item button from the Book Details UI
        movieUI.getCreateNewItemButton().addMouseListener(new MouseAdapter()
        {
            private Component frame;     // frame for error dialog box

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the create new item button is clicked then...
                if (e.getSource() == movieUI.getCreateNewItemButton()) {
                    try {
                        Collaborator collabTemp;                   // temp variable for initializing Collaborator objects before adding to
                        // collabs
                        ArrayList<Collaborator> collabTempList;    // temp variable for initializing Collaborator ArrayLists before adding to
                        // an Item
                        int itemID;                                // ID of an item
                        String title;                              // title of an item
                        int yearPublished;                         // year published
                        String datePublished;                      // date published
                        String itemStatus;                         // status of item
                        String production;                         // production company
                        String distributor;                        // distributor
                        String runtime;                            // runtime
                        String genres;                             // genres
                        String desc;                               // description
                        String firstName;                          // actor first name
                        String lastName;                           // actor last name
                        String type;                               // type

                        // create collabTempList
                        collabTempList = new ArrayList<Collaborator>();

                        // Get the String value in authorField and lastNameField and convert it to a String, assign to authors
                        firstName = movieUI.getActorFirstNameField().getText();
                        lastName = movieUI.getActorLastNameField().getText();

                        // create and initialize a collaborator object for this author
                        collabTemp = new Collaborator(firstName, lastName, new ArrayList<Item>(), 1);
                        collabTempList.add(collabTemp);

                        // get data in item ID text field, convert to String, then int, assign to itemID
                        String str = movieUI.getItemIDField().getText();
                        itemID = Integer.valueOf(str);

                        // get data in title field, convert to String, assign to title
                        title = movieUI.getTitleField().getText();

                        // get data in yearPublished field, convert to String, then int, assign to yearPublished
                        String year;
                        year = movieUI.getYearPublishedField().getText();
                        yearPublished = Integer.valueOf(year);

                        // get data in date published field, convert to String, assign to datePublished
                        datePublished = movieUI.getDatePublishedField().getText();

                        // get data in itemStatus field, convert to String, assign to itemStatus
                        itemStatus = movieUI.getItemStatusComboBox().getSelectedItem().toString();

                        // get production company from production company field, assign to production
                        production = movieUI.getProductionCompanyField().getText();

                        // get distributor from distributor field, assign to distributor
                        distributor = movieUI.getDistributorField().getText();

                        // get runtime from runtime field, assign to runtime
                        runtime = movieUI.getRuntimeField().getText();

                        // get type from type combo box, assign to type
                        type = movieUI.getTypeComboBox().getSelectedItem().toString();

                        // get data in the genres field, convert to string, assign to genres
                        genres = movieUI.getGenreField().getText();

                        // get data in the description field, convert to string, assign to desc
                        desc = movieUI.getDescriptionField().getText();

                        // create Movie with all that lovely data we collected
                        Movie movie = new Movie(itemID, title, yearPublished, datePublished, desc, itemStatus,
                                                production, distributor, collabTempList, type, runtime, genres);

                        // add the book to the inventory list
                        itemList.getInventory().add(movie);

                        // display the item details of the most recently created item in the console
                        itemList.getInventory().get(itemList.getInventory().size() - 1).displayItemDetails();

                    }
                    // If for some reason the object can't be created...
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(frame, "Please make sure all fields are filled with valid data.");
                    }
                }
            }
        });
    }

    // Accessor methods
    public NewItemUI getNewItemUI()
    {
        return newItemUI;
    }

    public ItemList getItemList() {
        return itemList;
    }

    public void setNewItemUI(NewItemUI newItemUI)
    {
        this.newItemUI = newItemUI;
    }

    public String getItemType()
    {
        return itemType;
    }

    public void setItemType(String itemType)
    {
        this.itemType = itemType;
    }

    public void setItemList(ItemList itemList)
    {
        this.itemList = itemList;
    }

    public RemoveItemUI getRemoveItemUI()
    {
        return removeItemUI;
    }

    public void setRemoveItemUI(RemoveItemUI removeItemUI)
    {
        this.removeItemUI = removeItemUI;
    }

    public Component getFrame()
    {
        return frame;
    }

    public void setFrame(Component frame)
    {
        this.frame = frame;
    }
}
