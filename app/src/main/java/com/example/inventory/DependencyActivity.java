package com.example.inventory;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import com.example.inventory.pojo.Dependency;

/**
 * Created by usuario on 25/10/17.
 * ListActivity tiene una lista interna por defecto
 * que en el layout tiene que tener nombre de android si o si (android:id="@android:id/list")
 * nos ahorramos el findbyid del ListView interno al tener el nombre de android
 *
 */

public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> dependencies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        // CASO 1: adapter no personalizado
        dependencies = new ArrayAdapter(this,android.R.layout.simple_list_item_1,((InventoryApplication)getApplicationContext()).getDependencies());
        getListView().setAdapter(dependencies);

        // CASO 2: adapter personalizado
    }
}
