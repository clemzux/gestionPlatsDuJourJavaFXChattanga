package com.clemzux.chattanga.consultreservation;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationsModel {
    private static CConsultReservationsModel ourInstance = new CConsultReservationsModel();

    public static CConsultReservationsModel getInstance() {
        return ourInstance;
    }

    private CConsultReservationsModel() {
    }
}
