package com.example.inventory;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventory.adapter.DependencyAdapter;
import com.example.inventory.adapter.SectorAdapter;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 30/10/17
 */

public class SectorActivity extends ListActivity {

    private SectorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        adapter = new SectorActivity(this);
        getListView().setAdapter(adapter);
    }
}
