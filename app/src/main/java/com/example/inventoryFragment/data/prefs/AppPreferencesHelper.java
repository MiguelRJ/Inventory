package com.example.inventoryFragment.data.prefs;

import android.content.SharedPreferences;
import com.example.inventoryFragment.ui.inventory.InventoryApplication;
import com.example.inventoryFragment.ui.utils.AppConstants;

/**
 * AppPreferencesHelper o PreferencesManager
 *      - singleton
 *      - constructor publico
 *      - instanciar mediante clase application
 *      - se puede hacer singleton si es un unico fichero
 *      - una sola instancia de preferencias
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper, GeneralPreferencesHelper {

     // 1. Se definen todas las key posibles del fichero de preferencias
    // pero en si interfaz


    // 2. El objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper() {
        // Si es el fichero pr defecto de las preferencias
        this.preferences = ((InventoryApplication.getContext()).getSharedPreferences(AppConstants.PREF_NAME,0));
        // Si es un fichero con nombre diferente
    }

    /**
     * Metodo de acceso a la instancia de la clase AppPreferencesHelper
     * @return
     */
    public static AppPreferencesHelper getInstance(){
        if (instance == null) {
            instance = new AppPreferencesHelper();
        }
        return instance;
    }

    public long getCurrentUserId() {
        long id=preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public String getCurrentUserName() {
        String name=preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public String getCurrentUserPassword() {
        String password=preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
        return password;
    }

    public boolean getCurrentUserRemember() {
        boolean rememberUser=preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
        return rememberUser;
    }

    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID,id).apply();
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME,name).apply();
    }

    public void setCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD,password).apply();
    }

    public void setCurrentUserRemember(boolean rememberUser) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER,rememberUser).apply();
    }
}
