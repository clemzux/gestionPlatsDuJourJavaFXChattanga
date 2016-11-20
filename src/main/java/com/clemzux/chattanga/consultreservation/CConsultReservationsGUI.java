package com.clemzux.chattanga.consultreservation;

import javafx.stage.Stage;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationsGUI {

    private CConsultReservationsCtrl consultReservationsCtrl;

    private Stage primaryStage;


    //////// builder ////////


    public CConsultReservationsGUI(Stage pStage) {

        primaryStage = pStage;

        consultReservationsCtrl = new CConsultReservationsCtrl(this);
    }
}
