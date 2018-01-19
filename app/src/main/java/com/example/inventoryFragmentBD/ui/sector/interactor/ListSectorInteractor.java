package com.example.inventoryFragmentBD.ui.sector.interactor;

import com.example.inventoryFragmentBD.data.db.repository.SectorRepository;

/**
 * Created by Miguel on 03/12/2017.
 */

public class ListSectorInteractor implements ListSectorInteractorInterface {

    private ListSectorInteractorInterface.OnLoadFinishedListener listener;

    public ListSectorInteractor(ListSectorInteractorInterface.OnLoadFinishedListener listener){
        this.listener = listener;
    }

    @Override
    public void loadSector() {
        listener.onSucces(SectorRepository.getInstance().getSectors());
    }
}
