package com.example.inventoryFragment.ui.sector.contract;

import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.base.BaseView;

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
    }
    interface Presenter extends BasePresenter {
        void validateSector(String name,String shortName, String description);
    }
}
