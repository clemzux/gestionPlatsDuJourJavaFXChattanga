package com.clemzux.chattanga.consultdaydish;

import com.clemzux.chattanga.home.CHomeGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultDayDishCtrl {

    private CConsultDayDishGUI consultReservationsGUI;


    //////// builder ////////


    public CConsultDayDishCtrl(CConsultDayDishGUI pGui) {

        consultReservationsGUI = pGui;

        initializeListeners();
    }


    //////// methods ////////


    private void initializeListeners() {

        consultReservationsGUI.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                CHomeGUI homeGUI = new CHomeGUI(consultReservationsGUI.getPrimaryStage());
            }
        });

        consultReservationsGUI.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                consultReservationsGUI.getPrimaryStage().close();
            }
        });
    }
}
