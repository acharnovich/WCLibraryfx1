package Controller;

import Model.CheckOut;
import Model.NormalDate;

public class CheckOutCtrl {

    CheckOut checkOutTest = new CheckOut (1111111, 1111111, new NormalDate("2022", "04", "28"));

    public void testCheckOut()
    {
        System.out.println("Date Checked Out: " + checkOutTest.getDateOut().toString());
        System.out.println("Date Due Back: " + checkOutTest.getDueDate().toString());
    }

}
