package com.example.inventory.ui.products;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.inventory.R;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 02/11/17
 */

public class GeneralSettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }
}
