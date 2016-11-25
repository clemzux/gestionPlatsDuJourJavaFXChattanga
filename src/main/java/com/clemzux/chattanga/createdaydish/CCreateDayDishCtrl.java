package com.clemzux.chattanga.createdaydish;

import com.clemzux.chattanga.home.CHomeGUI;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by clemzux on 23/11/16.
 */
public class CCreateDayDishCtrl {

    private CCreateDayDishGUI createDayDishGUI;
    private CCreateDayDishModel createDayDishModel = CCreateDayDishModel.getInstance();


    //////// builder ////////


    public CCreateDayDishCtrl(CCreateDayDishGUI pGui) {

        createDayDishGUI = pGui;

        initializeListeners();
    }


    //////// methods ////////


    private void initializeListeners() {

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
}
