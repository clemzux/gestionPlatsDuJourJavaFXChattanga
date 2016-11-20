package com.clemzux.chattanga.consultdaydish;

/**
 * Created by clemzux on 20/11/16.
 */
public class CConsultDayDishModel {

    private static CConsultDayDishModel ourInstance = new CConsultDayDishModel();

    public static CConsultDayDishModel getInstance() {
        return ourInstance;
    }

    private CConsultDayDishModel() {
    }
}
