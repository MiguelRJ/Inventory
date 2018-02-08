package com.example.inventory.ui.dependency.contract;

import android.app.Activity;

import com.example.inventory.data.model.Dependency;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> list);
        void showProgress();
        void dismiddProgress();
        Activity getActivityUiThread();
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
