package com.example.inventory.ui.sector;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.inventory.R;
import com.example.inventory.adapter.SectorAdapter;
import com.example.inventory.ui.base.BaseActivity;
import com.example.inventory.ui.sector.fragment.AddEditSectorFragment;
import com.example.inventory.ui.sector.fragment.ListSectorFragment;
import com.example.inventory.ui.sector.presenter.AddEditSectorPresenter;
import com.example.inventory.ui.sector.presenter.ListSectorPresenter;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          Sector
 * @date 30/10/17
 */

public class SectorActivity extends BaseActivity implements ListSectorFragment.ListSectorListener {

    private ListSectorFragment listSector;
    private ListSectorPresenter listSectorPresenter;
    private AddEditSectorFragment addeditSector;
    private AddEditSectorPresenter addEditSectorPresenter;
    private SectorAdapter sectorAdapter;

    private RecyclerView recyclerSector;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1- Se crea la vista
        listSector = (ListSectorFragment) fragmentManager.findFragmentByTag(ListSectorFragment.TAG);
        if(listSector==null) {
            listSector = (ListSectorFragment) ListSectorFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listSector, ListSectorFragment.TAG);
            fragmentTransaction.commit();
        }
        // 2- Se crea el presentador, y se le pasa en el constructor la vista correspodiente
        listSectorPresenter = new ListSectorPresenter(listSector);

        // 3- Si necesitamos, se asigna el presentador a su fargment
        listSector.setPresenter(listSectorPresenter);

    }

    @Override
    public void addNewSector(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addeditSector = (AddEditSectorFragment) fragmentManager.findFragmentByTag(AddEditSectorFragment.TAG);
        if (addeditSector == null) {
            if (bundle != null) {
                addeditSector = AddEditSectorFragment.newInstace(bundle);
            } else {
                addeditSector = AddEditSectorFragment.newInstace(null);
            }
            fragmentTransaction.replace(android.R.id.content, addeditSector, AddEditSectorFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        addEditSectorPresenter = new AddEditSectorPresenter(addeditSector);
        addeditSector.setPresenter(addEditSectorPresenter);
    }
}
