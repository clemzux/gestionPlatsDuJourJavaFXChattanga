package com.clemzux.chattanga.consultreservation;

import chattanga.classes.CDate;
import chattanga.classes.CReservation;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationGUI {

    CConsultReservationCtrl consultReservationCtrl;

    private Stage primaryStage;
    private Scene scene;

    private VBox fullWindowVbox, quitBackVbox,formVbox, textVbox, textChangeVbox;
    private HBox topWindowHbox, listFormHbox, textTextChangeHbox;

    private ImageView logoImageView;
    private Button quitButton, backButton;
    private ListView<CReservation> reservationListView;
    private Text formNameText, nameText, telText, numberPeopleText, numberDayDishText, hourArriveText, noteText;
    private Text nameChangeText, telChangeText, numberPeopleChangeText, numberDayDishChangeText, hourArriveChangeText, noteChangeText;


    //////// builder ////////


    public CConsultReservationGUI(Stage pStage) {

        primaryStage = pStage;

        initializeWidgets();
        widgetsPlacement();
        windowFinalization();

        consultReservationCtrl = new CConsultReservationCtrl(this);
    }


    //////// methods ////////


    private void widgetsPlacement() {

        textVbox.getChildren().addAll(nameText, telText, numberPeopleText, numberDayDishText, hourArriveText, noteText);
        textChangeVbox.getChildren().addAll(nameChangeText, telChangeText, numberPeopleChangeText, numberDayDishChangeText,
                hourArriveChangeText, noteChangeText);

        textTextChangeHbox.getChildren().addAll(textVbox, textChangeVbox);

        formVbox.getChildren().addAll(formNameText, textTextChangeHbox);

        listFormHbox.getChildren().addAll(reservationListView, formVbox);

        quitBackVbox.getChildren().addAll(quitButton, backButton);
        topWindowHbox.getChildren().addAll(logoImageView, quitBackVbox);

        fullWindowVbox.getChildren().addAll(topWindowHbox, listFormHbox);

        scene = new Scene(fullWindowVbox, CAppConstants.CONSULT_RESERVATION_WIDTH, CAppConstants.CONSULT_RESERVATION_HEIGHT);
    }

    private void initializeWidgets() {

        // boxes

        fullWindowVbox = new VBox();
        fullWindowVbox.setAlignment(Pos.CENTER);
        fullWindowVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        fullWindowVbox.setBackground(CAppConstants.appBackGround);

        topWindowHbox = new HBox();
        topWindowHbox.setAlignment(Pos.CENTER);
        topWindowHbox.setSpacing(CAppConstants.LOGO_SPACING);

        quitBackVbox = new VBox();
        quitBackVbox.setPadding(new Insets(20, 0, 0, 170));
        quitBackVbox.setSpacing(CAppConstants.GENERAL_SPACING);

        listFormHbox = new HBox();
        listFormHbox.setPadding(new Insets(0, 0, 0, 50));
        listFormHbox.setSpacing(CAppConstants.GENERAL_SPACING + 30);
        formVbox = new VBox();
        formVbox.setPadding(new Insets(50, 0, 0, 0));
        formVbox.setSpacing(CAppConstants.GENERAL_SPACING + 30);
        textTextChangeHbox = new HBox();
        textVbox = new VBox();
        textVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        textChangeVbox = new VBox();
        textChangeVbox.setSpacing(CAppConstants.GENERAL_SPACING);

        // widgets

        reservationListView = new ListView<CReservation>();
        reservationListView.setPrefSize(CAppConstants.CONSULT_RESERVATION_WIDTH * 0.5, CAppConstants.CONSULT_RESERVATION_HEIGHT * 0.7);

        Image logo = new Image(CAppConstants.APP_LOGO);
        logoImageView = new ImageView(logo);
        logoImageView.setFitWidth(CAppConstants.SCREEN_WIDTH * 0.1);
        logoImageView.setFitHeight(CAppConstants.SCREEN_HEIGHT * 0.1);
        backButton = new Button(CAppConstants.BACK_BUTTON);
        backButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);
        quitButton = new Button(CAppConstants.QUIT_BUTTON);
        quitButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);

        formNameText = new Text(CAppConstants.CONSULT_RESERVATIONS_FORM_NAME);
        nameText = new Text(CAppConstants.CONSULT_RESERVATIONS_NAME);
        telText = new Text(CAppConstants.CONSULT_RESERVATIONS_TEL);
        numberPeopleText = new Text(CAppConstants.CONSULT_RESERVATIONS_NB_PEOPLE);
        numberDayDishText = new Text(CAppConstants.CONSULT_RESERVATIONS_NB_DAYDISH);
        hourArriveText = new Text(CAppConstants.CONSULT_RESERVATIONS_HOUR_ARRIVE);
        noteText = new Text(CAppConstants.CONSULT_RESERVATIONS_NOTE);

        nameChangeText = new Text();
        telChangeText = new Text();
        numberPeopleChangeText = new Text();
        numberDayDishChangeText = new Text();
        hourArriveChangeText = new Text();
        noteChangeText = new Text();
    }

    private void windowFinalization() {

        primaryStage.setTitle(CAppConstants.APP_NAME + CAppConstants.APP_CONSULT_RESERVATION_NAME);
        primaryStage.setResizable(false);
        primaryStage.setWidth(CAppConstants.CONSULT_RESERVATION_WIDTH);
        primaryStage.setHeight(CAppConstants.CONSULT_RESERVATION_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //////// getters ////////


    public Stage getPrimaryStage() { return primaryStage; }

    public Button getQuitButton() { return quitButton; }

    public Button getBackButton() { return backButton; }

    public ListView<CReservation> getReservationListView() { return reservationListView; }

    public Text getNameChangeText() { return nameChangeText; }

    public Text getTelChangeText() { return telChangeText; }

    public Text getNumberPeopleChangeText() { return numberPeopleChangeText; }

    public Text getNumberDayDishChangeText() { return numberDayDishChangeText; }

    public Text getHourArriveChangeText() { return hourArriveChangeText; }

    public Text getNoteChangeText() { return noteChangeText; }
}
