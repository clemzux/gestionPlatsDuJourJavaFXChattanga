package com.clemzux.chattanga.createdaydish;

import com.clemzux.chattanga.utilitaries.CAppConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by clemzux on 23/11/16.
 */
public class CCreateDayDishGUI {

    private Stage primaryStage;
    private Scene scene;

    private VBox fullWindowVbox, quitBackVbox, formVbox, textVbox, textFieldVbox;
    private HBox topWindowHbox, spinnerHbox, textTextFieldHbox;

    private ImageView logoImageView;

    private Button backButton, quitButton, addDayDishButton;

    private ComboBox<Integer> dayComboBox, monthComboBox, yearComboBox;
    private Text formTitleText, dateText, dayDishText, imageIdentifierText;
    private TextField dayDishTextField, imageIdentifierTextField;


    //////// builder ////////


    public CCreateDayDishGUI(Stage pStage) {

        primaryStage = pStage;

        initializeWidgets();
        widgetsPlacement();
        windowFinalization();

        new CCreateDayDishCtrl(this);
    }


    //////// methods ////////


    private void windowFinalization() {

        primaryStage.setTitle(CAppConstants.APP_NAME + CAppConstants.APP_CREATE_DAYDISH_NAME);
        primaryStage.setResizable(false);
        primaryStage.setWidth(CAppConstants.CREATE_DAYDISH_WIDTH);
        primaryStage.setHeight(CAppConstants.CREATE_DAYDISH_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void widgetsPlacement() {

        textVbox.getChildren().addAll(dateText, dayDishText, imageIdentifierText);
        spinnerHbox.getChildren().addAll(dayComboBox, monthComboBox, yearComboBox);
        textFieldVbox.getChildren().addAll(spinnerHbox, dayDishTextField, imageIdentifierTextField);

        textTextFieldHbox.getChildren().addAll(textVbox, textFieldVbox);

        formVbox.getChildren().addAll(formTitleText, textTextFieldHbox, addDayDishButton);

        quitBackVbox.getChildren().addAll(quitButton, backButton);
        topWindowHbox.getChildren().addAll(logoImageView, quitBackVbox);

        fullWindowVbox.getChildren().addAll(topWindowHbox, formVbox);
        fullWindowVbox.setAlignment(Pos.CENTER);
        fullWindowVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        fullWindowVbox.setBackground(CAppConstants.appBackGround);
    }

    private void initializeWidgets() {

        textVbox = new VBox();
        textVbox.setSpacing(CAppConstants.GENERAL_SPACING + 14);
        textFieldVbox = new VBox();
        textFieldVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        textTextFieldHbox = new HBox();
        formVbox = new VBox();
        formVbox.setSpacing(CAppConstants.GENERAL_SPACING + 20);
        formVbox.setPadding(new Insets(10, 0, 0, 50));
        formVbox.setAlignment(Pos.CENTER);

        quitBackVbox = new VBox();
        quitBackVbox.setPadding(new Insets(20, 0, 0, 170));
        quitBackVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        topWindowHbox = new HBox();
        topWindowHbox.setAlignment(Pos.CENTER);
        topWindowHbox.setSpacing(CAppConstants.LOGO_SPACING);

        spinnerHbox = new HBox();
        spinnerHbox.setSpacing(CAppConstants.GENERAL_SPACING);

        fullWindowVbox = new VBox();
        fullWindowVbox.setAlignment(Pos.CENTER);

        scene = new Scene(fullWindowVbox, CAppConstants.CREATE_DAYDISH_WIDTH, CAppConstants.CREATE_DAYDISH_HEIGHT);

        Image logo = new Image(CAppConstants.APP_LOGO);
        logoImageView = new ImageView(logo);
        logoImageView.setFitWidth(CAppConstants.SCREEN_WIDTH * 0.1);
        logoImageView.setFitHeight(CAppConstants.SCREEN_HEIGHT * 0.1);
        backButton = new Button(CAppConstants.BACK_BUTTON);
        backButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);
        quitButton = new Button(CAppConstants.QUIT_BUTTON);
        quitButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);

        formTitleText = new Text(CAppConstants.CREATE_DAYDISH_FORM_NAME);
        dateText = new Text(CAppConstants.CREATE_DAYDISH_DATE);
        dayDishText = new Text(CAppConstants.CREATE_DAYDISH_NAME);
        imageIdentifierText = new Text(CAppConstants.CREATE_DAYDISH_IMAGE_IDENTIFIER);

        dayComboBox = new ComboBox<Integer>();
        monthComboBox = new ComboBox<Integer>();
        yearComboBox = new ComboBox<Integer>();

        dayDishTextField = new TextField();
        imageIdentifierTextField = new TextField();

        addDayDishButton = new Button(CAppConstants.CREATE_DAYDISH_BUTTON);
    }


    //////// getters ////////


    public Stage getPrimaryStage() { return primaryStage; }

    public Button getBackButton() { return backButton; }

    public Button getQuitButton() { return quitButton; }

    public Button getAddDayDishButton() { return addDayDishButton; }

    public ComboBox<Integer> getDayComboBox() { return dayComboBox; }

    public ComboBox<Integer> getMonthComboBox() { return monthComboBox; }

    public ComboBox<Integer> getYearComboBox() { return yearComboBox; }

    public TextField getDayDishTextField() { return dayDishTextField; }

    public TextField getImageIdentifierTextField() { return imageIdentifierTextField; }
}
