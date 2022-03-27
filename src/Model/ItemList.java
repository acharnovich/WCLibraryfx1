/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The ItemList class is used to create an object that represents the entire catalog of items circulated by the
 * Penn State World Campus Library system. It has two attributes - an ArrayList of Item objects and an
 * ArrayList of Collaborator objects. It has methods that can be called to import items from the old system
 * catalog into the new system, and methods to update the ArrayList with new items.
 *
 * @version 2.0 2022-03-26
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ItemList {

    private ArrayList<Collaborator> collabsImport;               // list of collaborators for items
    private ArrayList<Item> itemImport;                          // list of current inventory
    private JsonObject jsonObject;
    private Gson gson;
    private LibraryStaff temp;

    /**
     * Zero-args constructor. This is the only constructor that will be run when ItemList is created, because
     * the ArrayList is updated via other methods provided in this class.
     */
    public ItemList()
    {
        itemImport = new ArrayList<Item>();
        collabsImport = new ArrayList<Collaborator>();
    }

    /**
     * The saveToFileInventory method saves an ArrayList of Items to the inventory json file.
     * @param invInput An ArrayList of Items to be added to the json file.
     */
    public void saveToFileInventory(ArrayList<Item> invInput)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("inventory.json"));
            gson.toJson(invInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    /**
     * The LoadBook method is used to add Books to the inventory json file.
     * @param temp A book to be added to the inventory list.
     * @return itemImport The inventory of items.
     */
    public ArrayList<Item> LoadBook(Item temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("inventory.json"));

            // convert JSON array to list of items
            ArrayList<Item> items = new Gson().fromJson(reader, new TypeToken<ArrayList<Item>>()
            {
            }.getType());


            for (int i = 0; i <= items.size() - 1; i++)
            {
                itemImport.add(items.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.itemImport.add(new Book(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getPublisher(), temp.getAuthors(), temp.getLength(),
                            temp.getGenres()));
        saveToFileInventory(this.itemImport);

        return itemImport;


    }


    /**
     * The LoadAudioBook method is used to add AudioBooks to the inventory json file.
     * @param temp An audiobook to be added to the inventory list.
     * @return itemImport The inventory of items.
     */
    public ArrayList<Item> LoadAudiobook(Item temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("inventory.json"));

            // convert JSON array to list of items
            ArrayList<Item> items = new Gson().fromJson(reader, new TypeToken<ArrayList<Item>>()
            {
            }.getType());


            for (int i = 0; i <= items.size() - 1; i++)
            {
                itemImport.add(items.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.itemImport.add(new AudioBook(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getPublisher(), temp.getAuthors(),
                            temp.getNarrators(), temp.getProductionCompany(), temp.getLength(), temp.getGenres()));
        saveToFileInventory(this.itemImport);

        return itemImport;


    }

    /**
     * The LoadAudioBook method is used to add AudioBooks to the inventory json file.
     * @param temp An audiobook to be added to the inventory list.
     * @return itemImport The inventory of items.
     */
    public ArrayList<Item> LoadMovie(Item temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("inventory.json"));

            // convert JSON array to list of items
            ArrayList<Item> items = new Gson().fromJson(reader, new TypeToken<ArrayList<Item>>()
            {
            }.getType());


            for (int i = 0; i <= items.size() - 1; i++)
            {
                itemImport.add(items.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.itemImport.add(new Movie(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getProductionCompany(), temp.getDistributor(),
                            temp.getActors(), temp.getType(), temp.getRuntime(), temp.getGenres()));
        saveToFileInventory(this.itemImport);

        return itemImport;


    }

    // Accessor method
    public ArrayList<Item> getInventory()
    {
        return itemImport;
    }


}
