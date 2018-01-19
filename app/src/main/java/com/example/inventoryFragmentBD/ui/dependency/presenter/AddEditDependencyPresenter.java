package com.example.inventoryFragmentBD.ui.dependency.presenter;

import com.example.inventoryFragmentBD.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryFragmentBD.ui.dependency.interactor.AddEditDependencyInteractor;
import com.example.inventoryFragmentBD.ui.dependency.interactor.AddEditDependencyInteractorInterface;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditDependencyInteractorInterface.OnAddDependencyListener{

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

    @Override
    public void options(int i, Object o) {

    }

}
