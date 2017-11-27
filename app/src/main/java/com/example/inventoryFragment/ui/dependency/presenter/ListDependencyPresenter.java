package com.example.inventoryFragment.ui.dependency.presenter;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragment.ui.dependency.interactor.ListDependencyInteractor;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,ListDependencyInteractor.OnLoadFinishedListener{
    ListDependencyContract.View view;
    //private static TYPE_FILTER;
    private ListDependencyInteractor interactor;

    public ListDependencyPresenter(ListDependencyContract.View view){
        this.view = view;
        this.interactor = new ListDependencyInteractor(this);
    }

    @Override
    public void loadDependency() {
        //progress bar
        interactor.loadDependency();
    }


    @Override
    public void onSucces(List<Dependency> list) {
        view.showDependency(list);
    }
}
