package com.clemzux.chattanga;

import com.clemzux.chattanga.home.CHomeGUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by clemzux on 20/11/16.
 */
public class CLauncher extends Application {

    public static void main( String[] args ) {
        Application.launch();

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        CHomeGUI homeGUI = new CHomeGUI(primaryStage);
    }
}
