package com.example.inventory.ui.dependency.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
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

import com.example.inventory.R;
import com.example.inventory.adapter.DependencyAdapter;
import com.example.inventory.data.db.model.Dependency;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.dependency.contract.ListDependencyContract;
import com.example.inventory.ui.dependency.presenter.ListDependencyPresenter;
import com.example.inventory.ui.utils.ComonDialog;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyFragment extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "ListDependencyFragment";
    private ListDependencyListener callback;
    private DependencyAdapter adapter;
    private ListDependencyContract.Presenter presenter;

    private ListView listView;
    private Toolbar toolbar;
    private ProgressDialog progress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        this.presenter = new ListDependencyPresenter(this);
        setRetainInstance(true);
        progress = new ProgressDialog(getActivity());
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setMessage("Conectando . . .");
        progress.setCancelable(false);
    }

    public interface ListDependencyListener {
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
        final FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
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
                getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
                callback.addNewDependency(null);
            }
        });

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
        presenter.loadDependency();
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
        //activar el modo multichoice en la lista
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);// modal mantiene la seleccion
        getListView().setMultiChoiceModeListener(new DependencyMultiChoiceModeListener(presenter));
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                getListView().setItemChecked(position,!presenter.isPositionChecked(position));
                return true;
            }
        });
        //registerForContextMenu(getListView()); //se ha comentado porque hemos cambio a mode multichoice  // OnCreateContextMenu
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
    public Dependency getDependency(Integer position) {
        return adapter.getItem(position);
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

    @Override
    public void showProgress(){
        progress.show();
    }

    @Override
    public Activity getActivityUiThread(){
        return getActivity();
    }

    @Override
    public void dismiddProgress(){
        progress.dismiss();
    }

    public void notifyList(){
        listView.notify();
    }


}
