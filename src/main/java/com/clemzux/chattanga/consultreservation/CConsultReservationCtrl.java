package com.clemzux.chattanga.consultreservation;

import com.clemzux.chattanga.home.CHomeGUI;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
        populateComboBox();
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

    private void populateComboBox() {

        List<Integer> daysList = new ArrayList<Integer>();
        List<Integer> monthList = new ArrayList<Integer>();
        List<Integer> yearsList = new ArrayList<Integer>();

        int i;

        for (i=1; i<=31; i++)
            daysList.add(i);

        for (i=1; i<=12; i++)
            monthList.add(i);

        for (i= Calendar.getInstance().get(Calendar.YEAR); i<Calendar.getInstance().get(Calendar.YEAR)+2; i++)
            yearsList.add(i);

        consultReservationGUI.getDaysComboBox().setItems(FXCollections.<Integer>observableArrayList(daysList));
        consultReservationGUI.getDaysComboBox().getSelectionModel().select(0);
        consultReservationGUI.getMonthsComboBox().setItems(FXCollections.<Integer>observableArrayList(monthList));
        consultReservationGUI.getMonthsComboBox().getSelectionModel().select(0);
        consultReservationGUI.getYearsComboBox().setItems(FXCollections.<Integer>observableArrayList(yearsList));
        consultReservationGUI.getYearsComboBox().getSelectionModel().select(0);
    }
}
