package com.example.inventoryFragmentBD.ui.sector.contract;

import com.example.inventoryFragmentBD.data.db.model.Sector;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.base.BaseView;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public interface ListSectorContract {
    interface View extends BaseView {
        void showSector(List<Sector> list);
    }
    interface Presenter extends BasePresenter {
        void loadSector();
        void deleteSector(Sector sector);
    }
}
