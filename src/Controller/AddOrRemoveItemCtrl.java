package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddOrRemoveItemCtrl {
    // FXML components
    @FXML
    private AnchorPane addItemUI;

    @FXML
    private Label selectTypeLabel;

    @FXML
    private RadioButton addBookRadioButton;

    @FXML
    private RadioButton addAudioBookRadioButton;

    @FXML
    private RadioButton addMovieRadioButton;

    @FXML
    private Button addItemContinueButton;

    @FXML
    private Label newBookDetailsLabel;

    @FXML
    private Label bookItemIDLabel;

    @FXML
    private TextField bookItemIDTextField;

    @FXML
    private Label bookTitleLabel;

    @FXML
    private TextField bookTitleTextField;

    @FXML
    private Label bookYearPublishedLabel;

    @FXML
    private TextField bookYearPublishedTextField;

    @FXML
    private Label bookDatePublishedLabel;

    @FXML
    private TextField bookDatePublishedYearTextField;

    @FXML
    private TextField bookDatePublishedMonthTextField;

    @FXML
    private TextField bookDatePublishedDayTextField;

    @FXML
    private Label bookPublisherLabel;

    @FXML
    private TextField bookPublisherTextField;

    @FXML
    private Label bookGenresLabel;

    @FXML
    private TextField bookGenresTextField;

    @FXML
    private Label bookLengthLabel;

    @FXML
    private TextField bookLengthTextField;

    @FXML
    private Label bookAuthorsLabel;

    @FXML
    private TextField bookAuthorsTextField;

    @FXML
    private Label bookDescriptionLabel;

    @FXML
    private TextArea bookDescriptionTextArea;

    @FXML
    private Button bookAddNewItemButton;

    @FXML
    private Label newMovieDetailsLabel;

    @FXML
    private Label movieItemIDLabel;

    @FXML
    private TextField movieItemIDTextField;

    @FXML
    private Label movieTitleLabel;

    @FXML
    private TextField movieTitleTextField;

    @FXML
    private Label movieYearPublishedLabel;

    @FXML
    private TextField movieYearPublishedTextField;

    @FXML
    private Label movieDatePublishedLabel;

    @FXML
    private TextField movieDatePublishedYearTextField;

    @FXML
    private TextField movieDatePublishedMonthTextField;

    @FXML
    private TextField movieDatePublishedDayTextField;


    @FXML
    private Label movieDistributorLabel;

    @FXML
    private TextField movieDistributorTextField;

    @FXML
    private Label movieProductionCompanyLabel;

    @FXML
    private TextField movieProductionCompanyTextField;

    @FXML
    private Label movieRuntimeLabel;

    @FXML
    private TextField movieRuntimeTextField;

    @FXML
    private Label movieTypeLabel;

    @FXML
    private Label movieGenresLabel;

    @FXML
    private TextField movieGenresTextField;

    @FXML
    private Label movieActorsLabel;

    @FXML
    private TextField movieActorsTextField;

    @FXML
    private Label movieDescriptionLabel;

    @FXML
    private TextArea movieDescriptionTextArea;

    @FXML
    private Label newAudioBookDetailsLabel;

    @FXML
    private Label audioBookItemIDLabel;

    @FXML
    private TextField audioBookItemIDTextField;

    @FXML
    private Label audioBookTitleLabel;

    @FXML
    private TextField audioBookTitleTextField;

    @FXML
    private Label audioBookYearPublishedLabel;

    @FXML
    private TextField audioBookYearPublishedTextField;

    @FXML
    private Label audioBookDatePublishedLabel;

    @FXML
    private TextField audioBookDatePublishedYearTextField;

    @FXML
    private TextField audioBookDatePublishedMonthTextField;

    @FXML
    private TextField audioBookDatePublishedDayTextField;

    @FXML
    private Label audioBookPublisherLabel;

    @FXML
    private TextField audioBookPublisherTextField;

    @FXML
    private Label audioBookProductionCompanyLabel;

    @FXML
    private TextField audioBookProductionCompanyTextField;

    @FXML
    private Label audioBookGenresLabel;

    @FXML
    private TextField audioBookGenresTextField;

    @FXML
    private Label audioBookLengthLabel;

    @FXML
    private TextField audioBookLengthTextField;

    @FXML
    private Label audioBookAuthorsLabel;

    @FXML
    private TextField audioBookAuthorsTextField;

    @FXML
    private Label audioBookNarratorsLabel;

    @FXML
    private TextField audioBookNarratorsTextField;

    @FXML
    private Label audioBookDescriptionLabel;

    @FXML
    private TextArea audioBookDescriptionTextArea;

    @FXML
    private Button audioBookAddNewItemButton;

    @FXML
    private RadioButton movieDVDTypeRadioButton;

    @FXML
    private RadioButton movieBluRayTypeRadioButton;

    // other attributes
    private String itemType;
    private String movieType;
    private ItemList itemList = new ItemList();


    public void handleAddBookClick(javafx.event.ActionEvent actionEvent) {
        addBookRadioButton.setOnMouseClicked(mouseEvent -> {

            addAudioBookRadioButton.setSelected(false);
            addMovieRadioButton.setSelected(false);
            itemType = "Book";


        });
    }

    public void handleAddAudioBookClick(javafx.event.ActionEvent actionEvent) {
        addAudioBookRadioButton.setOnMouseClicked(mouseEvent -> {

            addBookRadioButton.setSelected(false);
            addMovieRadioButton.setSelected(false);
            itemType = "AudioBook";

        });
    }

    public void handleAddMovieClick(javafx.event.ActionEvent actionEvent) {
        addMovieRadioButton.setOnMouseClicked(mouseEvent -> {

            addAudioBookRadioButton.setSelected(false);
            addBookRadioButton.setSelected(false);
            itemType = "Movie";

        });
    }

    public void handleDVDTypeClick(javafx.event.ActionEvent actionEvent) {
        movieDVDTypeRadioButton.setOnMouseClicked(mouseEvent -> {

            movieBluRayTypeRadioButton.setSelected(false);
            movieType = "DVD";

        });
    }

    public void handleBluClick(javafx.event.ActionEvent actionEvent) {
        movieBluRayTypeRadioButton.setOnMouseClicked(mouseEvent -> {

            movieDVDTypeRadioButton.setSelected(false);
            movieType = "Blu-Ray";

        });
    }

    public void handleContinueClick(javafx.event.ActionEvent actionEvent) {
        addItemContinueButton.setOnMouseClicked(mouseEvent -> {

            if (itemType == "Book") {
                Parent part = null;
                try {
                    part = FXMLLoader.load(getClass().getResource("/View/NewBookDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (itemType == "AudioBook") {
                Parent part = null;
                try {
                    part = FXMLLoader.load(getClass().getResource("/View/NewAudioBookDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Parent part = null;
                try {
                    part = FXMLLoader.load(getClass().getResource("/View/NewMovieDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.show();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public void handleAddNewBookClick(javafx.event.ActionEvent actionEvent) {
        bookAddNewItemButton.setOnMouseClicked(mouseEvent -> {

            ArrayList<Collaborator> authors = new ArrayList<>(); // list of authors for this book, as an arraylist
            Book temp;                                           // temporary book to be created

            authors = getCollaborators(bookAuthorsTextField.getText());


            // create the Book
            temp = new Book(Integer.parseInt(bookItemIDTextField.getText()), bookTitleTextField.getText(),
                    Integer.parseInt(bookYearPublishedTextField.getText()),
                    new NormalDate(bookDatePublishedYearTextField.getText(), bookDatePublishedMonthTextField.getText(),
                            bookDatePublishedDayTextField.getText()), bookDescriptionTextArea.getText(), "Checked In",
                    bookPublisherTextField.getText(), authors, bookLengthTextField.getText(), bookGenresTextField.getText());

            // send to LoadBook
            itemList.LoadBook(temp);

        });
    }

    ;

    public ArrayList<Collaborator> getCollaborators(String input) {
        ArrayList<String> people = new ArrayList<>();
        int x;
        String firstName;
        String lastName;
        Collaborator collabTemp;
        ArrayList<Collaborator> finalList = new ArrayList<>();


        String str = input;
        String[] newStrings = str.split("[,]", 0);
        for (String myStr : newStrings) {
            people.add(myStr);
        }


        for (x = 0; x < people.size(); x++)
        {
            String temp = people.get(x);
            String[] nameSplit = temp.split(" ");

            firstName = nameSplit[0];
            lastName = nameSplit[1];

            collabTemp = new Collaborator(firstName, lastName, new ArrayList<Item>(), 1);
            finalList.add(collabTemp);

        }

        return finalList;
    }


}
