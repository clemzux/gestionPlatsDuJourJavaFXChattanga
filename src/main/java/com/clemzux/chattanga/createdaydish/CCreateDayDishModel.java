package com.clemzux.chattanga.createdaydish;

/**
 * Created by clemzux on 23/11/16.
 */
public class CCreateDayDishModel {

    private static CCreateDayDishModel ourInstance = new CCreateDayDishModel();
    public static CCreateDayDishModel getInstance() {
        return ourInstance;
    }

    private CCreateDayDishModel() {
    }
}
