/**
 * COPYRIGHT (C) 2022 GROUP 1. IST 311. ALL RIGHTS RESERVED.
 * @author Andrew Charnovich and Ash Schultz
 *
 * The NavigationCtrl class controls all access to and modification of Model and View objects needed for the purpose
 * of navigating through the system. In addition, the NavigationCtrl controller has access to all other controllers
 * in the Controller package. It creates instances of these classes when responding to events generated by the user.
 * This version responds to when the user clicks on Add Item or Remove Item. It does not respond to any other events
 * generated by the user yet.
 *
 * @version 1.0 2022-03-04
 */

package Controller;

import psu.wc.wclibrary.Model.*;
import psu.wc.wclibrary.View.NavUI;
import psu.wc.wclibrary.View.NewItemUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NavigationCtrl
{
    // UI references
    private NavUI navUI;                                   // the navigation UI to be displayed to the user
    private NewItemUI newItemUI;                           // the UI displayed when adding a new item

    // Controller references
    private AddOrRemoveItemCtrl addRemControl;             // the controller for adding or removing an item

    // other attributes
    private ItemList itemList;                             // list of catalog items

    /**
     * This zero-args constructor is run when NavigationCtrl is instantiated with no arguments.
     * It creates a new NavUI object and assigns its value to the navUI variable.
     */
    public NavigationCtrl()
    {
        navUI = new NavUI();
        itemList = new ItemList();
        importLists();
        addListeners();
    }

    /**
     * This NavigationCtrl constructor is called when a NavUI object is sent as a parameter during
     * instantiation. The reference of the object sent as a parameter is assigned to navUI.
     * @param navInput The Navigation UI to be shown to the user.
     */
    public NavigationCtrl(NavUI navInput)
    {
        this.navUI = navInput;
        itemList = new ItemList();
        importLists();
        addListeners();
    }

    // Accessor method
    public NavUI getNavUI()
    {
        return navUI;
    }

    // Mutator method
    public void setNavUI(NavUI navInput)
    {
        navUI = navInput;
    }

    /**
     * The addListeners method adds an event listener to all buttons on the Navigation.
     * When the user clicks a button, the controller and UI needed to carry out functionality is created.
     */
    private void addListeners() {

        // Add Item
        navUI.getAddItemButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add item button is clicked then...
                if (e.getSource() == navUI.getAddItemButton()) {

                    // create controller to add an item
                    addRemControl = new AddOrRemoveItemCtrl(itemList);
                    addRemControl.itemTypePrompt();       // make New Item UI visible
                    itemList = addRemControl.getItemList();

                }
            }
        });

        // Remove Item
        navUI.getRemoveItemButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the remove item button is clicked then...
                if (e.getSource() == navUI.getRemoveItemButton()) {

                    // create controller to remove an item
                    addRemControl = new AddOrRemoveItemCtrl(itemList);
                    addRemControl.archive();

                    itemList = addRemControl.getItemList();

                }
            }
        });

        // Search Item
        navUI.getSearchItemButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the search item button is clicked then...
                if (e.getSource() == navUI.getSearchItemButton()) {
                    //things happen here

                }
            }
        });

        // Add Patron
        navUI.getNewPatronButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getNewPatronButton()) {
                    //things happen here

                }
            }
        });

        // Lookup Patron
        navUI.getLookupPatronButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getLookupPatronButton()) {
                    //things happen here

                }
            }
        });

        // Add Staff
        navUI.getNewStaffButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getNewStaffButton()) {
                    //things happen here

                }
            }
        });

        // Check Out
        navUI.getCheckoutButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getCheckoutButton()) {
                    //things happen here

                }
            }
        });

        // Check In
        navUI.getCheckinButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getCheckinButton()) {
                    //things happen here

                }
            }
        });

        // Pay Bills
        navUI.getPayBillButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getPayBillButton()) {
                    //things happen here

                }
            }
        });

        // Add Bills
        navUI.getAddBillButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // if the add new patron button is clicked then...
                if (e.getSource() == navUI.getAddBillButton()) {
                    //things happen here

                }
            }
        });
    }

    /**
     * The importLists method imports previous items, patrons, and staff members from the old library system.
     * It creates these items, patrons, and staff members as objects, then adds these objects the ArrayList
     * fields in ItemList, StaffList, and PatronList.
     *
     * TO DO: Staff and Patrons
     */
    public void importLists()
    {
        itemList.importList();
        // staffList.importList();
        // patronList.importList();
    }

}
