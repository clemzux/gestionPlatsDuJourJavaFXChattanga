package com.clemzux.chattanga.consultreservation;

import chattanga.classes.CReservation;
import com.clemzux.chattanga.home.CHomeGUI;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    private Calendar cal = Calendar.getInstance();


    //////// builder ////////


    public CConsultReservationCtrl(CConsultReservationGUI pGui) {

        consultReservationGUI = pGui;
        consultReservationModel.setGui(pGui);

        initializeListerners();
        populateComboBox();
        populateListView();
    }


    //////// methods ////////


    private void populateListView() {

        String date = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);

        consultReservationModel.getReservationsByDate(date);
    }

    private void initializeListerners() {

        consultReservationGUI.getActualizeButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                refreshListView();
            }
        });

        consultReservationGUI.getReservationListView().getSelectionModel().selectedItemProperty().addListener(

                new ChangeListener<CReservation>() {
                    public void changed(ObservableValue<? extends CReservation> observable, CReservation oldValue, CReservation newValue) {

                        consultReservationModel.setReservationOnFields(
                                consultReservationGUI.getReservationListView().getSelectionModel().getSelectedItem());
                    }
                }
        );

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

    private void refreshListView() {

        String date = String.valueOf(consultReservationGUI.getDaysComboBox().getSelectionModel().getSelectedItem());
        date += "-" + String.valueOf(consultReservationGUI.getMonthsComboBox().getSelectionModel().getSelectedItem());
        date += "-" + String.valueOf(consultReservationGUI.getYearsComboBox().getSelectionModel().getSelectedItem());

        consultReservationModel.getReservationsByDate(date);
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

        for (i= cal.get(Calendar.YEAR); i<cal.get(Calendar.YEAR)+2; i++)
            yearsList.add(i);

        consultReservationGUI.getDaysComboBox().setItems(FXCollections.<Integer>observableArrayList(daysList));
        consultReservationGUI.getDaysComboBox().getSelectionModel().select(cal.get(Calendar.DAY_OF_MONTH));
        consultReservationGUI.getMonthsComboBox().setItems(FXCollections.<Integer>observableArrayList(monthList));
        consultReservationGUI.getMonthsComboBox().getSelectionModel().select(cal.get(Calendar.MONTH));
        consultReservationGUI.getYearsComboBox().setItems(FXCollections.<Integer>observableArrayList(yearsList));
        consultReservationGUI.getYearsComboBox().getSelectionModel().select(0);
    }
}
