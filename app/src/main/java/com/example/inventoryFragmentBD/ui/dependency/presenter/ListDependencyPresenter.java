package com.example.inventoryFragmentBD.ui.dependency.presenter;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragmentBD.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventoryFragmentBD.ui.inventory.InventoryApplication;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
        //view.showProgress();
        //interactor.loadDependency();
        try {
            view.showProgress();
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    // Load data from Model
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    interactor.loadDependency();
                    return null;
                }

            }.execute();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void onSucces(List<Dependency> list) {
        view.dismiddProgress();
        view.showDependency(list);
    }


    @Override
    public void deleteDependencyIterator(Dependency dependency) {
        interactor.deleteDependeny(dependency);
        //loadDependency();
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
        for(Integer position : selection.keySet()){
            interactor.deleteDependeny(view.getDependency(position));
        }
        /*Iterator<HashMap.Entry<Integer,Boolean>> it = selection.entrySet().iterator();
        while(it.hasNext()){
            Integer position = it.next().getKey();
            //HashMap.Entry<Integer,Boolean> entry = it.next();
            Log.e("delete",String.valueOf(position));
            interactor.deleteDependeny(interactor.getDependencyAtPosition(position));
            it.remove();
            Log.e("delete2",String.valueOf(position));
        }*/
        //interactor.loadDependency();
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
