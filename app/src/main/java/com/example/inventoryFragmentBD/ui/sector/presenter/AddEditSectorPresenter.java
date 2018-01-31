package com.example.inventoryFragmentBD.ui.sector.presenter;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventoryFragmentBD.ui.sector.contract.AddEditSectorContract;
import com.example.inventoryFragmentBD.ui.sector.interactor.AddEditSectorInteractor;
import com.example.inventoryFragmentBD.ui.sector.interactor.AddEditSectorInteractorInterface;

import java.util.List;

/**
 * Created by Miguel on 03/12/2017.
 */

public class AddEditSectorPresenter implements AddEditSectorContract.Presenter,
        AddEditSectorInteractorInterface.OnAddSectorListener,
        ListDependencyInteractor.OnLoadDependenciesInSector{

    private AddEditSectorContract.View view;
    private AddEditSectorInteractor interactor;
    private ListDependencyInteractor listDependencyInteractor;

    public AddEditSectorPresenter (AddEditSectorContract.View view) {
        this.view = view;
        interactor = new AddEditSectorInteractor();
        listDependencyInteractor = new ListDependencyInteractor(this);
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

    @Override
    public void loadDependencies() {
        listDependencyInteractor.loadDependencyForSectors();
    }

    @Override
    public void loadDependency(List<Dependency> list) {
        view.showDependencies(list);
    }
}
