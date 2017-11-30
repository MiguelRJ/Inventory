package com.example.inventoryFragment.ui.dependency.interactor;

import com.example.inventoryFragment.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements ListDependencyInteractorInterface {

    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractor(ListDependencyInteractorInterface.OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadDependency() {
        listener.onSucces(DependencyRepository.getInstance().getDependencies());
    }


    public void deleteDependeny(int id) {
        DependencyRepository.getInstance().deleteDependency(id);
    }

    /*@Override
    public void deleteDependency(String name, String shortName) {
        DependencyRepository.getInstance().deleteDependency(DependencyRepository.getInstance().getDependencyBy(name, shortName));
    }*/

}
