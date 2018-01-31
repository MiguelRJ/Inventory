package com.example.inventoryFragmentBD.ui.dependency.interactor;

import android.os.AsyncTask;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.data.db.repository.DependencyRepository;

import java.util.ArrayList;

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
        try {
            new AsyncTask<Void, Void, ArrayList<Dependency>>() {
                @Override
                protected void onPreExecute() {
                    //show dialog
                }

                @Override
                protected ArrayList<Dependency> doInBackground(Void... params) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return DependencyRepository.getInstance().getDependencies();
                }

                @Override
                protected void onPostExecute(ArrayList<Dependency> dependencies) {
                    listener.onSucces(dependencies);
                }
            }.execute();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }


    public void deleteDependeny(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependencyIterator(dependency);
    }

    /*@Override
    public void deleteDependency(String name, String shortName) {
        DependencyRepository.getInstance().deleteDependency(DependencyRepository.getInstance().getDependencyBy(name, shortName));
    }*/

}
