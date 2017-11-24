package com.example.inventoryFragment.ui.dependency.presenter;

import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryFragment.ui.dependency.interactor.AddEditDependencyIntereactorInterface;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditDependencyIntereactorInterface.OnAddDependencyListener{

    private final AddEditDependencyContract.View view;

    public AddEditDependencyPresenter (AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validateDependency(String name,String shortName,String description) {
        validateDependency(name,shortName,description);
    }

    @Override
    public void onNameEmptyError() {
        view.showNameEmptyError();
    }

    @Override
    public void onShortNameEmptyError() {
        view.showShortNameEmptyError();
    }

    @Override
    public void onDescriptionEmptyError() {
        view.showDescriptionEmptyError();
    }

    @Override
    public void onDuplicatedDependency() {
        view.showDuplicatedDependency();
    }

    @Override
    public void onSuccess() {
        view.showOnSucces();
    }
}
