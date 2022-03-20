package Model;

import java.util.ArrayList;

public class PatronList
{

    private ArrayList<Patron> patronimport;



    public PatronList(Patron temp)
    {
        patronimport = new ArrayList<Patron>();
    Patron test1 = new Patron();
    patronimport.add(temp);





    }
    public ArrayList<Patron> LoadPatron(){


        System.out.println(patronimport.get(0));
        return patronimport;


    }


    public PatronList(ArrayList<Patron> patronimport)
    {
        this.patronimport = patronimport;
    }

    public ArrayList<Patron> getPatronimport()
    {
        return patronimport;
    }

    public void setPatronimport(ArrayList<Patron> patronimport)
    {
        this.patronimport = patronimport;
    }
}
