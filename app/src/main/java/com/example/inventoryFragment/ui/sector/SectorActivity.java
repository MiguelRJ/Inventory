package com.example.inventoryFragment.ui.sector;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.adapter.SectorAdapter;
import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.ui.base.BaseActivity;
import com.example.inventoryFragment.ui.sector.fragment.ListSectorFragment;
import com.example.inventoryFragment.ui.sector.presenter.ListSectorPresenter;

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
    //private AddEditSectorFragment addeditSector;
    //private AddEditSectorPresenter addEditSectorPresenter;
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

    }
}
