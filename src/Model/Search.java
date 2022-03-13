package Model;

public interface Search
{
    //method for searching by title or name
    public abstract boolean searchByName(String input);


    //method for searching items or people by dates associated

    public abstract boolean searchByDate(String input);


    //method to search by ID for items or people

    public abstract boolean searchByID(String input);


}
