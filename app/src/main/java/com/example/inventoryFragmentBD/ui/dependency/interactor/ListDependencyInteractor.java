package com.example.inventoryFragmentBD.ui.dependency.interactor;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractor implements ListDependencyInteractorInterface {

    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractor(ListDependencyInteractorInterface.OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public Dependency getDependencyAtPosition(int position) {
        return DependencyRepository.getInstance().getDependencies().get(position);
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
