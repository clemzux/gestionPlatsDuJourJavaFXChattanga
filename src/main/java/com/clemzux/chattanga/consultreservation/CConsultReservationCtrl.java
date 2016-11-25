package com.clemzux.chattanga.consultreservation;

import com.clemzux.chattanga.home.CHomeGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationCtrl {

    private CConsultReservationGUI consultReservationGUI;
    private CConsultReservationModel consultReservationModel = CConsultReservationModel.getInstance();


    //////// builder ////////


    public CConsultReservationCtrl(CConsultReservationGUI pGui) {

        consultReservationGUI = pGui;

        initializeListerners();
    }


    //////// methods ////////


    private void initializeListerners() {

        consultReservationGUI.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                CHomeGUI homeGUI = new CHomeGUI(consultReservationGUI.getPrimaryStage());
            }
        });

        consultReservationGUI.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                consultReservationGUI.getPrimaryStage().close();
            }
        });
    }
}
