package com.clemzux.chattanga.createdaydish;

import chattanga.classes.CDate;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import com.clemzux.chattanga.utilitaries.CUtilitary;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by clemzux on 23/11/16.
 */
public class CCreateDayDishModel {

    private static CCreateDayDishModel ourInstance = new CCreateDayDishModel();
    public static CCreateDayDishModel getInstance() {
        return ourInstance;
    }

    private CCreateDayDishGUI createDayDishGUI;


    private CCreateDayDishModel() {}


    //////// methods ////////


    public Boolean addDayDish(CDate pDate) {

        try {
            CDate date = CAppConstants.webResource.path("dates/date/" + pDate.getDate()).type(MediaType.APPLICATION_JSON).get(CDate.class);

            if (!date.getDate().equals("")) {

                CUtilitary.makeAlert(CAppConstants.WARNING_ALERT, CAppConstants.WARNING_DAYDISH_ALREADY_EXISTS_HEADER,
                        CAppConstants.WARNING_DAYDISH_ALREADY_EXISTS_TEXT);
                return false;
            }

        } catch (Exception e) {}

        CAppConstants.webResource.path("dates").type(MediaType.APPLICATION_JSON).post(pDate);

        return true;
    }

    public void setGui(CCreateDayDishGUI pGui) {

        createDayDishGUI = pGui;
    }
}
