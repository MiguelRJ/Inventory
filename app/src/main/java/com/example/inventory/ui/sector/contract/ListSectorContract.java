package com.example.inventory.ui.sector.contract;

import com.example.inventory.data.model.Sector;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.base.BaseView;

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
