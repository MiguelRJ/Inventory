package com.example.inventory.ui.sector.presenter;

import com.example.inventory.data.db.model.Dependency;
import com.example.inventory.data.db.model.Sector;
import com.example.inventory.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventory.ui.sector.contract.AddEditSectorContract;
import com.example.inventory.ui.sector.interactor.AddEditSectorInteractor;
import com.example.inventory.ui.sector.interactor.AddEditSectorInteractorInterface;

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
    public void validateSector(Sector sector) {
        interactor.validateSector(sector,this);
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
