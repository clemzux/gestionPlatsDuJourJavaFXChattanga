package com.clemzux.chattanga.consultreservation;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultReservationModel {

    private static CConsultReservationModel ourInstance = new CConsultReservationModel();
    public static CConsultReservationModel getInstance() {
        return ourInstance;
    }

    private CConsultReservationModel() {
    }
}
