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

public class ItemList {

    private ArrayList<Collaborator> collabsImport;               // list of collaborators for items
    private ArrayList<Book> bookImport;                          // list of current inventory
    private ArrayList<AudioBook> audioBookImport;                // list of current inventory
    private ArrayList<Movie> movieImport;                        // list of current inventory
    private JsonObject jsonObject;
    private Gson gson;
    private LibraryStaff temp;

    /**
     * Zero-args constructor. This is the only constructor that will be run when ItemList is created, because
     * the ArrayList is updated via other methods provided in this class.
     */
    public ItemList()
    {
        bookImport = new ArrayList<Book>();
        audioBookImport = new ArrayList<AudioBook>();
        movieImport = new ArrayList<Movie>();
        collabsImport = new ArrayList<Collaborator>();
    }

    /**
     * The saveToFileBookInventory method saves an ArrayList of Books to the bookInventory json file.
     * @param invInput An ArrayList of Books to be added to the json file.
     */
    public void saveToFileBookInventory(ArrayList<Book> invInput)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("bookInventory.json"));
            gson.toJson(invInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    /**
     * The saveToFileAudioBookInventory method saves an ArrayList of AudioBooks to the audioBookInventory json file.
     * @param invInput An ArrayList of AudioBooks to be added to the json file.
     */
    public void saveToFileAudioBookInventory(ArrayList<AudioBook> invInput)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("audioBookInventory.json"));
            gson.toJson(invInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    /**
     * The saveToFileBookInventory method saves an ArrayList of Movies to the movieInventory json file.
     * @param invInput An ArrayList of Movies to be added to the json file.
     */
    public void saveToFileMovieInventory(ArrayList<Movie> invInput)
    {

        try
        {
            Gson gson = new Gson();
            Writer writer = Files.newBufferedWriter(Paths.get("movieInventory.json"));
            gson.toJson(invInput, writer);
            writer.flush();
            writer.close();
        } catch (Exception e)
        {

            e.printStackTrace();
        }
    }

    /**
     * The LoadBook method is used to add Books to the bookInventory json file.
     * @param temp A book to be added to the bookInventory list.
     * @return bookImport The inventory of books.
     */
    public ArrayList<Book> LoadBook(Book temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bookInventory.json"));

            // convert JSON array to list of items
            ArrayList<Book> books = new Gson().fromJson(reader, new TypeToken<ArrayList<Book>>()
            {
            }.getType());


            for (int i = 0; i <= books.size() - 1; i++)
            {
                bookImport.add(books.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.bookImport.add(new Book(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getPublisher(), temp.getAuthors(), temp.getLength(),
                            temp.getGenres()));
        saveToFileBookInventory(this.bookImport);

        return bookImport;


    }


    /**
     * The LoadAudioBook method is used to add AudioBooks to the audioBookInventory json file.
     * @param temp An audiobook to be added to the audioBookInventory list.
     * @return audioBookImport The inventory of audiobooks.
     */
    public ArrayList<AudioBook> LoadAudiobook(AudioBook temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("audioBookInventory.json"));

            // convert JSON array to list of items
            ArrayList<AudioBook> audios = new Gson().fromJson(reader, new TypeToken<ArrayList<AudioBook>>()
            {
            }.getType());


            for (int i = 0; i <= audios.size() - 1; i++)
            {
                audioBookImport.add(audios.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.audioBookImport.add(new AudioBook(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getPublisher(), temp.getAuthors(),
                            temp.getNarrators(), temp.getProductionCompany(), temp.getLength(), temp.getGenres()));
        saveToFileAudioBookInventory(this.audioBookImport);

        return audioBookImport;


    }

    /**
     * The LoadMovie method is used to add Movies to the movieInventory json file.
     * @param temp A movie to be added to the movieInventory list.
     * @return movieImport The inventory of movies.
     */
    public ArrayList<Movie> LoadMovie(Movie temp)
    {

        try
        {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("movieInventory.json"));

            // convert JSON array to list of items
            ArrayList<Movie> movies = new Gson().fromJson(reader, new TypeToken<ArrayList<Movie>>()
            {
            }.getType());


            for (int i = 0; i <= movies.size() - 1; i++)
            {
                movieImport.add(movies.get(i));
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        this.movieImport.add(new Movie(temp.getItemID(), temp.getTitle(), temp.getYearPublished(), temp.getDatePublished(),
                            temp.getDescription(), temp.getItemStatus(), temp.getProductionCompany(), temp.getDistributor(),
                            temp.getActors(), temp.getType(), temp.getRuntime(), temp.getGenres()));
        saveToFileMovieInventory(this.movieImport);

        return movieImport;


    }

    public boolean search(String itemToSearchFor)
    {

        try
        {
            // check through Books
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bookInventory.json"));

            // convert JSON array to list of items
            ArrayList<Book> books = new Gson().fromJson(reader, new TypeToken<ArrayList<Book>>()
            {
            }.getType());
            for (int i = 0; i < books.size(); i++)
            {



                if (books.get(i).toString().contains(itemToSearchFor))
                {
                    System.out.println("Exists.");
                    return true;
                }
            }

            // check through Movies
            // create Gson instance
            gson = new Gson();

            // create a reader
            reader = Files.newBufferedReader(Paths.get("movieInventory.json"));

            // convert JSON array to list of items
            ArrayList<Movie> movies = new Gson().fromJson(reader, new TypeToken<ArrayList<Movie>>()
            {
            }.getType());
            for (int i = 0; i < movies.size(); i++)
            {

                String tempID = Integer.toString(movies.get(i).getItemID());

                if (itemToSearchFor.contains(tempID))
                {
                    System.out.println("Exists.");
                    return true;
                }
            }

            // check through AudioBooks
            // create Gson instance
            gson = new Gson();

            // create a reader
            reader = Files.newBufferedReader(Paths.get("audioBookInventory.json"));

            // convert JSON array to list of items
            ArrayList<AudioBook> audios = new Gson().fromJson(reader, new TypeToken<ArrayList<AudioBook>>()
            {
            }.getType());
            for (int i = 0; i < audios.size(); i++)
            {

                String tempID = Integer.toString(audios.get(i).getItemID());

                if (itemToSearchFor.contains(tempID))
                {
                    System.out.println("Exists.");
                    return true;
                }
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Doesn't exist.");
        return false;
    }

    public boolean archiveItem(String itemToSearchFor)
    {

        try
        {
            // check through Books
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bookInventory.json"));

            // convert JSON array to list of items
            ArrayList<Book> books = new Gson().fromJson(reader, new TypeToken<ArrayList<Book>>()
            {
            }.getType());
            for (int i = 0; i < books.size(); i++)
            {

                String tempID = Integer.toString(books.get(i).getItemID());

                if (itemToSearchFor.contains(tempID))
                {
                    Book temp = new Book(books.get(i).getItemID(), books.get(i).getTitle(), books.get(i).getYearPublished(),
                            books.get(i).getDatePublished(), books.get(i).getDescription(), "Archived",
                            books.get(i).getPublisher(), books.get(i).getAuthors(), books.get(i).getLength(),
                            books.get(i).getGenres());
                    LoadBook(temp);
                    System.out.println("Archived.");
                    return true;
                }
            }

            // check through Movies
            // create Gson instance
            gson = new Gson();

            // create a reader
            reader = Files.newBufferedReader(Paths.get("movieInventory.json"));

            // convert JSON array to list of items
            ArrayList<Movie> movies = new Gson().fromJson(reader, new TypeToken<ArrayList<Movie>>()
            {
            }.getType());
            for (int i = 0; i < movies.size(); i++)
            {

                String tempID = Integer.toString(movies.get(i).getItemID());

                if (itemToSearchFor.contains(tempID))
                {
                    Movie temp = new Movie(movies.get(i).getItemID(), movies.get(i).getTitle(), movies.get(i).getYearPublished(),
                                           movies.get(i).getDatePublished(), movies.get(i).getDescription(),
                                           "Archived.", movies.get(i).getProductionCompany(), movies.get(i).getDistributor(),
                                           movies.get(i).getActors(), movies.get(i).getType(), movies.get(i).getRuntime(),
                                           movies.get(i).getGenres());
                    LoadMovie(temp);
                    System.out.println("Archived.");

                    return true;
                }
            }

            // check through AudioBooks
            // create Gson instance
            gson = new Gson();

            // create a reader
            reader = Files.newBufferedReader(Paths.get("audioBookInventory.json"));

            // convert JSON array to list of items
            ArrayList<AudioBook> audios = new Gson().fromJson(reader, new TypeToken<ArrayList<AudioBook>>()
            {
            }.getType());
            for (int i = 0; i < audios.size(); i++)
            {

                String tempID = Integer.toString(audios.get(i).getItemID());

                if (itemToSearchFor.contains(tempID))
                {
                    AudioBook temp = new AudioBook(audios.get(i).getItemID(), audios.get(i).getTitle(),
                                                   audios.get(i).getYearPublished(), audios.get(i).getDatePublished(),
                                                   audios.get(i).getDescription(), "Archived", audios.get(i).getPublisher(),
                                                   audios.get(i).getAuthors(), audios.get(i).getNarrators(),
                                                   audios.get(i).getProductionCompany(), audios.get(i).getLength(),
                                                   audios.get(i).getGenres());
                    LoadAudiobook(temp);
                    System.out.println("Archived.");
                    return true;
                }
            }

            // close reader
            reader.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        System.out.println("Doesn't exist.");
        return false;
    }

    // Accessor method
    public ArrayList<Book> getBookInventory()
    {
        return bookImport;
    }
    public ArrayList<Movie> getMovieInventory()
    {
        return movieImport;
    }
    public ArrayList<AudioBook> getAudioBookInventory()
    {
        return audioBookImport;
    }

}
