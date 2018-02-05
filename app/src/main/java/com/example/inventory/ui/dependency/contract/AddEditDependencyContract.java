package com.example.inventory.ui.dependency.contract;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.base.BaseView;

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
        void validateDependency(String name,String shortName,String description,String imageName);
    }
}
