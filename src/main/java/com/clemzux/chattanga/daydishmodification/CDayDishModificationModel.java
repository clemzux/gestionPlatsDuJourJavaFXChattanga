package com.clemzux.chattanga.daydishmodification;

/**
 * Created by clemzux on 20/11/16.
 */
public class CDayDishModificationModel {
    private static CDayDishModificationModel ourInstance = new CDayDishModificationModel();

    public static CDayDishModificationModel getInstance() {
        return ourInstance;
    }

    private CDayDishModificationModel() {
    }
}
