package com.example.inventoryFragment.ui.dependency.presenter;

import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter {
    AddEditDependencyContract.View view;
    public AddEditDependencyPresenter (AddEditDependencyContract.View view) {
        this.view = view;
    }
}
