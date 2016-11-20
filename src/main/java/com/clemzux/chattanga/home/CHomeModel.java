package com.clemzux.chattanga.home;

/**
 * Created by clemzux on 20/11/16.
 */
public class CHomeModel {

    private static CHomeModel ourInstance = new CHomeModel();
    public static CHomeModel getInstance() {
        return ourInstance;
    }

    private CHomeGUI homeGUI;

    private CHomeModel() {
    }

    public void setGui(CHomeGUI pGui) { homeGUI = pGui; }
}
