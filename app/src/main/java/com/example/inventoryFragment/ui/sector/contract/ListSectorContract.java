package com.example.inventoryFragment.ui.sector.contract;

import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.base.BaseView;

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
    }
}
