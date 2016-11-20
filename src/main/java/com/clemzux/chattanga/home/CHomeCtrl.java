package com.clemzux.chattanga.home;

import com.clemzux.chattanga.CLauncher;
import javafx.application.Application;
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


            }
        });

        homeGUI.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                homeGUI.getPrimaryStage().close();
            }
        });
    }
}
