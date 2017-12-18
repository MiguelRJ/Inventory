package com.example.inventoryFragment.ui.dependency.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragment.ui.dependency.interactor.ListDependencyInteractor;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,ListDependencyInteractor.OnLoadFinishedListener{

    public static final int DELETE = 1;

    ListDependencyContract.View view;
    //private static TYPE_FILTER;
    private ListDependencyInteractor interactor;

    public ListDependencyPresenter(ListDependencyContract.View view){
        this.view = view;
        this.interactor = new ListDependencyInteractor(this);
    }

    @Override
    public void loadDependency() {
        //progress bar
        interactor.loadDependency();
    }



    @Override
    public void onSucces(List<Dependency> list) {
        view.showDependency(list);
    }


    @Override
    public void deleteDependencyIterator(Dependency dependency) {
        interactor.deleteDependeny(dependency);
        loadDependency();
    }

    @Override
    public void OnDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void options(int i,Object o) {
        switch (i) {
            case DELETE:
                deleteDependencyIterator((Dependency)o);
                break;
            default:
                Log.e("Error option","opcion "+i+" no encontrada");
        }
    }

    // metodos que gestionan la selecion de la vista

    @Override
    public void setNewSelection(int position) {

    }

    @Override
    public void removeSelection(int position) {

    }

    @Override
    public void deleteSelection() {

    }

    @Override
    public void clearSelection() {

    }


}
