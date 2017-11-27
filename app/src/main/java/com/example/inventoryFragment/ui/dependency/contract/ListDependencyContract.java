package com.example.inventoryFragment.ui.dependency.contract;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> list);
    }
    interface Presenter extends BasePresenter {
        void loadDependency();
    }
}
