package com.example.inventoryFragment.ui.dependency.interactor;

import com.example.inventoryFragment.data.db.model.Dependency;
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


    public void deleteDependeny(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependencyIterator(dependency);
    }

    /*@Override
    public void deleteDependency(String name, String shortName) {
        DependencyRepository.getInstance().deleteDependency(DependencyRepository.getInstance().getDependencyBy(name, shortName));
    }*/

}
