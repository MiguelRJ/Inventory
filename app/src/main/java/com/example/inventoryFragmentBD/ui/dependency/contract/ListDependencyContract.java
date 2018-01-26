package com.example.inventoryFragmentBD.ui.dependency.contract;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> list);
        void showProgress();

        void dismiddProgress();
        Dependency getDependency(Integer position);
    }
    interface Presenter extends BasePresenter {
        void loadDependency();

        void setNewSelection(int position);

        void removeSelection(int position);

        void deleteSelection();

        void clearSelection();

        boolean isPositionChecked(int position);
    }
}
