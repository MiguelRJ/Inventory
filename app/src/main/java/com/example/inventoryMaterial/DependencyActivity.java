package com.example.inventoryMaterial;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.example.inventoryMaterial.adapter.DependencyAdapter;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          DependencyActivity
 *          ListActivity tiene una lista interna por defecto
 *          que en el layout tiene que tener nombre de android si o si (android:id="@android:id/list")
 *          nos ahorramos el findbyid del ListView interno al tener el nombre de android
 * @date 25/10/17
 */

public class DependencyActivity extends AppCompatActivity {

    //private ArrayAdapter<Dependency> adapter;
    //private DependencyAdapterA adapter;
    //private DependencyAdapterB adapter;
    private DependencyAdapter adapter;
    private ListView listview;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        // CASO 1: adapter no personalizado
        //dependencies = new ArrayAdapter(this,android.R.layout.simple_list_item_1,((InventoryApplication)getApplicationContext()).getDependencies());
        //getListView().setAdapter(adapter);

        // CASO 2: adapter personalizado
        //adapter = new DependencyAdapterA(this);
        //adapter = new DependencyAdapterB(this);
        listview = findViewById(android.R.id.list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        fab=findViewById(R.id.fab);
        coordinatorLayout=findViewById(R.id.coordinator);

        setSupportActionBar(toolbar);
        adapter = new DependencyAdapter(this);
        listview.setAdapter(adapter);

        // al pulser sobre el boton se visualizara el snackbar y FAB se desplazara haci arriba
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout,"Ejemplo Snackbar",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
