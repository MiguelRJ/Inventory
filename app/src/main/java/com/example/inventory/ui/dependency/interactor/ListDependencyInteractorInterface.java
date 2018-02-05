package com.example.inventory.ui.dependency.interactor;

import com.example.inventory.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractorInterface {

    Dependency getDependencyAtPosition(int size);

    interface OnLoadFinishedListener {
        void onSucces(List<Dependency> list);
        //void deleteDependency(Dependency dependency);
        void deleteDependencyIterator(Dependency dependency);
    }

    interface OnLoadDependenciesInSector {
        void loadDependency(List<Dependency> list);
    }

    void loadDependency();
    void loadDependencyForSectors();
    void deleteDependeny(Dependency dependency);
}
