package com.example.inventoryFragment.ui.dependency.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.ListFragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.adapter.DependencyAdapter;
import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragment.ui.dependency.presenter.ListDependencyPresenter;
import com.example.inventoryFragment.ui.utils.ComonDialog;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "ListDependencyPresenter";
    private ListDependencyListener callback;
    private DependencyAdapter adapter;
    private ListDependencyContract.Presenter presenter;

    private ListView listView;
    private Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        this.presenter = new ListDependencyPresenter(this);
        setRetainInstance(true);
    }

    public interface ListDependencyListener{
        void addNewDependency(Bundle bundle);
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
        ListDependencyFragment listDependency = new ListDependencyFragment();
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
        toolbar = rootView.findViewById(R.id.toolbar);
        listView = rootView.findViewById(android.R.id.list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listView.setNestedScrollingEnabled(true);
        }
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        //Log.d("DA","antes del setonclick");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                callback.addNewDependency(null);
            }
        });
        presenter.loadDependency();
        return rootView;
    }

    /**
     * Menu contextual (pulsacion larga) sobre la lista
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Options list dependency");
        getActivity().getMenuInflater().inflate(R.menu.menu_fragment_listdependency_longclick, menu);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_listdependency,menu);
    }

    /**
     * Se asigna el adapter isn datos a la lista
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setListAdapter(new DependencyAdapter(getActivity()));
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Dependency.TAG,(Dependency)adapterView.getItemAtPosition(position));
                callback.addNewDependency(bundle);
            }
        });
        registerForContextMenu(getListView());// OnCreateContextMenu
    }

    /**
     * implementar las diferentes acciones a realizar en las opcioes del menu contextual
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
                Dependency dependency = (Dependency) getListView().getItemAtPosition(info.position);
                Bundle bundle = new Bundle();
                bundle.putString(ComonDialog.TITTLE, "Eliminar dependencia");
                bundle.putString(ComonDialog.MESSAGE,"Desea eliminar la dependencia: "+dependency.getName());
                bundle.putString("TAG",Dependency.TAG);
                bundle.putParcelable(Dependency.TAG,dependency);
                Dialog dialog = ComonDialog.showConfirmDialog(bundle,getActivity(),presenter, ListDependencyPresenter.DELETE);
                dialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     *
     * @param presenter
     */
    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    @Override
    public void showDependency(List<Dependency> list) {
        adapter.clear();
        adapter.addAll(list);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.OnDestroy();
        adapter = null;
    }
}
