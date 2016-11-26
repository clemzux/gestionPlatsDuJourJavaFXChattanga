package com.clemzux.chattanga.consultdaydish;

import chattanga.classes.CDate;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultDayDishGUI {

    private CConsultDayDishCtrl consultReservationsCtrl;

    private Stage primaryStage;
    private Scene scene;

    private VBox fullWindowVbox, quitBackButtonVbox, dayDishModificationVbox, textVbox, fieldVbox;
    private HBox topWindowHbox, dayDishHbox, dayDishFormHbox;

    private ImageView logoChattangaImageView;
    private Button exitButton, backButton, modificationButton;
    private ListView<CDate> dayDishsListView;
    private Text detailsText, dateText, dayDishText, imageIdentifierText;
    private TextField dateTextField, dayDishTextField, imageIdentifierTextField;


    //////// builder ////////


    public CConsultDayDishGUI(Stage pStage) {

        primaryStage = pStage;

        initializeWidgets();
        widgetsPlacement();
        windowFinalization();

        consultReservationsCtrl = new CConsultDayDishCtrl(this);
    }


    //////// methods ////////


    private void widgetsPlacement() {

        quitBackButtonVbox.getChildren().addAll(exitButton, backButton);
        topWindowHbox.getChildren().addAll(logoChattangaImageView, quitBackButtonVbox);

        textVbox.getChildren().addAll(dateText, dayDishText, imageIdentifierText);
        fieldVbox.getChildren().addAll(dateTextField, dayDishTextField, imageIdentifierTextField);

        dayDishFormHbox.getChildren().addAll(textVbox, fieldVbox);
        dayDishModificationVbox.getChildren().addAll(detailsText, dayDishFormHbox, modificationButton);
        dayDishHbox.getChildren().addAll(dayDishsListView, dayDishModificationVbox);

        fullWindowVbox.getChildren().addAll(topWindowHbox, dayDishHbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void windowFinalization() {

        primaryStage.setTitle(CAppConstants.APP_NAME + CAppConstants.APP_CONSULT_DAYDISH_NAME);
        primaryStage.setResizable(false);
        primaryStage.setWidth(CAppConstants.CONSULT_DAYDISH_WIDTH);
        primaryStage.setHeight(CAppConstants.CONSULT_DAYDISH_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeWidgets(){

        fullWindowVbox = new VBox();
        fullWindowVbox.setAlignment(Pos.CENTER);
        fullWindowVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        fullWindowVbox.setBackground(CAppConstants.appBackGround);

        topWindowHbox = new HBox();
        topWindowHbox.setAlignment(Pos.CENTER);
        topWindowHbox.setSpacing(CAppConstants.LOGO_SPACING);

        quitBackButtonVbox = new VBox();
        quitBackButtonVbox.setPadding(new Insets(20, 0, 0, 200));
        quitBackButtonVbox.setSpacing(CAppConstants.GENERAL_SPACING);

        scene = new Scene(fullWindowVbox);

        dayDishHbox = new HBox();
        dayDishHbox.setAlignment(Pos.CENTER);
        dayDishModificationVbox = new VBox();
        dayDishModificationVbox.setPadding(new Insets(10, 0, 0, 20));
        dayDishModificationVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        dayDishFormHbox = new HBox();
        dayDishFormHbox.setPadding(new Insets(10, 0, 0, 0));
        textVbox = new VBox();
        textVbox.setPadding(new Insets(5, 0, 0, 0));
        textVbox.setSpacing(17 + CAppConstants.GENERAL_SPACING);
        fieldVbox = new VBox();
        fieldVbox.setSpacing(CAppConstants.GENERAL_SPACING);

        Image logo = new Image(CAppConstants.APP_LOGO);
        logoChattangaImageView = new ImageView(logo);
        logoChattangaImageView.setFitWidth(CAppConstants.HOME_WIDTH * 0.4);
        logoChattangaImageView.setFitHeight(CAppConstants.HOME_WIDTH * 0.3);

        dayDishsListView = new ListView<CDate>();
        dayDishsListView.setPrefSize(CAppConstants.CONSULT_DAYDISH_WIDTH * 0.6, CAppConstants.CONSULT_DAYDISH_HEIGHT * 0.6);

        detailsText = new Text(CAppConstants.DAYDISH_DETAILS_TEXT);

        dateText = new Text(CAppConstants.DATE_TEXT);
        dayDishText = new Text(CAppConstants.DAYDISH_TEXT);
        imageIdentifierText = new Text(CAppConstants.IMAGE_IDENTIFIER_TEXT);

        dateTextField = new TextField();
        dateTextField.setPrefSize(CAppConstants.FIELD_WIDTH, CAppConstants.FIELD_HEIGHT);
        dayDishTextField = new TextField();
        dayDishTextField.setPrefSize(CAppConstants.FIELD_WIDTH, CAppConstants.FIELD_HEIGHT);
        imageIdentifierTextField = new TextField();
        imageIdentifierTextField.setPrefSize(CAppConstants.FIELD_WIDTH, CAppConstants.FIELD_HEIGHT);

        modificationButton = new Button(CAppConstants.MODIFICATION_BUTTON);
        modificationButton.setPrefSize(CAppConstants.BUTTON_WIDTH, CAppConstants.BUTTON_HEIGHT);

        exitButton = new Button(CAppConstants.QUIT_BUTTON);
        exitButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);
        backButton = new Button(CAppConstants.BACK_BUTTON);
        backButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);
    }


    //////// getters ////////


    public Stage getPrimaryStage() { return primaryStage; }

    public Button getExitButton() { return exitButton; }

    public Button getBackButton() { return backButton; }

    public Button getModificationButton() { return modificationButton; }

    public ListView<CDate> getDayDishsListView() { return dayDishsListView; }

    public TextField getDateTextField() { return dateTextField; }

    public TextField getDayDishTextField() { return dayDishTextField; }

    public TextField getImageIdentifierTextField() { return imageIdentifierTextField; }
}
