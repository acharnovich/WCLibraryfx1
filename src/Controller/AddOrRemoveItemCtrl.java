package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

public class AddOrRemoveItemCtrl
{
    // FXML components
    @FXML
    private Button bookAddNewItemButton;

    @FXML
    private Label bookAuthorsLabel;

    @FXML
    private TextField bookAuthorsTextField;

    @FXML
    private Label bookDatePublishedLabel;

    @FXML
    private Label bookDescriptionLabel;

    @FXML
    private TextArea bookDescriptionTextArea;

    @FXML
    private Label bookGenresLabel;

    @FXML
    private Label bookItemIDLabel;

    @FXML
    private TextField bookItemIDTextField;

    @FXML
    private Label bookLengthLabel;

    @FXML
    private TextField bookLengthTextField;

    @FXML
    private DatePicker bookPublishedPicker;

    @FXML
    private Label bookPublisherLabel;

    @FXML
    private TextField bookPublisherTextField;

    @FXML
    private Label bookTitleLabel;

    @FXML
    private TextField bookTitleTextField;


    @FXML
    private Label newBookDetailsLabel;

    @FXML
    private ComboBox<String> genreComboBox = new ComboBox<String>();

    @FXML
    private Label pageLbl;
    @FXML
    private Button SearchRemoveItemBtn;

    @FXML
    private AnchorPane searchRemovePane;

    @FXML
    private TableView<Item> searchRemoveTbl;

    @FXML
    private TextField searchRemoveTxt;
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
    private Label bookYearPublishedLabel;

    @FXML
    private TextField bookYearPublishedTextField;


    @FXML
    private TextField bookDatePublishedYearTextField;

    @FXML
    private TextField bookDatePublishedMonthTextField;

    @FXML
    private TextField bookDatePublishedDayTextField;


    @FXML
    private TextField bookGenresTextField;

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
    private TableColumn<Item, String> titleCol;

    @FXML
    private TableColumn<Item, Integer> itemIdCol;

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
    private TextField movieRuntimeTextFieldMin;

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
    private AnchorPane addMoviePane;

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
    private ComboBox<String> movieGenreCombo = new ComboBox<String>();

    @FXML
    private DatePicker moviePublishedPicker;


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
    private AnchorPane addBookPane;

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
    private AnchorPane addAudioPane;

    @FXML
    private RadioButton movieDVDTypeRadioButton;

    @FXML
    private RadioButton movieBluRayTypeRadioButton;

    @FXML
    private Button movieAddNewItemButton;

    @FXML
    private ToolBar archiveUIToolBar;

    @FXML
    private Button archiveSearchButton;

    @FXML
    private Label archiveInstructionsLabel;

    @FXML
    private Label archiveItemIDLabel;

    @FXML
    private ComboBox<String> audioGenreCombo = new ComboBox<String>();

    @FXML
    private TextField audioBookLengthTextFieldMin;

    @FXML
    private DatePicker audioYearPublishedPicker;

    @FXML
    private TextField archiveItemIDTextField;

    @FXML
    private Button archiveSubmitButton;

    // other attributes
    private String itemType;
    private String movieType;
    private ItemList itemList = new ItemList();

    @FXML
    public void initialize()
    {
        ObservableList genres = FXCollections.observableArrayList("romance",
                "mystery",
                "thriller",
                "sci-fi",
                "fantasy",
                "Non-Fiction", "Other");
        genreComboBox.setItems(genres);
        audioGenreCombo.setItems(genres);
        movieGenreCombo.setItems(genres);
    }


    public void handleAddBookClick(javafx.event.ActionEvent actionEvent)
    {

        addBookRadioButton.setOnMouseClicked(mouseEvent ->
        {
addItemContinueButton.setDisable(false);
            addAudioBookRadioButton.setSelected(false);
            addMovieRadioButton.setSelected(false);
            itemType = "Book";
        });

    }

    public void handleAddAudioBookClick(javafx.event.ActionEvent actionEvent)
    {
        addAudioBookRadioButton.setOnMouseClicked(mouseEvent ->
        {
addItemContinueButton.setDisable(false);
            addBookRadioButton.setSelected(false);
            addMovieRadioButton.setSelected(false);
            itemType = "AudioBook";

        });
    }

    public void handleAddMovieClick(javafx.event.ActionEvent actionEvent)
    {
        addMovieRadioButton.setOnMouseClicked(mouseEvent ->
        {
            addItemContinueButton.setDisable(false);
            addAudioBookRadioButton.setSelected(false);
            addBookRadioButton.setSelected(false);
            itemType = "Movie";

        });
    }

    public void handleDVDTypeClick(javafx.event.ActionEvent actionEvent)
    {
        movieDVDTypeRadioButton.setOnMouseClicked(mouseEvent ->
        {

            movieBluRayTypeRadioButton.setSelected(false);
            movieType = "DVD";

        });
    }

    public void handleBluClick(javafx.event.ActionEvent actionEvent)
    {
        movieBluRayTypeRadioButton.setOnMouseClicked(mouseEvent ->
        {

            movieDVDTypeRadioButton.setSelected(false);
            movieType = "Blu-Ray";

        });
    }

    public void handleContinueClick(javafx.event.ActionEvent actionEvent)
    {
        addItemContinueButton.setOnMouseClicked(mouseEvent ->
        {
            if (itemType == "Book")
            {
                Parent part = null;
                try
                {
                    part = FXMLLoader.load(getClass().getResource("/View/NewBookDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.setTitle("Enter New Book Details");
                    stage.show();

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            } else if (itemType == "AudioBook")
            {
                Parent part = null;
                try
                {
                    part = FXMLLoader.load(getClass().getResource("/View/NewAudioBookDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.setTitle("Enter New Audiobook Details");
                    stage.show();

                } catch (IOException e)
                {
                    e.printStackTrace();
                }

            } else
            {
                Parent part = null;
                try
                {
                    part = FXMLLoader.load(getClass().getResource("/View/NewMovieDetailsUI.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(part);
                    stage.setScene(scene);
                    stage.setTitle("Enter New Movie Details");
                    stage.show();


                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        });
    }

    public void handleNewBookValidation()
    {

        boolean disabled = (genreComboBox.getEditor().getText().isEmpty() || bookPublishedPicker.getEditor().getText().isEmpty() || bookTitleTextField.getText().isEmpty() || bookAuthorsTextField.getText().isEmpty() || bookPublisherTextField.getText().isEmpty() || bookLengthTextField.getText().isEmpty() || bookDescriptionTextArea.getText().isEmpty());
        addBookPane.setOnMouseMoved(mouseEvent ->
                {
                    if (!disabled)
                    {
                        bookAddNewItemButton.setDisable(false);
                    } else
                    {
                        bookAddNewItemButton.setDisable(disabled);
                    }
                    ;
                }
        );

        bookDescriptionTextArea.setOnKeyPressed(mouseEvent ->
                {
                    if (!disabled)
                    {
                        bookAddNewItemButton.setDisable(false);
                    } else
                    {
                        bookAddNewItemButton.setDisable(disabled);
                    }
                    ;
                }
        );
        bookTitleTextField.setOnKeyReleased(keyEvent ->
        {
            Random randomBookID = new Random();
            int n = 1000000 + randomBookID.nextInt(9000000);
            bookItemIDTextField.setText(String.valueOf(n));
        });

        bookPublishedPicker.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9/]*$") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));

        bookLengthTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 8)
                {
                    return change;
                }
                return null;
            }
        }));

        bookAuthorsTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .,]*$") && change.getControlNewText().length() <= 20)
                {
                    return change;
                }
                return null;
            }
        }));


    }

    public void handleAddNewBookClick(javafx.event.ActionEvent actionEvent)
    {
        if (!bookPublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!bookPublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!bookPublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!bookPublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
        {

            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Date Format is Wrong!");
            confirm.setContentText("Fix the Date. m/d/yyyy");
            confirm.showAndWait();
        } else
        {
            boolean thrown = false;
            String datePickText = bookPublishedPicker.getEditor().getText();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");

            try
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                bookPublishedPicker.setValue(tempDateFormatted);
                if (tempDateFormatted.getDayOfMonth() > 31)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getMonth().getValue() > 12)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getYear() >= 20000)
                {
                    thrown = true;
                }

            } catch (Exception e)
            {

                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Check Date!");
                confirm.setContentText("Fix the Date. Month, Day, or year is too High. m/d/yyyy");
                confirm.showAndWait();
                thrown = true;
            }

            if (!thrown)
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                bookPublishedPicker.setValue(tempDateFormatted);
                LocalDate tempDate = bookPublishedPicker.getValue();
                if(!tempDate.isAfter(LocalDate.now())){
                    if(bookAuthorsTextField.getText().matches("[a-zA-Z]*[\\s]{1}[a-zA-Z].*")){

                        bookAddNewItemButton.setOnMouseClicked(mouseEvent ->
                {

                    final Node source = (Node) actionEvent.getSource();
                    final Stage stage = (Stage) source.getScene().getWindow();

                    ArrayList<Collaborator> authors = new ArrayList<>(); // list of authors for this book, as an arraylist
                    Book temp;
                    // temporary book to be created

                    authors = getCollaborators(bookAuthorsTextField.getText());


                    // create the Book
                    temp = new Book(Integer.parseInt(bookItemIDTextField.getText()), bookTitleTextField.getText(),
                            Integer.parseInt(String.valueOf(tempDate.getYear())),
                            new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()),
                                    String.valueOf(tempDate.getDayOfMonth())), bookDescriptionTextArea.getText(), "Checked In",
                            bookPublisherTextField.getText(), authors, bookLengthTextField.getText()+" Pages", genreComboBox.getEditor().getText());
                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setHeaderText("Book Added!");
                    confirm.setContentText(bookTitleTextField.getText()+" is now in the item inventory with a status of checked in. ID#: "+bookItemIDTextField.getText());
                    confirm.showAndWait();
                    // send to LoadBook
                    itemList.LoadBook(temp);
                    stage.close();

                });}else {
                        Alert confirm = new Alert(Alert.AlertType.ERROR);
                        confirm.setHeaderText("Missing Last Name");
                        confirm.setContentText("Authors or Narrators Text field is missing a last name.");
                        confirm.showAndWait();
                    }}
                else {
                    if(tempDate.isAfter(LocalDate.now())){
                    Alert confirm = new Alert(Alert.AlertType.ERROR);
                    confirm.setHeaderText("Future Date!");
                    confirm.setContentText("Mak sure the day equal to or before today.");
                    confirm.showAndWait();

                }
                    if(itemList.searchBook(bookItemIDTextField.getText())==true){
                        Random randomBookID = new Random();
                        int n = 100000 + randomBookID.nextInt(900000);
                        bookItemIDTextField.setText(String.valueOf(n));
                        Alert confirm2 = new Alert(Alert.AlertType.ERROR);
                        confirm2.setHeaderText("PLease Submit");
                        confirm2.setContentText("Please Resubmit, book ID already existed.");
                        confirm2.showAndWait();

                    }}
            }
        }
    }

    public void handleNewAudioValidation()
    {

        boolean disabled = (audioBookDescriptionTextArea.getText().isEmpty()||audioGenreCombo.getEditor().getText().isEmpty() || audioYearPublishedPicker.getEditor().getText().isEmpty() || audioBookTitleTextField.getText().isEmpty() || audioBookAuthorsTextField.getText().isEmpty() || audioBookPublisherTextField.getText().isEmpty() || audioBookLengthTextField.getText().isEmpty() || audioBookLengthTextFieldMin.getText().isEmpty()||audioBookNarratorsTextField.getText().isEmpty());
        addAudioPane.setOnMouseMoved(mouseEvent ->
                {
                    if (disabled==false)
                    {
                        audioBookAddNewItemButton.setDisable(false);
                    } else
                    {
                        audioBookAddNewItemButton.setDisable(true);
                    }
                    ;
                }
        );

        audioBookDescriptionTextArea.setOnKeyPressed(mouseEvent ->
                {
                    if (disabled == false)
                    {
                        audioBookAddNewItemButton.setDisable(false);
                    } else
                    {
                        audioBookAddNewItemButton.setDisable(true);
                    }
                    ;
                }
        );
        audioBookTitleTextField.setOnKeyReleased(keyEvent ->
        {
            Random randomAudioID = new Random();
            int n = 100000 + randomAudioID.nextInt(900000);
            audioBookItemIDTextField.setText(String.valueOf(n));
        });

        audioYearPublishedPicker.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9/]*$") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));

        audioGenreCombo.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .]*$") && change.getControlNewText().length() <= 20)
                {
                    return change;
                }
                return null;
            }
        }));

        audioBookNarratorsTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .,]*$") && change.getControlNewText().length() <= 100)
                {
                    return change;
                }
                return null;
            }
        }));

        audioBookAuthorsTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .,]*$") && change.getControlNewText().length() <= 100)
                {
                    return change;
                }
                return null;
            }
        }));

        audioBookLengthTextFieldMin.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 4)
                {
                    return change;
                }
                return null;
            }
        }));

        audioBookLengthTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 3)
                {
                    return change;
                }
                return null;
            }
        }));


    }

    public void handleAddNewAudioBookClick(javafx.event.ActionEvent actionEvent)
    {
        if (!audioYearPublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!audioYearPublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!audioYearPublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!audioYearPublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
        {

            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Date Format is Wrong!");
            confirm.setContentText("Fix the Date. m/d/yyyy");
            confirm.showAndWait();
        } else
        {
            boolean thrown = false;
            String datePickText = audioYearPublishedPicker.getEditor().getText();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");

            try
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                audioYearPublishedPicker.setValue(tempDateFormatted);
                if (tempDateFormatted.getDayOfMonth() > 31)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getMonth().getValue() > 12)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getYear() >= 20000)
                {
                    thrown = true;
                }

            } catch (Exception e)
            {

                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Check Date!");
                confirm.setContentText("Fix the Date. Month, Day, or year is too High. m/d/yyyy");
                confirm.showAndWait();
                thrown = true;
            }

            if (!thrown)
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                audioYearPublishedPicker.setValue(tempDateFormatted);
                LocalDate tempDate = audioYearPublishedPicker.getValue();
                if(!tempDate.isAfter(LocalDate.now()))
                {
                    if(audioBookNarratorsTextField.getText().matches("[a-zA-Z]*[\\s]{1}[a-zA-Z].*")|| audioBookAuthorsTextField.getText().matches("[a-zA-Z]*[\\\\s]{1}[a-zA-Z].*")){
                    audioBookAddNewItemButton.setOnMouseClicked(mouseEvent ->
                    {

                        final Node source = (Node) actionEvent.getSource();
                        final Stage stage = (Stage) source.getScene().getWindow();

                        ArrayList<Collaborator> authors = new ArrayList<>();      // list of authors for this audiobook, as an arraylist
                        ArrayList<Collaborator> narrators = new ArrayList<>();    // list of authors for this audiobook, as an arraylist
                        AudioBook temp;                                           // temporary audiobook to be created

                        authors = getCollaborators(audioBookAuthorsTextField.getText());
                        narrators = getCollaborators(audioBookNarratorsTextField.getText());

                        // create the AudioBook
                        temp = new AudioBook(Integer.parseInt(audioBookItemIDTextField.getText()), audioBookTitleTextField.getText(),
                                Integer.parseInt(String.valueOf(tempDate.getYear())),
                                new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()),
                                        String.valueOf(tempDate.getDayOfMonth())), audioBookDescriptionTextArea.getText(), "Checked In",
                                audioBookPublisherTextField.getText(), authors, narrators, audioBookProductionCompanyTextField.getText(),
                                audioBookLengthTextField.getText()+" Hours"+ audioBookLengthTextFieldMin.getText()+ " Minutes", audioGenreCombo.getEditor().getText());
                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                        confirm.setHeaderText("AudioBook Added!");
                        confirm.setContentText(audioBookTitleTextField.getText()+" is now in the item inventory with a status of checked in. ID#: "+audioBookItemIDTextField.getText());
                        confirm.showAndWait();

                        // send to LoadAudioBook
                        itemList.LoadAudiobook(temp);

                        stage.close();

                    });}else { Alert confirm = new Alert(Alert.AlertType.ERROR);
                        confirm.setHeaderText("Missing Last Name");
                        confirm.setContentText("Authors or Narrators Text field is missing a last name.");
                        confirm.showAndWait();}
                }else {
                        if(tempDate.isAfter(LocalDate.now())){
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Future Date!");
                            confirm.setContentText("Mak sure the day equal to or before today.");
                            confirm.showAndWait();

                        }
                        if(itemList.searchAudio(audioBookItemIDTextField.getText())==true){
                            Random randomBookID = new Random();
                            int n = 100000 + randomBookID.nextInt(900000);
                            audioBookItemIDTextField.setText(String.valueOf(n));
                            Alert confirm2 = new Alert(Alert.AlertType.ERROR);
                            confirm2.setHeaderText("Please Submit");
                            confirm2.setContentText("Please Resubmit, book ID already existed.");
                            confirm2.showAndWait();

                        }}
                }
            }
        }

    public void handleNewMovieValidation()
    {

        boolean disabled = (movieDescriptionTextArea.getText().isEmpty()||movieGenreCombo.getEditor().getText().isEmpty() || moviePublishedPicker.getEditor().getText().isEmpty() || movieTitleTextField.getText().isEmpty() || movieActorsTextField.getText().isEmpty() || movieDistributorTextField.getText().isEmpty() || movieRuntimeTextFieldMin.getText().isEmpty() || movieRuntimeTextField.getText().isEmpty()||(movieBluRayTypeRadioButton.isSelected() ==false &&movieDVDTypeRadioButton.isSelected()==false));
        addMoviePane.setOnMouseMoved(mouseEvent ->
                {
                    if (disabled==false)
                    {
                        movieAddNewItemButton.setDisable(false);
                    } else
                    {
                        movieAddNewItemButton.setDisable(true);
                    }
                    ;
                }
        );

        addMoviePane.setOnMouseClicked(mouseEvent ->
                {
                    if (disabled==false)
                    {
                        movieAddNewItemButton.setDisable(false);
                    } else
                    {
                        movieAddNewItemButton.setDisable(true);
                    }
                    ;
                }
        );

        movieDescriptionTextArea.setOnKeyPressed(mouseEvent ->
                {
                    if (disabled == false)
                    {
                        movieAddNewItemButton.setDisable(false);
                    } else
                    {
                        movieAddNewItemButton.setDisable(true);
                    }
                    ;
                }
        );
        movieTitleTextField.setOnKeyReleased(keyEvent ->
        {
            Random randomAudioID = new Random();
            int n = 100000 + randomAudioID.nextInt(900000);
            movieItemIDTextField.setText(String.valueOf(n));
        });

        moviePublishedPicker.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[0-9/]*$") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));

        movieGenreCombo.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .]*$") && change.getControlNewText().length() <= 20)
                {
                    return change;
                }
                return null;
            }
        }));

        movieActorsTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .,]*$") && change.getControlNewText().length() <= 150)
                {
                    return change;
                }
                return null;
            }
        }));

        movieRuntimeTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 4)
                {
                    return change;
                }
                return null;
            }
        }));

        movieRuntimeTextFieldMin.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 3)
                {
                    return change;
                }
                return null;
            }
        }));


    }

    public void handleAddNewMovieClick(javafx.event.ActionEvent actionEvent)
    {
        if (!moviePublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!moviePublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!moviePublishedPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!moviePublishedPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
        {

            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Date Format is Wrong!");
            confirm.setContentText("Fix the Date. m/d/yyyy");
            confirm.showAndWait();
        } else
        {
            boolean thrown = false;
            String datePickText = moviePublishedPicker.getEditor().getText();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");

            try
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                moviePublishedPicker.setValue(tempDateFormatted);
                if (tempDateFormatted.getDayOfMonth() > 31)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getMonth().getValue() > 12)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getYear() >= 20000)
                {
                    thrown = true;
                }

            } catch (Exception e)
            {

                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Check Date!");
                confirm.setContentText("Fix the Date. Month, Day, or year is too High. m/d/yyyy");
                confirm.showAndWait();
                thrown = true;
            }

            if (!thrown)
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                moviePublishedPicker.setValue(tempDateFormatted);
                LocalDate tempDate = moviePublishedPicker.getValue();
                if(!tempDate.isAfter(LocalDate.now()))
                {
                    if(movieActorsTextField.getText().matches("[a-zA-Z]*[\\s]{1}[a-zA-Z].*")&&(movieBluRayTypeRadioButton.isSelected() ==true ||movieDVDTypeRadioButton.isSelected()== true)){
        movieAddNewItemButton.setOnMouseClicked(mouseEvent ->
        {

            final Node source = (Node) actionEvent.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();

            ArrayList<Collaborator> actors = new ArrayList<>();      // list of actors for this movie, as an arraylist
            Movie temp;                                              // temporary movie to be created

            actors = getCollaborators(movieActorsTextField.getText());

            // create the Movie
            temp = new Movie(Integer.parseInt(movieItemIDTextField.getText()), movieTitleTextField.getText(),
                    Integer.parseInt(String.valueOf(tempDate.getYear())),
                    new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()),
                            String.valueOf(tempDate.getDayOfMonth())), movieDescriptionTextArea.getText(), "Checked In",
                    movieProductionCompanyTextField.getText(), movieDistributorTextField.getText(), actors,
                    movieType, movieRuntimeTextField.getText()+" Hours "+movieRuntimeTextFieldMin.getText()+" Minutes", movieGenreCombo.getEditor().getText());
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setHeaderText("Movie Added!");
            confirm.setContentText(movieTitleTextField.getText()+" is now in the item inventory with a status of checked in. ID#: "+movieItemIDTextField.getText());
            confirm.showAndWait();

            // send to LoadMovie
            itemList.LoadMovie(temp);

            stage.close();

        });}else { Alert confirm = new Alert(Alert.AlertType.ERROR);
                        confirm.setHeaderText("Missing Last Name");
                        confirm.setContentText("Authors or Narrators Text field is missing a last name.");
                        confirm.showAndWait();}
                }else {
                    if((movieBluRayTypeRadioButton.isSelected() ==false &&movieDVDTypeRadioButton.isSelected()==false)){
                        if(tempDate.isAfter(LocalDate.now())){
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Select Movie Type");
                            confirm.setContentText("Select Blu Ray or DVD");
                            confirm.showAndWait();}
                    }
                    if(tempDate.isAfter(LocalDate.now())){
                        Alert confirm = new Alert(Alert.AlertType.ERROR);
                        confirm.setHeaderText("Future Date!");
                        confirm.setContentText("Mak sure the day equal to or before today.");
                        confirm.showAndWait();

                    }
                    if(itemList.searchMovie(movieItemIDTextField.getText())==true){
                        Random randomBookID = new Random();
                        int n = 100000 + randomBookID.nextInt(900000);
                        movieItemIDTextField.setText(String.valueOf(n));
                        Alert confirm2 = new Alert(Alert.AlertType.ERROR);
                        confirm2.setHeaderText("Please Submit");
                        confirm2.setContentText("Please Resubmit, book ID already existed.");
                        confirm2.showAndWait();
                    }}
            }
        }
    }


    public ArrayList<Collaborator> getCollaborators(String input)
    {
        ArrayList<String> people = new ArrayList<>();
        int x;
        String firstName;
        String lastName;
        Collaborator collabTemp;
        ArrayList<Collaborator> finalList = new ArrayList<>();


        String str = input;
        String[] newStrings = str.split(", ", 0);
        for (String myStr : newStrings)
        {
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

    public void handleArchiveSubmitClick()
    {

        archiveSubmitButton.setOnMouseClicked(mouseEvent ->
        {

            if (itemList.searchAudio(archiveItemIDTextField.getText()) == true || itemList.searchMovie(archiveItemIDTextField.getText()) == true || itemList.searchBook(archiveItemIDTextField.getText()) == true)
            {
                archiveItemIDTextField.setStyle("-fx-background-color: white");
                itemList.archiveItem(archiveItemIDTextField.getText());
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setHeaderText("Item added to Archive");
                confirm.setContentText("Item Removed or was previously added to Archives: " + archiveItemIDTextField.getText() + " has been removed from inventory and added to the archives.");
                confirm.showAndWait();

            } else
            {
                archiveItemIDTextField.setStyle("-fx-background-color: red");
                ;
            }

        });
    }


public void handleArchiveSearchClick(javafx.event.ActionEvent actionEvent)
        {
        archiveSearchButton.setOnMouseClicked(mouseEvent->
        {

        Parent part=null;

        try
        {

        part=FXMLLoader.load(getClass().getResource("/View/RemoveSearchUI.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Search Archive Items");
        stage.show();

        }catch(IOException e)
        {
        e.printStackTrace();
        }

        });
        }

public void removeItemVailidate()
        {
        searchRemoveTxt.setOnKeyReleased(KeyEvent->
        {
        if(!searchRemoveTxt.getText().isEmpty())
        {
        SearchRemoveItemBtn.setDisable(false);
        }else
        {
        SearchRemoveItemBtn.setDisable(true);
        }


        });
        SearchRemoveItemBtn.setOnMouseClicked(mouseEvent->
        {
        ObservableList<Item> items=FXCollections.observableArrayList();
        if(itemList.searchBook(searchRemoveTxt.getText())==true||itemList.searchMovie(searchRemoveTxt.getText())==true||itemList.searchAudio(searchRemoveTxt.getText())==true)
        {
        if(itemList.searchBook(searchRemoveTxt.getText()))
        {
        searchRemoveTxt.setStyle("-fx-background-color: white");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

        items.addAll(itemList.bookArchiveReturn(searchRemoveTxt.getText()));
        }
        if(itemList.searchMovie(searchRemoveTxt.getText())==true)
        {

        searchRemoveTxt.setStyle("-fx-background-color: white");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

        items.addAll(itemList.movieArchiveReturn(searchRemoveTxt.getText()));
        }
        if(itemList.searchAudio(searchRemoveTxt.getText())==true)
        {

        searchRemoveTxt.setStyle("-fx-background-color: white");
        itemIdCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemID"));
        titleCol.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));

        items.addAll(itemList.audioArchiveReturn(searchRemoveTxt.getText()));

        }
        searchRemoveTbl.setItems(items);
        }else
        {
        searchRemoveTxt.setStyle("-fx-background-color: red");
        }
        });


        }

public void searchArchiveVal()
        {
        searchRemoveTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
@Override
public TextFormatter.Change apply(TextFormatter.Change change)
        {
        String value=change.getText();
        if(change.getText().matches("\\d*")&&change.getControlNewText().length()< 10)
        {
        return change;
        }
        return null;
        }
        }));
        }

public void archiveUIValidate()
        {

        archiveItemIDTextField.setOnKeyPressed(KeyEvent->
        {
        if(!archiveItemIDTextField.getText().isEmpty())
        {
        archiveSubmitButton.setDisable(false);
        }else
        {
        archiveSubmitButton.setDisable(true);
        }
        });
        archiveItemIDTextField.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
@Override
public TextFormatter.Change apply(TextFormatter.Change change)
        {
        String value=change.getText();
        if(change.getText().matches("\\d*")&&change.getControlNewText().length()< 10)
        {
        return change;
        }
        return null;
        }
        }));
        }
        }

