package com.clemzux.chattanga.utilitaries;

import javafx.scene.control.Alert;

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
}
