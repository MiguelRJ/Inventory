package com.example.inventoryFragmentBD.ui.dependency.contract;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {
    interface View extends BaseView {
        void showNameEmptyError();
        void showShortNameEmptyError();
        void showDescriptionEmptyError();
        void showDuplicatedDependency();
        void showOnSucces();
    }
    interface Presenter extends BasePresenter {
        void validateDependency(String name,String shortName,String description);
    }
}
