/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The CreateAccountCtrl class controls all access to and modification of Model and View objects needed for the purpose
 * of creating Person accounts. A Person can be one of two types: LibraryStaff or Patron. This version currently does
 * not do anything, and is a placeholder.
 *
 * @version 1.0 2022-03-04
 */

package Controller;

import Model.NormalDate;
import psu.wc.wclibrary.Model.*;

import java.util.ArrayList;

public class CreateAccountCtrl
{
    // PatronList pList = new PatronList(); (? - I don't know if this is going to be instantiated here. Thinking...)

    /**
     * The createNewPatron method will be run when creating a new Patron account.
     * @param tempName
     * @param tempBirth
     * @param tempAddress
     * @param tempPhoneNumber
     * @param tempEmail
     * @param tempCardNum
     * @param tempAge
     */
    public void createNewPatron(String tempName, NormalDate tempBirth, Address tempAddress, ArrayList<PhoneNumber>
                                tempPhoneNumber, String tempEmail, String tempCardNum, int tempAge)
    {
        System.out.println("Placeholder.");
    }


}
