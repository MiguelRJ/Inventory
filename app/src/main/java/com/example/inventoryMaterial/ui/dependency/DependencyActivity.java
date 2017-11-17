package com.example.inventoryMaterial.ui.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;


import com.example.inventoryMaterial.DashBoardActivity;
import com.example.inventoryMaterial.R;
import com.example.inventoryMaterial.adapter.DependencyAdapter;
import com.example.inventoryMaterial.ui.prefs.AccountSettingActivity;
import com.example.inventoryMaterial.ui.products.GeneralSettingActivity;

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
                //Snackbar.make(coordinatorLayout,"Ejemplo Snackbar",Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(DependencyActivity.this,AddDependencyActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dependency,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order_by_name:
                adapter = new DependencyAdapter(this);
                listview.setAdapter(adapter);
                break;
            case R.id.action_order_by_shortname:
                listview.setAdapter(adapter.orderByShortName());
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
