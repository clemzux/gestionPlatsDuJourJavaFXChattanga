package com.clemzux.chattanga.createdaydish;

import chattanga.classes.CDate;
import com.clemzux.chattanga.home.CHomeGUI;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import com.clemzux.chattanga.utilitaries.CUtilitary;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.*;

/**
 * Created by clemzux on 23/11/16.
 */
public class CCreateDayDishCtrl {

    private CCreateDayDishGUI createDayDishGUI;
    private CCreateDayDishModel createDayDishModel = CCreateDayDishModel.getInstance();

    private int day, month, year;


    //////// builder ////////


    public CCreateDayDishCtrl(CCreateDayDishGUI pGui) {

        createDayDishGUI = pGui;
        createDayDishModel.setGui(pGui);

        populateComboBox();
        initializeListeners();
    }


    //////// methods ////////


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

        createDayDishGUI.getDayComboBox().setItems(FXCollections.<Integer>observableArrayList(daysList));
        createDayDishGUI.getDayComboBox().getSelectionModel().select(0);
        createDayDishGUI.getMonthComboBox().setItems(FXCollections.<Integer>observableArrayList(monthList));
        createDayDishGUI.getMonthComboBox().getSelectionModel().select(0);
        createDayDishGUI.getYearComboBox().setItems(FXCollections.<Integer>observableArrayList(yearsList));
        createDayDishGUI.getYearComboBox().getSelectionModel().select(0);
    }

    private void initializeListeners() {

        createDayDishGUI.getAddDayDishButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                day = createDayDishGUI.getDayComboBox().getSelectionModel().getSelectedItem();
                month = createDayDishGUI.getMonthComboBox().getSelectionModel().getSelectedItem();
                month--;
                year = createDayDishGUI.getYearComboBox().getSelectionModel().getSelectedItem();

                if (CUtilitary.isDateOk(day, month, year)) {

                    System.out.println(month);
                    month++;
                    if (isDayDishTextFieldNotNull())
                        createDayDish();
                    else {

                        CUtilitary.makeAlert(CAppConstants.WARNING_ALERT, CAppConstants.WARNING_DAYDISH_TEXTFIELD_EMPTY_HEADER,
                                CAppConstants.WARNING_DAYDISH_TEXTFIELD_EMPTY_TEXT);
                    }
                }
                else {
                    CUtilitary.makeAlert(CAppConstants.WARNING_ALERT, CAppConstants.WARNING_DATE_NOT_VALID_HEADER,
                            CAppConstants.WARNING_DATE_NOT_VALID_TEXT);
                }
            }
        });

        createDayDishGUI.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                CHomeGUI homeGUI = new CHomeGUI(createDayDishGUI.getPrimaryStage());
            }
        });

        createDayDishGUI.getQuitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                createDayDishGUI.getPrimaryStage().close();
            }
        });
    }

    private void createDayDish() {

        CDate dayDish = new CDate();

        String newDay, newMonth;

        if (day < 10)
            newDay = "0" + day;
        else
            newDay = String.valueOf(day);

        if (month < 10)
            newMonth = "0" + String.valueOf(month);
        else
            newMonth = String.valueOf(month);

        dayDish.setDate(newDay + "-" + newMonth + "-" + year);
        dayDish.setDayDish(createDayDishGUI.getDayDishTextField().getText());
        dayDish.setImageIdentifier(createDayDishGUI.getImageIdentifierTextField().getText());

        createDayDishModel.addDayDish(dayDish);
    }

    private Boolean isDayDishTextFieldNotNull() {

        if (!createDayDishGUI.getDayDishTextField().getText().equals(""))
            return true;

        return false;
    }


}
