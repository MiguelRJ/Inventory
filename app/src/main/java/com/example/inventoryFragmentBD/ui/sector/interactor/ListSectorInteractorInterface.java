package com.example.inventoryFragmentBD.ui.sector.interactor;


import com.example.inventoryFragmentBD.data.db.model.Sector;
import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public interface ListSectorInteractorInterface {

    interface OnLoadFinishedListener {
        void onSucces(List<Sector> list);
    }

    void loadSector();
}