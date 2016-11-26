package com.clemzux.chattanga.utilitaries;

import javafx.scene.control.Alert;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by clemzux on 01/11/16.
 */
public class CUtilitary {

    public static void makeAlert(String pAlertTitle, String pAlertHeader, String pAlertText) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(pAlertTitle);
        alert.setHeaderText(pAlertHeader);
        alert.setContentText(pAlertText);
        alert.showAndWait();
    }

    public static Boolean isDateOk(int pDay, int pMonth, int pYear) {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(pYear, pMonth, pDay);
        int goodYear = calendar.get(Calendar.YEAR);
        int goodMonth = calendar.get(Calendar.MONTH);
        int goodDay = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println(pDay + "   " + pMonth + "   " + pYear);
        System.out.println(goodDay + "   " + goodMonth + "   " + goodYear);

        if(goodYear==pYear & goodMonth==pMonth & goodDay==pDay){

            System.out.println("lol");

            Calendar c = Calendar.getInstance();

            System.out.println(c.get(Calendar.MONTH));

            if(c.get(Calendar.MONTH) < pMonth)
                return true;

            else
                if (c.get(Calendar.MONTH) == pMonth && c.get(Calendar.DAY_OF_MONTH) < pDay)
                    return true;
        }

        return false;
    }
}
