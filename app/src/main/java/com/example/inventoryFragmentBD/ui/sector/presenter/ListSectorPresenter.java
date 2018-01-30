package com.example.inventoryFragmentBD.ui.sector.presenter;

import android.util.Log;

import com.example.inventoryFragmentBD.data.db.model.Sector;
import com.example.inventoryFragmentBD.data.db.repository.SectorRepository;
import com.example.inventoryFragmentBD.ui.sector.contract.ListSectorContract;
import com.example.inventoryFragmentBD.ui.sector.interactor.ListSectorInteractor;
import com.example.inventoryFragmentBD.ui.sector.interactor.ListSectorInteractorInterface;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public class ListSectorPresenter implements ListSectorContract.Presenter, ListSectorInteractorInterface.OnLoadFinishedListener {

    public static final int DELETE = 1;

    ListSectorContract.View view;
    private ListSectorInteractor interactor;

    public ListSectorPresenter(ListSectorContract.View view){
        this.view = view;
        this.interactor = new ListSectorInteractor(this);
    }

    @Override
    public void onSucces(List<Sector> list) {
        view.showSector(list);
    }

    @Override
    public void loadSector() {
        interactor.loadSector();
    }

    @Override
    public void OnDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void deleteSector(Sector sector) {
        interactor.deleteSector(sector);
    }

    @Override
    public void options(int i, Object o) {
        switch (i) {
            case DELETE:
                deleteSector((Sector)o);
                break;
            default:
                Log.e("Error option","opcion "+i+" no encontrada");
        }
    }




}
