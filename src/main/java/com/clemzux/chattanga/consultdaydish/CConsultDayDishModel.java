package com.clemzux.chattanga.consultdaydish;


import chattanga.classes.CDate;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import com.sun.jersey.api.client.GenericType;
import javafx.collections.FXCollections;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.clemzux.chattanga.utilitaries.CAppConstants.webResource;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultDayDishModel {

    private static CConsultDayDishModel ourInstance = new CConsultDayDishModel();
    public static CConsultDayDishModel getInstance() {
        return ourInstance;
    }

    private CConsultDayDishGUI consultReservationsGUI;

    private CConsultDayDishModel() {}


    //////// methods ////////


    public void setGUI(CConsultDayDishGUI consultReservationsGUI) { this.consultReservationsGUI = consultReservationsGUI; }

    public void getDayDishAll() {

        List<CDate> dayDishs = CAppConstants.webResource.path("dates").type(MediaType.APPLICATION_JSON).get(
                new GenericType<List<CDate>>(){});
        consultReservationsGUI.getDayDishsListView().setItems(FXCollections.<CDate>observableArrayList(dayDishs));
    }

    public void actualizeForm(CDate pDate) {

        consultReservationsGUI.getDateTextField().setText(pDate.getDate());
        consultReservationsGUI.getDayDishTextField().setText(pDate.getDayDish());
        consultReservationsGUI.getImageIdentifierTextField().setText(pDate.getImageIdentifier());
    }

    public void dayDishModification(CDate pDate) {

        CAppConstants.webResource.path("dates").type(MediaType.APPLICATION_JSON).post(pDate);
    }
}
