package com.example.inventory.ui.sector.contract;

import com.example.inventory.data.db.model.Dependency;
import com.example.inventory.data.db.model.Sector;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.base.BaseView;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public interface AddEditSectorContract {
    interface View extends BaseView {
        void showNameEmptyError();
        void showShortNameEmptyError();
        void showDescriptionEmptyError();
        void showDuplicatedSector();
        void showOnSucces();
        void showDependencies(List<Dependency> list);
    }
    interface Presenter extends BasePresenter {
        void validateSector(Sector sector);
        void loadDependencies();
    }
}
