package com.example.inventoryFragment.ui.dependency;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.ListFragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.inventoryFragment.R;
import com.example.inventoryFragment.adapter.DependencyAdapter;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "ListDependencyPresenter";
    private ListDependencyListener callback;
    private ListDependencyContract.Presenter presenter;

    interface ListDependencyListener{
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be implements LisDependencyListener");
        }
    }

    public static Fragment newInstance(Bundle bundle) {
        ListDependency listDependency = new ListDependency();
        if (bundle != null) {
            listDependency.setArguments(bundle);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container,false);
        // Como se encuentra en el fragment usamos rootview
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        // Si el FloatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        //Log.d("DA","antes del setonclick");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                callback.addNewDependency();
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /*@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_dependency);
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
    }*/
}
