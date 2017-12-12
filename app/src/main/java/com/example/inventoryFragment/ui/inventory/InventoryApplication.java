package com.example.inventoryFragment.ui.inventory;

import android.app.Application;
import android.content.Context;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.data.prefs.AppPreferencesHelper;

import java.util.ArrayList;

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
    }

    public AppPreferencesHelper getAppPreferencesHelper(){
        return appPreferencesHelper;
    }

    public static Context getContext() {
        return mContext;
    }

}
