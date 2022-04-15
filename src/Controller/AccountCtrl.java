package Controller;

import Model.*;
import View.FxLoader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class AccountCtrl
{

    @FXML
    private RadioButton patronRBtn;

    @FXML
    private RadioButton staffRBtn;


    @FXML
    private ChoiceBox<String> positionBx;


    @FXML
    private ChoiceBox<String> statusBx;

    @FXML
    private Button testbtn;

    @FXML
    private AnchorPane areePane;


    @FXML
    private BorderPane radioBPane;


    @FXML
    private AnchorPane patronFillable;

    @FXML
    private Spinner<?> stateSpinner;


    @FXML
    private Line rdLine;

    @FXML
    private Label addressLbl;

    @FXML
    private Label aptLbl;
    @FXML
    private DatePicker birthPickerStaff;

    @FXML
    private DatePicker startPickerStaff;

    @FXML
    private ChoiceBox<String> stateTxtStaff;

    @FXML
    private TextField aptTxt;

    @FXML
    private Label birthLbl;

    @FXML
    private TextField yearTxt;
    @FXML
    private TextField monthTxt;
    @FXML
    private TextField dayTxt;

    @FXML
    private Label cardLbl;

    @FXML
    private TextField cardTxt;

    @FXML
    private Label cityLbl;

    @FXML
    private TextField cityTxt;

    @FXML
    private Button createAccountBtn;

    @FXML
    private TextField emailText;


    @FXML
    private Label nameLbl;

    @FXML
    private TextField nameTxt;

    @FXML
    private Label phoneNumLbl;

    @FXML
    private TextField countryTxt;
    @FXML
    private TextField localTxt;
    @FXML
    private TextField lastFourTxt;
    @FXML
    private TextField areaTxt;


    @FXML
    private Button secAddressBtn;

    @FXML
    private Button secondAddressBtn;

    @FXML
    private Label secondAddressLbl;

    @FXML
    private Label stateLbl;

    @FXML
    private Label streetNameLbl;

    @FXML
    private TextField streetNameTxt;

    @FXML
    private Label streetNumLbl;

    @FXML
    private TextField streetNumTxt;

    @FXML
    private Label typeLBL;

    @FXML
    private TextField typeTxt;

    @FXML
    private Label zipLbl;

    @FXML
    private TextField zipTxt;

    @FXML
    private Label addressLblStaff;

    @FXML
    private Label aptLblStaff;

    @FXML
    private TextField aptTxtStaff;

    @FXML
    private TextField areaTxtStaff;

    @FXML
    private Label birthLblStaff;

    @FXML
    private Label cityLblStaff;

    @FXML
    private TextField cityTxtStaff;

    @FXML
    private TextField countryTxtStaff;

    @FXML
    private Button createAccountBtnStaff;

    @FXML
    private TextField dayTxtStaff;

    @FXML
    private Label emailLblStaff;

    @FXML
    private TextField emailTextStaff;


    @FXML
    private TextField lastFourTxtStaf;

    @FXML
    private TextField localTxtStaff;

    @FXML
    private TextField monthTxtStaff;

    @FXML
    private Label nameLblStaff;

    @FXML
    private TextField nameTxtStaff;

    @FXML
    private AnchorPane staffFillable;

    @FXML
    private Label phoneNumLblStaff;

    @FXML
    private Label pinLbl;

    @FXML
    private TextField pinTxt;

    @FXML
    private Label positionLbl;

    @FXML
    private TextField positionTxt;

    @FXML
    private Button secAddressBtnStaff;

    @FXML
    private Button secondAddressBtnStaff;

    @FXML
    private Label secondAddressLblStaff;

    @FXML
    private DatePicker birthPicker;

    @FXML
    private Label staffIDLbl;

    @FXML
    private TextField staffIDTxt;

    @FXML
    private TextField startDayTxt;

    @FXML
    private Label startLbl;

    @FXML
    private TextField startMonthTxt;

    @FXML
    private TextField startYearTxt;

    @FXML
    private Label stateLblStaff;


    @FXML
    private Label statusLbl;

    @FXML
    private TextField statusTxt;

    @FXML
    private Label streetNameLblStaff;

    @FXML
    private TextField streetNameTxtStaff;

    @FXML
    private Label streetNumLblStaff;

    @FXML
    private TextField streetNumTxtStaff;

    @FXML
    private Label typeLBLStaff;

    @FXML
    private TextField typeTxtStaff;

    @FXML
    private TextField yearTxtStaff;

    @FXML
    private Label zipLblStaff;

    @FXML
    private TextField zipTxtStaff;

    @FXML
    private TextField areaTxt2;

    @FXML
    private TextField countryTxt2;

    @FXML
    private TextField lastFourTxt2;

    @FXML
    private TextField localTxt2;


    @FXML
    private Button verifyBtn;

    @FXML
    private Label verifyLbl;

    @FXML
    private AnchorPane verifyPane;

    @FXML
    private TextField verifyTxt;

    @FXML
    private ChoiceBox<String> stateTxt;

    PatronList patronList;
    StaffList staffList;

    public AccountCtrl()
    {
        positionBx = new ChoiceBox<>();
        statusBx = new ChoiceBox<>();
        stateTxt = new ChoiceBox<>();
        stateTxtStaff = new ChoiceBox<>();


    }

    @FXML
    public void patronCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        patronRBtn.setOnMouseClicked(mouseEvent ->
        {
            staffRBtn.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewPatronUI");
            this.radioBPane.setRight(content);


        });

    }

    @FXML
    public void verifyEmail()
    {
        verifyBtn.setOnMouseClicked(mouseEvent ->
        {
            patronList = new PatronList();
            if (patronList.verifyEmail(emailText.getText()) == false)
            {
                emailText.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

            } else
            {
                emailText.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            }

        });


    }

    @FXML
    public void patronAddPhoneNumber(javafx.event.ActionEvent actionEvent)
    {

        secAddressBtn.setOnMouseClicked(mouseEvent ->
        {
            countryTxt2.setVisible(true);
            localTxt2.setVisible(true);
            areaTxt2.setVisible(true);
            lastFourTxt2.setVisible(true);
        });
    }

    @FXML
    public void generateCard()
    {
        nameTxt.setOnKeyReleased(KeyEvent ->
        {
            Random randomCard = new Random();
            int n = 10000000 + randomCard.nextInt(90000000);
            cardTxt.setText(String.valueOf(n));
        });


    }

    @FXML()
    public void generateStaffEmailAndUserID()
    {
        boolean thrown = false;
        try
        {
            String firsti = String.valueOf(nameTxtStaff.getText().charAt(0));

            String[] words = nameTxtStaff.getText().split(" ", 3);
            for (String word : words)
                nameTxtStaff.setOnKeyTyped(KeyEvent ->
                {
                    staffIDTxt.setText(firsti.toLowerCase() + word.toLowerCase());
                    if (!staffIDTxt.getText().isEmpty() ||!nameTxtStaff.getText().isEmpty())
                    {
                        emailTextStaff.setText(staffIDTxt.getText()+"@wclibrary.com");
                    }
                });
        } catch (Exception e)
        {
            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Please enter a name");
            confirm.setContentText("Please enter a name to start.");
            confirm.showAndWait();
            thrown = true;
        }

    }


    @FXML
    public void enablePatron()
    {


        boolean disabled = (cityTxt.getText().isEmpty() || nameTxt.getText().isEmpty() || birthPicker.getEditor().getText().isEmpty() || streetNumTxt.getText().isEmpty() || streetNameTxt.getText().isEmpty() || typeTxt.getText().isEmpty() && cityTxt.getText().isEmpty() || zipTxt.getText().isEmpty() || countryTxt.getText().isEmpty() || areaTxt.getText().isEmpty() && areaTxt.getText().length() < 3 || localTxt.getText().isEmpty() || lastFourTxt.getText().isEmpty() || emailText.getText().isEmpty());
        patronFillable.setOnKeyPressed(keyEvent ->
        {
            if (areaTxt2.isVisible() == true && countryTxt2.getText().isEmpty() && areaTxt2.getText().isEmpty() && localTxt2.getText().isEmpty() && lastFourTxt2.getText().isEmpty())
            {
                createAccountBtn.setDisable(true);
                createAccountBtn.setDisable(disabled != false || countryTxt2.getText().isEmpty() || areaTxt2.getText().isEmpty() || localTxt2.getText().isEmpty() || lastFourTxt2.getText().isEmpty());
            } else
            {
                createAccountBtn.setDisable(disabled);
            }

        });
        patronFillable.setOnMouseMoved(mouseEvent ->
        {
            if (areaTxt2.isVisible() == true && countryTxt2.getText().isEmpty() && areaTxt2.getText().isEmpty() && localTxt2.getText().isEmpty() && lastFourTxt2.getText().isEmpty())
            {
                createAccountBtn.setDisable(true);
                createAccountBtn.setDisable(disabled != false || countryTxt2.getText().isEmpty() || areaTxt2.getText().isEmpty() || localTxt2.getText().isEmpty() || lastFourTxt2.getText().isEmpty());
            } else
            {
                createAccountBtn.setDisable(disabled != false);
            }

        });

        patronFillable.setOnMouseExited(mouseEvent ->
        {
            if (areaTxt2.isVisible() == true && countryTxt2.getText().isEmpty() && areaTxt2.getText().isEmpty() && localTxt2.getText().isEmpty() && lastFourTxt2.getText().isEmpty())
            {
                createAccountBtn.setDisable(true);
                createAccountBtn.setDisable(disabled != false || countryTxt2.getText().isEmpty() || areaTxt2.getText().isEmpty() || localTxt2.getText().isEmpty() || lastFourTxt2.getText().isEmpty());
            } else
            {
                createAccountBtn.setDisable(disabled != false);
            }

        });
        patronFillable.setOnMouseClicked(mouseEvent ->
        {
            if (areaTxt2.isVisible() == true && countryTxt2.getText().isEmpty() && areaTxt2.getText().isEmpty() && localTxt2.getText().isEmpty() && lastFourTxt2.getText().isEmpty())
            {
                createAccountBtn.setDisable(true);
                createAccountBtn.setDisable(disabled != false || countryTxt2.getText().isEmpty() || areaTxt2.getText().isEmpty() || localTxt2.getText().isEmpty() || lastFourTxt2.getText().isEmpty());
            } else
            {
                createAccountBtn.setDisable(disabled != false);
            }
        });


        countryTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*"))
                {
                    countryTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        streetNumTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 6)
                {
                    return change;
                }
                return null;
            }
        }));

        zipTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 5)
                {
                    return change;
                }
                return null;
            }
        }));


        cityTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        lastFourTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        typeTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));
        lastFourTxt2.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        lastFourTxt.setOnKeyReleased(mouseEvent ->
        {
            if (lastFourTxt.getText().length() < 4)
            {
                lastFourTxt.setStyle("-fx-text-fill: red;");
            } else
            {
                lastFourTxt.setStyle("-fx-text-fill: black;");
            }
        });

        areaTxt.setOnKeyReleased(mouseEvent ->
        {
            if (areaTxt.getText().length() < 3)
            {
                areaTxt.setStyle("-fx-text-fill: red;");
            } else
            {
                areaTxt.setStyle("-fx-text-fill: black;");
            }
        });

        localTxt.setOnKeyReleased(mouseEvent ->
        {
            if (localTxt.getText().length() < 3)
            {
                localTxt.setStyle("-fx-text-fill: red;");
            } else
            {
                localTxt.setStyle("-fx-text-fill: black;");
            }
        });

        countryTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 1)
                {
                    return change;
                }
                return null;
            }
        }));

        localTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
        areaTxt.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        countryTxt2.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 1)
                {
                    return change;
                }
                return null;
            }
        }));

        localTxt2.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
        areaTxt2.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        lastFourTxt2.setOnKeyReleased(mouseEvent ->
        {
            if (lastFourTxt2.getText().length() < 4)
            {
                lastFourTxt2.setStyle("-fx-text-fill: red;");
            } else
            {
                lastFourTxt2.setStyle("-fx-text-fill: black;");
            }
        });

        areaTxt2.setOnKeyReleased(mouseEvent ->
        {
            if (areaTxt2.getText().length() < 3)
            {
                areaTxt2.setStyle("-fx-text-fill: red;");
            } else
            {
                areaTxt2.setStyle("-fx-text-fill: black;");
            }
        });

        localTxt2.setOnKeyReleased(mouseEvent ->
        {
            if (localTxt2.getText().length() < 3)
            {
                localTxt2.setStyle("-fx-text-fill: red;");
            } else
            {
                localTxt2.setStyle("-fx-text-fill: black;");
            }
        });

        birthPicker.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
    }


    @FXML
    public boolean verifyCreatePatronAccount()
    {
        String datePickText = birthPicker.getEditor().getText();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
        birthPicker.setValue(tempDateFormatted);
        LocalDate tempDate = birthPicker.getValue();

        patronList = new PatronList();


        if (patronList.foundCardExact(cardTxt.getText()) == true || (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) || birthPicker.getEditor().getText().equals(null) || patronList.verifyEmail(emailText.getText()) == true || countryTxt.getText().length() + areaTxt.getText().length() + localTxt.getText().length() + lastFourTxt.getText().length() != 11 || !emailText.getText().contains("@") || zipTxt.getText().length() != 5 || tempDate.isAfter(LocalDate.now())))
        {

            return true;
        } else
        {
            NormalDate temp = new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()), String.valueOf(tempDate.getDayOfMonth()));
            System.out.println("false");
            return false;
        }


    }

    @FXML
    public void createPatronAccount(javafx.event.ActionEvent actionEvent)
    {

        if (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
        {

            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Date Format is Wrong!");
            confirm.setContentText("Fix the Date. m/d/yyyy");
            confirm.showAndWait();
        } else
        {
            boolean thrown = false;
            String datePickText = birthPicker.getEditor().getText();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");

            try
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                birthPicker.setValue(tempDateFormatted);
                if (tempDateFormatted.getDayOfMonth() > 31)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getMonth().getValue() > 12)
                {
                    thrown = true;
                }
                if (tempDateFormatted.getYear() >=20000)
                {
                    thrown = true;
                }

            } catch (Exception e)
            {

                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Numbers too hgireg");
                confirm.setContentText("Fix the Date. m/d/yyyy");
                confirm.showAndWait();
                thrown = true;
            }
            if (!thrown)
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                birthPicker.setValue(tempDateFormatted);
                LocalDate tempDate = birthPicker.getValue();
                patronList = new PatronList();

                createAccountBtn.setOnMouseClicked(MouseEvent ->
                {
                    if (verifyCreatePatronAccount() == true)
                    {
                        if (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPicker.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
                        {

                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Date Format is Wrong!");
                            confirm.setContentText("Fix the Date. m/d/yyyy");
                            confirm.showAndWait();
                        } else
                        {
                            if (tempDate.isAfter(LocalDate.now()))
                            {
                                Alert confirm = new Alert(Alert.AlertType.ERROR);
                                confirm.setHeaderText("Future Date!");
                                confirm.setContentText("Phone Number is too long or too short!");
                                confirm.showAndWait();
                            }
                        }


                        if (countryTxt.getText().length() + areaTxt.getText().length() + localTxt.getText().length() + lastFourTxt.getText().length() != 11)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Phone Number!");
                            confirm.setContentText("Phone Number is too long or too short!");
                            confirm.showAndWait();
                        }
                        if (countryTxt2.isVisible() == true && countryTxt2.getText().length() + areaTxt2.getText().length() + localTxt2.getText().length() + lastFourTxt2.getText().length() != 11)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText(" Second Phone Number!");
                            confirm.setContentText("Second Phone Number is too long or too short!");
                            confirm.showAndWait();
                        }

                        if (!emailText.getText().contains("@"))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Email!");
                            confirm.setContentText("Check to make sure email includes a @ character");
                            confirm.showAndWait();

                        }

                        if (patronList.foundCardExact(cardTxt.getText()) == true)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Card Exists!");
                            confirm.setContentText("Try typing in the name box again to refresh the numbers");
                            confirm.showAndWait();
                        }

                        if (Period.between(tempDate, LocalDate.now()).getYears() < 16)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Patron is too young!");
                            confirm.setContentText("Patron must be 16 years or older.");
                            confirm.showAndWait();

                        }


                        if (zipTxt.getText().length() != 5)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Zip Code is too short");
                            confirm.setContentText("Please  enter 5 digits");
                            confirm.showAndWait();

                        }

                        if (patronList.verifyEmail(emailText.getText()) == true)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Patron Exists!");
                            confirm.setContentText("Patron already exists!");
                            confirm.showAndWait();
                        }
                    } else
                    {
                        if (verifyCreatePatronAccount() == false && !tempDate.isAfter(LocalDate.now()))
                        {
                            Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()), String.valueOf(tempDate.getDayOfMonth())), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), aptTxt.getText(), cityTxt.getText(),
                                    zipTxt.getText(), stateTxt.getValue()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())))), emailText.getText(), cardTxt.getText(), 0);
                            patronList.LoadPatron(tempPatron);
                            PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                            AllCheckoutLists allLists = new AllCheckoutLists();
                            allLists.LoadList(tempList);
                            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                            confirm.setHeaderText("Account Added!");
                            confirm.setContentText("Account has been added");
                            confirm.showAndWait();
                        } else
                        {
                            if (countryTxt2.isVisible() == true && countryTxt2.getText().length() + areaTxt2.getText().length() + localTxt2.getText().length() + lastFourTxt2.getText().length() == 11 && verifyCreatePatronAccount() == false && !tempDate.isAfter(LocalDate.now()) && Period.between(tempDate, LocalDate.now()).getYears() > 16)
                            {
                                Patron tempPatron = new Patron(nameTxt.getText(), new NormalDate(yearTxt.getText(), monthTxt.getText(), dayTxt.getText()), new Address(streetNumTxt.getText(), streetNameTxt.getText(), typeTxt.getText(), aptTxt.getText(), cityTxt.getText(),
                                        zipTxt.getText(), stateTxt.getValue()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxt.getText()), Integer.valueOf(areaTxt.getText()), Integer.valueOf(localTxt.getText()), Integer.valueOf(lastFourTxt.getText())), new PhoneNumber(Integer.valueOf(countryTxt2.getText()), Integer.valueOf(areaTxt2.getText()), Integer.valueOf(localTxt2.getText()), Integer.valueOf(lastFourTxt2.getText())))), emailText.getText(), cardTxt.getText(), 0);
                                patronList.LoadPatron(tempPatron);
                                PatronCheckoutList tempList = new PatronCheckoutList(cardTxt.getText(), new ArrayList<CheckOut>());
                                AllCheckoutLists allLists = new AllCheckoutLists();
                                allLists.LoadList(tempList);
                                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                                confirm.setHeaderText("Account Added!");
                                confirm.setContentText("Account has been added");
                                confirm.showAndWait();
                            }
                        }
                    }
                });
            }
        }
    }

    @FXML
    public void initialize()
    {
        positionBx.getItems().removeAll(positionBx.getItems());
        positionBx.getItems().addAll("Associate Librarian", "Head Librarian", "Intern");
        positionBx.getSelectionModel().select("Associate Librarian");
        statusBx.getItems().removeAll(statusBx.getItems());
        statusBx.getItems().addAll("Experienced", "Training");
        statusBx.getSelectionModel().select("Training");
        stateTxt.getItems().removeAll(stateTxt.getItems());
        stateTxt.getItems().addAll("AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY");
        stateTxt.getSelectionModel().select("PA");
        stateTxtStaff.getItems().removeAll(stateTxtStaff.getItems());
        stateTxtStaff.getItems().addAll("AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY");
        stateTxtStaff.getSelectionModel().select("PA");


    }

    @FXML
    public void staffCreateAccount(javafx.event.ActionEvent actionEvent)
    {
        staffRBtn.setOnMouseClicked(mouseEvent ->
        {

            patronRBtn.setSelected(false);
            FxLoader object = new FxLoader();
            Pane content = object.getPage("NewStaffUI");
            radioBPane.setRight(content);


        });

    }

    public ChoiceBox<String> getPositionBx()
    {
        return positionBx;
    }

    public void setPositionBx(ChoiceBox<String> positionBx)
    {
        this.positionBx = positionBx;
    }

    @FXML
    public void enableStaff()
    {
        boolean disabled = (staffIDTxt.getText().isEmpty() || nameTxtStaff.getText().isEmpty() || pinTxt.getText().isEmpty() || startPickerStaff.getEditor().getText().isEmpty() || cityTxtStaff.getText().isEmpty() || birthPickerStaff.getEditor().getText().isEmpty() || streetNumTxtStaff.getText().isEmpty() || streetNameTxtStaff.getText().isEmpty() || typeTxtStaff.getText().isEmpty() && cityTxtStaff.getText().isEmpty() || zipTxtStaff.getText().isEmpty() || countryTxtStaff.getText().isEmpty() || areaTxtStaff.getText().isEmpty() && areaTxtStaff.getText().length() < 3 || localTxtStaff.getText().isEmpty() || lastFourTxtStaf.getText().isEmpty() || emailTextStaff.getText().isEmpty());
        staffFillable.setOnKeyPressed(keyEvent ->
        {
            createAccountBtnStaff.setDisable(disabled != false);


        });
        staffFillable.setOnMouseMoved(mouseEvent ->
        {
            createAccountBtnStaff.setDisable(disabled != false);


        });

        staffFillable.setOnMouseExited(mouseEvent ->
        {
            createAccountBtnStaff.setDisable(disabled != false);


        });
        staffFillable.setOnMouseClicked(mouseEvent ->
        {
            createAccountBtnStaff.setDisable(disabled != false);


        });


        countryTxtStaff.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1)
            {
                if (!t1.matches("\\d*"))
                {
                    countryTxt.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        streetNumTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 6)
                {
                    return change;
                }
                return null;
            }
        }));

        zipTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 5)
                {
                    return change;
                }
                return null;
            }
        }));
        cityTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
        typeTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("^[a-zA-Z' .]*$") && change.getControlNewText().length() <= 10)
                {
                    return change;
                }
                return null;
            }
        }));
        lastFourTxtStaf.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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

        lastFourTxtStaf.setOnKeyReleased(mouseEvent ->
        {
            if (lastFourTxtStaf.getText().length() < 4)
            {
                lastFourTxtStaf.setStyle("-fx-text-fill: red;");
            } else
            {
                lastFourTxtStaf.setStyle("-fx-text-fill: black;");
            }
        });

        areaTxtStaff.setOnKeyReleased(mouseEvent ->
        {
            if (areaTxtStaff.getText().length() < 3)
            {
                areaTxtStaff.setStyle("-fx-text-fill: red;");
            } else
            {
                areaTxtStaff.setStyle("-fx-text-fill: black;");
            }
        });

        localTxtStaff.setOnKeyReleased(mouseEvent ->
        {
            if (localTxtStaff.getText().length() < 3)
            {
                localTxtStaff.setStyle("-fx-text-fill: red;");
            } else
            {
                localTxtStaff.setStyle("-fx-text-fill: black;");
            }
        });

        countryTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
        {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change)
            {
                String value = change.getText();
                if (change.getText().matches("\\d*") && change.getControlNewText().length() <= 1)
                {
                    return change;
                }
                return null;
            }
        }));

        localTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
        areaTxtStaff.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
        startPickerStaff.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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


        birthPickerStaff.getEditor().setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>()
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
    }

    @FXML
    public boolean verifyCreateStaffAccount()
    {
        String datePickText = birthPickerStaff.getEditor().getText();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
        birthPickerStaff.setValue(tempDateFormatted);
        LocalDate tempDate = birthPickerStaff.getValue();
        String datePickTextStart = startPickerStaff.getEditor().getText();
        LocalDate tempDateFormattedStart = LocalDate.parse(datePickTextStart, df);
        startPickerStaff.setValue(tempDateFormattedStart);
        LocalDate tempDateStart = startPickerStaff.getValue();
        staffList = new StaffList();
        if (staffList.foundUserID(staffIDTxt.getText()) == true || (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) || birthPickerStaff.getEditor().getText().equals(null) || (!startPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!startPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!startPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!startPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) || startPickerStaff.getEditor().getText().equals(null) || staffList.verifyEmail(emailTextStaff.getText()) == true || countryTxtStaff.getText().length() + areaTxtStaff.getText().length() + localTxtStaff.getText().length() + lastFourTxtStaf.getText().length() != 11 || !emailTextStaff.getText().contains("@wclibrary.com") || zipTxtStaff.getText().length() != 5 || tempDateStart.isAfter(LocalDate.now()) || tempDate.isAfter(LocalDate.now()))))
        {
            return true;
        } else
        {
            System.out.println("false");
            return false;
        }
    }

    public void createStaffAccount(javafx.event.ActionEvent actionEvent)
    {
        if (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")) && !startPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!startPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!startPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!startPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
        {

            Alert confirm = new Alert(Alert.AlertType.ERROR);
            confirm.setHeaderText("Date Format is Wrong!");
            confirm.setContentText("Fix the Date. m/d/yyyy");
            confirm.showAndWait();
        } else
        {
            boolean thrown = false;
            String datePickText = birthPickerStaff.getEditor().getText();
            String datePickTextStart = startPickerStaff.getEditor().getText();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yyyy");

            try
            {
                LocalDate tempDateFormatted = LocalDate.parse(datePickText, df);
                birthPickerStaff.setValue(tempDateFormatted);
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
                LocalDate tempDateFormattedStart = LocalDate.parse(datePickTextStart, df);
                startPickerStaff.setValue(tempDateFormatted);
                if (tempDateFormattedStart.getDayOfMonth() > 31)
                {
                    thrown = true;
                }
                if (tempDateFormattedStart.getMonth().getValue() > 12)
                {
                    thrown = true;
                }
                if (tempDateFormattedStart.getYear() >= 20000)
                {
                    thrown = true;
                }

            } catch (Exception e)
            {

                Alert confirm = new Alert(Alert.AlertType.ERROR);
                confirm.setHeaderText("Numbers too hgireg");
                confirm.setContentText("Fix the Date. m/d/yyyy");
                confirm.showAndWait();
                thrown = true;
            }
            if (!thrown)
            {

                LocalDate tempDate = birthPickerStaff.getValue();
                LocalDate tempDateStart = startPickerStaff.getValue();
                staffList = new StaffList();

                createAccountBtnStaff.setOnMouseClicked(mouseEvent ->
                {
                    if (verifyCreateStaffAccount() == true)
                    {

                        if (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{2})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{2})/([0-9]{1})/([0-9]{4})")) && (!birthPickerStaff.getEditor().getText().matches("([0-9]{1})/([0-9]{1})/([0-9]{4})")))
                        {

                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Date Format is Wrong!");
                            confirm.setContentText("Fix the Date. m/d/yyyy");
                            confirm.showAndWait();
                        } else
                        {
                            if (tempDate.isAfter(LocalDate.now()) || tempDateStart.isAfter(LocalDate.now()))
                            {
                                Alert confirm = new Alert(Alert.AlertType.ERROR);
                                confirm.setHeaderText("Future Date!");
                                confirm.setContentText("Make sure date is presnet");
                                confirm.showAndWait();
                            }
                        }

                        if (staffList.foundUserID(staffIDTxt.getText()) == true)
                        {
                            Random randomID = new Random();
                            int n = 100 + randomID.nextInt(900);
                            staffIDTxt.setText(staffIDTxt.getText()+String.valueOf(n));
                            emailTextStaff.setText(staffIDTxt.getText()+"@wclibrary.com");
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("User Exists!");
                            confirm.setContentText("Your username has been changed to "+emailTextStaff.getText()+" due to an account with the same userid. Your email is "+emailTextStaff.getText()+". Please click create account again to confirm your account.");
                            confirm.showAndWait();



                        }

                        if (pinTxt.getText().length() < 4)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Pin Length");
                            confirm.setContentText("Check to make sure pin is longer than 4 numbers");
                            confirm.showAndWait();
                        }

                        if (countryTxtStaff.getText().length() + areaTxtStaff.getText().length() + localTxtStaff.getText().length() + lastFourTxtStaf.getText().length() != 11)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Phone Number!");
                            confirm.setContentText("Phone Number is too long or too short!");
                            confirm.showAndWait();
                        }
                        if (zipTxtStaff.getText().length() != 5)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Zip Code!");
                            confirm.setContentText("Make sure Zip is 5 digits.");
                            confirm.showAndWait();

                        }

                        if (cityTxtStaff.getText().equals(null))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("City!");
                            confirm.setContentText("Make sure City is not empty.");
                            confirm.showAndWait();

                        }

                        if (nameTxtStaff.getText().equals(null))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Name!");
                            confirm.setContentText("Make sure Name is not empty.");
                            confirm.showAndWait();

                        }

                        if (streetNameTxtStaff.getText().equals(null))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Street Name!");
                            confirm.setContentText("Make sure Street Name is not empty.");
                            confirm.showAndWait();

                        }
                        if (streetNumTxtStaff.getText().equals(null))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Street Number!");
                            confirm.setContentText("Make sure Street Number is not empty.");
                            confirm.showAndWait();

                        }
                        if (Period.between(tempDate, LocalDate.now()).getYears() < 18)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Age!");
                            confirm.setContentText("Staff must be 18 years or older.");
                            confirm.showAndWait();

                        }

                        if (typeTxtStaff.getText().equals(null))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Street Type");
                            confirm.setContentText("Make sure Street Type is not empty.");
                            confirm.showAndWait();

                        }

                        if (!emailTextStaff.getText().contains("@wclibrary.com"))
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Email Address!");
                            confirm.setContentText("Make sure the email includes @wclibrary.com");
                            confirm.showAndWait();

                        }
                        if (staffList.foundEmail(emailTextStaff.getText()) == true)
                        {
                            Alert confirm = new Alert(Alert.AlertType.ERROR);
                            confirm.setHeaderText("Email Address Exists!");
                            confirm.setContentText("Please use a new email address");
                            confirm.showAndWait();
                        }
                    } else
                    {
                        if (verifyCreateStaffAccount() == false && !tempDate.isAfter(LocalDate.now()) && !tempDateStart.isAfter(LocalDate.now()))
                        {

                            LibraryStaff tempStaff = new LibraryStaff(nameTxtStaff.getText(), new NormalDate(String.valueOf(tempDate.getYear()), String.valueOf(tempDate.getMonth().getValue()), String.valueOf(tempDate.getDayOfMonth())), new Address(streetNumTxtStaff.getText(), streetNameTxtStaff.getText(), typeTxtStaff.getText(), cityTxtStaff.getText(), stateTxtStaff.getValue(),
                                    zipTxtStaff.getText(), aptTxtStaff.getText()), new ArrayList<>(Arrays.asList(new PhoneNumber(Integer.valueOf(countryTxtStaff.getText()), Integer.valueOf(areaTxtStaff.getText()), Integer.valueOf(localTxtStaff.getText()), Integer.valueOf(lastFourTxtStaf.getText())))), emailTextStaff.getText(),
                                    staffIDTxt.getText(), pinTxt.getText(), positionBx.getValue(), statusBx.getValue(), new NormalDate(String.valueOf(tempDateStart.getYear()), String.valueOf(tempDateStart.getMonth().getValue()), String.valueOf(tempDateStart.getDayOfMonth())), 0);
                            staffList.LoadStaff(tempStaff);
                            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                            confirm.setHeaderText("Staff Account Added!");
                            confirm.setContentText("Account has been added");
                            confirm.showAndWait();
                        }
                    }
                });


            }
        }
    }
}

