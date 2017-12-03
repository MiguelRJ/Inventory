package com.example.inventoryFragment.ui.sector.presenter;

import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.ui.sector.contract.ListSectorContract;
import com.example.inventoryFragment.ui.sector.interactor.ListSectorInteractor;
import com.example.inventoryFragment.ui.sector.interactor.ListSectorInteractorInterface;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public class ListSectorPresenter implements ListSectorContract.Presenter, ListSectorInteractorInterface.OnLoadFinishedListener {

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
    public void options(int i, Object o) {

    }




}
