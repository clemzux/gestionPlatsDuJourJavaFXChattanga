package com.clemzux.chattanga.home;

import com.clemzux.chattanga.consultdaydish.CConsultDayDishGUI;
import com.clemzux.chattanga.consultreservation.CConsultReservationGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by clemzux on 01/11/16.
 */
public class CHomeCtrl {

    private CHomeGUI homeGUI;
    private CHomeModel homeModel = CHomeModel.getInstance();


    //////// bilder ////////


    public CHomeCtrl(CHomeGUI pGui) {

        homeGUI = pGui;
        homeModel.setGui(pGui);

        initializeListeners();
    }


    //////// methods ////////


    private void initializeListeners() {

        homeGUI.getConsultReservationsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                CConsultReservationGUI consultReservationGUI = new CConsultReservationGUI(homeGUI.getPrimaryStage());
            }
        });

        homeGUI.getConsultDayDishButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                CConsultDayDishGUI consultReservationsGUI = new CConsultDayDishGUI(homeGUI.getPrimaryStage());
            }
        });

        homeGUI.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                homeGUI.getPrimaryStage().close();
            }
        });
    }
}
