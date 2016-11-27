package com.clemzux.chattanga.consultreservation;

import chattanga.classes.CDate;
import chattanga.classes.CReservation;
import com.clemzux.chattanga.utilitaries.CAppConstants;
import com.sun.jersey.api.client.GenericType;
import javafx.collections.FXCollections;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationModel {

    private static CConsultReservationModel ourInstance = new CConsultReservationModel();
    public static CConsultReservationModel getInstance() {
        return ourInstance;
    }


    private CConsultReservationGUI consultReservationGUI;

    private CConsultReservationModel() {}


    //////// methods ////////


    public void setGui(CConsultReservationGUI pGui) {

        consultReservationGUI = pGui;
    }

    public void setReservationOnFields(CReservation pReservation) {

        consultReservationGUI.getNameChangeText().setText(pReservation.getName());
        consultReservationGUI.getTelChangeText().setText(pReservation.getTel());
        consultReservationGUI.getNumberPeopleChangeText().setText(String.valueOf(pReservation.getNumberPeople()));
        consultReservationGUI.getNumberDayDishChangeText().setText(String.valueOf(pReservation.getNumberDayDish()));
        consultReservationGUI.getHourArriveChangeText().setText(pReservation.getHourArrive());

        // algo pour écrire une note sur plusieurs lignes

        int j = 20;

        if (pReservation.getNote().length() > j) {

            int i = 0, l = pReservation.getNote().length();
            String s, fullString = "";

            while (i < l) {

                if (i + j < l-1) {
                    s = pReservation.getNote().substring(i, i+j);
                    fullString += s +"\n";
//                    consultReservationGUI.getTextChangeVbox().getChildren().addAll(new Text(s + "\n"));
                }

                i += j;
            }

            i -= j;
            s = pReservation.getNote().substring(i, l-1);
            fullString += s +"\n";
            consultReservationGUI.getNoteChangeText().setText(fullString);
        }
        else
            consultReservationGUI.getNoteChangeText().setText(pReservation.getNote());
    }

    public void getReservationsByDate(String pDate) {

        List<CReservation> reservations;
        reservations = CAppConstants.webResource.path(
                "dates/" + pDate + "/reservations").get(new GenericType<List<CReservation>>(){});

        consultReservationGUI.getReservationListView().setItems(FXCollections.observableList(reservations));
        consultReservationGUI.getReservationListView().getSelectionModel().select(0);
    }
}
