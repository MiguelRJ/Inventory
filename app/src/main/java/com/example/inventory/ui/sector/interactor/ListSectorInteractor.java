package com.example.inventory.ui.sector.interactor;

import com.example.inventory.data.model.Sector;
import com.example.inventory.data.repository.SectorRepository;

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

    @Override
    public void deleteSector(Sector sector) {
        SectorRepository.getInstance().deleteSector(sector);
    }
}
