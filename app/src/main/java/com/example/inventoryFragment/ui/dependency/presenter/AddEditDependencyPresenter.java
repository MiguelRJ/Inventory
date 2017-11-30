package com.example.inventoryFragment.ui.dependency.presenter;

import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryFragment.ui.dependency.interactor.AddEditDependencyInteractor;
import com.example.inventoryFragment.ui.dependency.interactor.AddEditDependencyIntereactorInterface;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditDependencyIntereactorInterface.OnAddDependencyListener{

    private AddEditDependencyContract.View view;
    private AddEditDependencyInteractor interactor;

    public AddEditDependencyPresenter (AddEditDependencyContract.View view) {
        this.view = view;
        interactor = new AddEditDependencyInteractor();
    }

    @Override
    public void validateDependency(String name,String shortName,String description) {
        interactor.validateDependency(name,shortName,description, this);
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

    @Override
    public void OnDestroy() {
        view = null;
        interactor = null;
    }
}
