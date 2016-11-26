package com.clemzux.chattanga.consultdaydish;

import chattanga.classes.CDate;
import com.clemzux.chattanga.home.CHomeGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultDayDishCtrl {

    private CConsultDayDishGUI consultReservationsGUI;
    private CConsultDayDishModel consultDayDishModel = CConsultDayDishModel.getInstance();


    //////// builder ////////


    public CConsultDayDishCtrl(CConsultDayDishGUI pGui) {

        consultReservationsGUI = pGui;

        initializeListeners();

        consultDayDishModel.setGUI(pGui);
        consultDayDishModel.getDayDishAll();
    }


    //////// methods ////////


    private void initializeListeners() {

        consultReservationsGUI.getModificationButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                modifyDaydish();
            }
        });

        consultReservationsGUI.getDayDishsListView().setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                consultDayDishModel.actualizeForm(consultReservationsGUI.getDayDishsListView().getSelectionModel().getSelectedItem());
            }
        });

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

    private void modifyDaydish() {

        CDate date = new CDate();
        date.setId(consultReservationsGUI.getDayDishsListView().getSelectionModel().getSelectedItem().getId());
        date.setDate(consultReservationsGUI.getDateTextField().getText());
        date.setDayDish(consultReservationsGUI.getDayDishTextField().getText());
        date.setImageIdentifier(consultReservationsGUI.getImageIdentifierTextField().getText());

        consultDayDishModel.dayDishModification(date);
    }
}
