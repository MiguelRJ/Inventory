package com.example.inventoryFragmentBD.ui.inventory;

import android.app.Application;
import android.content.Context;

import com.example.inventoryFragmentBD.data.db.InventoryOpenHelper;
import com.example.inventoryFragmentBD.data.prefs.AppPreferencesHelper;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 * @date 25/10/17
 */

public class InventoryApplication extends Application {

    private AppPreferencesHelper appPreferencesHelper;
    private static InventoryApplication mContext;

    public InventoryApplication() {
        mContext = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
        InventoryOpenHelper.getInstance().openDateBase();
    }

    public AppPreferencesHelper getAppPreferencesHelper(){
        return appPreferencesHelper;
    }

    public static Context getContext() {
        return mContext;
    }

}
