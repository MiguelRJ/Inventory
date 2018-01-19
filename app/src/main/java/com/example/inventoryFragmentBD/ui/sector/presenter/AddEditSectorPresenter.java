package com.example.inventoryFragmentBD.ui.sector.presenter;

import com.example.inventoryFragmentBD.ui.sector.contract.AddEditSectorContract;
import com.example.inventoryFragmentBD.ui.sector.interactor.AddEditSectorInteractor;
import com.example.inventoryFragmentBD.ui.sector.interactor.AddEditSectorInteractorInterface;

/**
 * Created by Miguel on 03/12/2017.
 */

public class AddEditSectorPresenter implements AddEditSectorContract.Presenter,AddEditSectorInteractorInterface.OnAddSectorListener {

    private AddEditSectorContract.View view;
    private AddEditSectorInteractor interactor;

    public AddEditSectorPresenter (AddEditSectorContract.View view) {
        this.view = view;
        interactor = new AddEditSectorInteractor();
    }

    @Override
    public void validateSector(String name, String shortName, String description) {
        interactor.validateSector(name,shortName,description,this);
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
    public void onDuplicatedSector() {
        view.showDuplicatedSector();
    }

    @Override
    public void onSuccess() {
        view.showOnSucces();
    }

    @Override
    public void OnDestroy() {

    }

    @Override
    public void options(int i, Object o) {

    }
}
