package com.example.inventoryFragment.ui.dependency.presenter;

import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter{
    ListDependencyContract.View view;
    public ListDependencyPresenter(ListDependencyContract.View view){
        this.view = view;
    }
}
