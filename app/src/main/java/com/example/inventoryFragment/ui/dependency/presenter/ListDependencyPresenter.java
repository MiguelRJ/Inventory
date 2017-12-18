package com.example.inventoryFragment.ui.dependency.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.data.db.repository.DependencyRepository;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragment.ui.dependency.interactor.ListDependencyInteractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    HashMap<Integer,Boolean> selection = new HashMap<>();

    @Override
    public void setNewSelection(int position) {
        selection.put(position,true);// poner el elemento en el mapa como true
    }

    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }

    /**
     * Motodo que elimina los elementos seleccionados en el mapa
     */
    @Override
    public void deleteSelection() {
        for (HashMap.Entry<Integer,Boolean> entry : selection.entrySet()) {
            Log.e("delete",String.valueOf(entry.getKey()));
            interactor.deleteDependeny(interactor.getDependencyAtPosition(entry.getKey()));
            selection.remove(entry.getKey());
        }
        interactor.loadDependency();
    }

    @Override
    public void clearSelection() {
        selection.clear();
    }

    /**
     * Comprobar si el elemento existe en el mapa
     * @param position
     * @return
     */
    @Override
    public boolean isPositionChecked(int position) {
        return selection.get(position)==null?false:true; //si es null devuelve falso si no true
    }


}
