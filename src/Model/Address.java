/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The Address class is used to create an object that represents a Person's home address. This version includes
 * getter methods, setter methods, and methods for displaying addresses to the user.
 *
 * @version 1.0 2022-03-04
 */

package Model;

public class Address
{
    //attributes
    //variables

    private String number;                      // the house number
    private String name;                     // the street
    private String type;                     // the type of street
    private String city;                     // the city
    private String state;                    // the state
    private String zip;                      // ZIP code
    private String secondAdd;                // second address placeholder - might be gotten rid of?


    /**
     * This zero-args constructor is used when Address is instantiated without any parameters sent.
     * It sets all variables in the object to default or null values.
     */
    public Address()
    {
        this.number = "";
        this.name = "N/A";
        this.type = "Unknown";
        this.secondAdd = "N/A";
        this.zip = "N/A";
        this.state = "  ";
        this.city = "";

    }

    /**
     * This constructor is used when Address is instantiated with all parameters set by the user.
     * @param number The house number of the Person.
     * @param name The street the Person lives on.
     * @param type The type of street the Person lives on.
     * @param secondAdd Placeholder for a second address. Might be gotten rid of in future versions.
     * @param city The city the Person lives in.
     * @param zip The ZIP code of the Person.
     * @param state The state the Person lives in.
     */
    public Address(String number, String name, String type, String secondAdd, String city, String zip, String state)
    {
        this.city = city;
        setNumber(number);
        setName(name);
        setType(type);
        setSecondAdd(secondAdd);
        this.zip = zip;
        this.state = state;

    }

    // Mutator methods

    /**
     * The setCity method sets city to an int value the user inputs.
     * @param city The city input by the user.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * The setNumber method sets the street number to an int value the user inputs.
     * @param number The number input by the user.
     */
    public void setNumber(String number)
    {
        this.number = number;
    }

    /**
     * The setName method takes a String input from the user, formats it properly for display, and sets
     * the name as the newly formatted String.
     * @param name The name input by the user.
     */
    public void setName(String name)
    {
        if (name.indexOf(" ") <= 0)
        {

            this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        }
        if (name.indexOf(" ") > 0)
        {
            String adAry[] = name.split(" ", 2);
            String fn = adAry[0];
            String sn = adAry[1];
            this.name = fn.substring(0, 1).toUpperCase() + fn.substring(1).toLowerCase() + " " + sn.substring(0, 1).toUpperCase() + sn.substring(1).toLowerCase();
        }

    }

    /**
     * The setType method takes a String input from the user and formats it properly for display. It assigns the resulting
     * String to the type variable.
     * @param type The type input by the user.
     */
    public void setType(String type)
    {
        this.type = type;
        if (type.matches("Street"))
        {
            this.type = "St.";
        }
        if (type.matches("Avenue"))
        {
            this.type = "Ave.";
        }
        if (type.matches("Drive"))
        {
            this.type = "Dr.";
        }

    }

    /**
     * The setZip method takes a String input from the user and assigns the value to the zip variable.
     * @param zip The ZIP code input by the user.
     */
    public void setZip(String zip)
    {
        this.zip = zip;
    }

    /**
     * The setState method takes a String input from the user and assigns the value to the state variable.
     * @param state The state input by the user.
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * The setSecondAdd method is a placeholder that sets the secondAddress of the user.
     * @param secondAdd The second address input by the user.
     */
    public void setSecondAdd(String secondAdd)
    {
        this.secondAdd = secondAdd;
        if (secondAdd.matches(""))
            this.secondAdd = "N/A";
        if (secondAdd.matches(" "))
            this.secondAdd = "N/A";

    }

    // Accessor methods

    public String getCity()
    {
        return city;
    }

    public String getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {


        return type;
    }

    public String getZip()
    {
        return zip;
    }

    public String getState()
    {
        return state;
    }

    public String getSecondAdd()
    {
        return secondAdd;

    }

    // Other methods

    /**
     * This toString method returns a String that has been formatted to display the Address object's data
     * to the user in a readable format.
     * @return A string representing the data stored in the Address object.
     */
    @Override
    public String toString()
    {
        return number + " " + name + " " + type;
    }

    /**
     * The checkAddress method checks if the ZIP code and street number input by the user
     * are valid. If either the ZIP code or street number is invalid, an error is displayed.
     * @return A Boolean representing that an error has occurred.
     */
    public boolean checkAddress(){
        if (zip.length() > 5)
        {
            System.out.println("Invalid ZipCode");
            return true;
        }
        if(String.valueOf(number).length() > 4)
        {
            System.out.println("Invalid Street Number");
            return true;
        }

        return false;
    }
}
