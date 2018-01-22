package com.example.inventoryFragmentBD.ui.dependency.interactor;

import com.example.inventoryFragmentBD.data.db.model.Dependency;

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

    void loadDependency();
    //void deleteDependeny(int id);
}