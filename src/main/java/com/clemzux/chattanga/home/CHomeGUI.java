package com.clemzux.chattanga.home;

import com.clemzux.chattanga.utilitaries.CAppConstants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Created by clemzux on 01/11/16.
 */

public class CHomeGUI {

    private CHomeCtrl homeCtrl;

    private Stage primaryStage;
    private Scene scene;

    private VBox fullWindowVbox;
    private HBox topWindowHbox;

    private ImageView logoChattangaImageView;
    private Button exitButton, createDayDishButton, consultDayDishButton, sendImageToServerButton, consultReservationsButton;


    //////// builder ////////


    public CHomeGUI(Stage pStage) {

        primaryStage = pStage;

        initializeWidgets();
        widgetsPlacement();
        windowFinalization();

        homeCtrl = new CHomeCtrl(this);
    }


    //////// methods ////////


    private void windowFinalization() {

        primaryStage.setTitle(CAppConstants.APP_NAME + CAppConstants.APP_HOME_NAME);
        primaryStage.setResizable(false);
        primaryStage.setWidth(CAppConstants.HOME_WIDTH);
        primaryStage.setHeight(CAppConstants.HOME_HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void widgetsPlacement() {

        topWindowHbox.getChildren().addAll(logoChattangaImageView, exitButton);

        fullWindowVbox.getChildren().addAll(topWindowHbox, consultReservationsButton, consultDayDishButton, createDayDishButton,
                sendImageToServerButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeWidgets() {

        fullWindowVbox = new VBox();
        fullWindowVbox.setAlignment(Pos.CENTER);
        fullWindowVbox.setSpacing(CAppConstants.GENERAL_SPACING);
        fullWindowVbox.setBackground(CAppConstants.appBackGround);

        topWindowHbox = new HBox();
        topWindowHbox.setAlignment(Pos.CENTER);
        topWindowHbox.setSpacing(CAppConstants.LOGO_SPACING);

        scene = new Scene(fullWindowVbox, CAppConstants.HOME_WIDTH, CAppConstants.HOME_WIDTH);

        Image image = new Image(CAppConstants.APP_LOGO);
        logoChattangaImageView = new ImageView(image);
        logoChattangaImageView.setFitWidth(CAppConstants.HOME_WIDTH * 0.4);
        logoChattangaImageView.setFitHeight(CAppConstants.HOME_WIDTH * 0.3);

        exitButton = new Button(CAppConstants.QUIT_BUTTON);
        exitButton.setPrefSize(CAppConstants.QUIT_BUTTON_WIDTH, CAppConstants.QUIT_BUTTON_HEIGHT);
        consultDayDishButton = new Button(CAppConstants.CONSULT_DAYDISH_BUTTON);
        consultDayDishButton.setPrefSize(CAppConstants.BUTTON_WIDTH, CAppConstants.BUTTON_HEIGHT);
        createDayDishButton = new Button(CAppConstants.CREATE_DAYDISH_BUTTON);
        createDayDishButton.setPrefSize(CAppConstants.BUTTON_WIDTH, CAppConstants.BUTTON_HEIGHT);
        sendImageToServerButton = new Button(CAppConstants.SEND_IMAGE_TO_SERVER_BUTTON);
        sendImageToServerButton.setPrefSize(CAppConstants.BUTTON_WIDTH, CAppConstants.BUTTON_HEIGHT);
        consultReservationsButton = new Button(CAppConstants.CONSULT_RESERVATIONS_BUTTON);
        consultReservationsButton.setPrefSize(CAppConstants.BUTTON_WIDTH, CAppConstants.BUTTON_HEIGHT);
    }


    //////// getters / setters ////////


    public Button getExitButton() { return exitButton; }

    public Button getDayDIshModificationButton() { return createDayDishButton; }

    public Button getConsultDayDishButton() { return consultDayDishButton; }

    public Button getSendImageToServerButton() { return sendImageToServerButton; }

    public Button getConsultReservationsButton() { return consultReservationsButton; }

    public Scene getScene() { return scene; }

    public Stage getPrimaryStage() { return primaryStage; }
}
