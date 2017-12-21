package com.example.inventoryFragment.ui.sector.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.adapter.SectorAdapter;
import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.sector.contract.ListSectorContract;
import com.example.inventoryFragment.ui.sector.presenter.ListSectorPresenter;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public class ListSectorFragment extends Fragment implements ListSectorContract.View {

    public static final String TAG = "ListSectorFragment";
    private ListSectorFragment.ListSectorListener callback;
    private SectorAdapter adapter;
    private ListSectorContract.Presenter presenter;
    private SectorAdapter.OnItemClickListener listener;

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    public interface ListSectorListener{
        void addNewSector(Bundle bundle);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(Sector sector) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Sector.TAG,sector);
                callback.addNewSector(bundle);
            }

            @Override
            public void OnLongClick(Sector sector) {
                Toast.makeText(getActivity(),sector.getDescription(),Toast.LENGTH_SHORT).show();
            }
        };
        this.adapter = new SectorAdapter(listener);
        this.presenter = new ListSectorPresenter(this);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListSectorListener)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must be implements LisDependencyListener");
        }
    }

    public static Fragment newInstance(Bundle bundle) {
        ListSectorFragment listSector = new ListSectorFragment();
        if (bundle != null) {
            listSector.setArguments(bundle);
        }
        return listSector;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_sector,container,false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        if(savedInstanceState != null){
            adapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"),listener);
        } else {
            adapter = new SectorAdapter(listener);
        }

        setHasOptionsMenu(true);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewSector(null);
            }
        });
        presenter.loadSector();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(adapter);

        //recyclerView.setOnClickListener(new RecyclerView().setOnClickListener());
        //registerForContextMenu(getListView());// OnCreateContextMenu
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListSectorContract.Presenter) presenter;
    }

    @Override
    public void showSector(List<Sector> list) {
        //adapter.clear();
        //adapter.addAll(list);
    }
}
