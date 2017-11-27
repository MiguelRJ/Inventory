package com.example.inventoryFragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.ui.base.BaseActivity;
import com.example.inventoryFragment.ui.dependency.fragment.AddEditDependencyFragment;
import com.example.inventoryFragment.ui.dependency.fragment.DetailDependencyFragment;
import com.example.inventoryFragment.ui.dependency.fragment.ListDependencyFragment;
import com.example.inventoryFragment.ui.dependency.presenter.AddEditDependencyPresenter;
import com.example.inventoryFragment.ui.dependency.presenter.DetailDependencyPresenter;
import com.example.inventoryFragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by
 *
 * @author Miguel Rodriguez Jimenez
 * @version 1
 *          DependencyActivity
 *          ListActivity tiene una lista interna por defecto
 *          que en el layout tiene que tener nombre de android si o si (android:id="@android:id/list")
 *          nos ahorramos el findbyid del ListView interno al tener el nombre de android
 * @date 25/10/17
 */

public class DependencyActivity extends BaseActivity implements ListDependencyFragment.ListDependencyListener{

    private ListDependencyFragment listDependency;
    private ListDependencyPresenter listDependencyPresenter;
    private AddEditDependencyFragment addeditDependency;
    private AddEditDependencyPresenter addEditDependencyPresenter;
    private DetailDependencyFragment detailDependency;
    private DetailDependencyPresenter detailDependencyPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1- Se crea la vista
        listDependency = (ListDependencyFragment) fragmentManager.findFragmentByTag(ListDependencyFragment.TAG);
        if(listDependency==null) {
            listDependency = (ListDependencyFragment) ListDependencyFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listDependency, ListDependencyFragment.TAG);
            fragmentTransaction.commit();
        }
        // 2- Se crea el presentador, y se le pasa en el constructor la vista correspodiente
        listDependencyPresenter = new ListDependencyPresenter(listDependency);

        // 3- Si necesitamos, se asigna el presentador a su fargment
        listDependency.setPresenter(listDependencyPresenter);
    }

    /**
     * Metodo que se ejecuta cuando se crea una nueva dependency
     */
    @Override
    public void addNewDependency() {
        //Log.d("DA","addnewdependency()");
        FragmentManager fragmentManager = getFragmentManager();
        // 1- Se crea la vista
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addeditDependency = (AddEditDependencyFragment) fragmentManager.findFragmentByTag(AddEditDependencyFragment.TAG);
        if (addeditDependency == null) {
            addeditDependency = AddEditDependencyFragment.newInstace(null);
            fragmentTransaction.replace(android.R.id.content, addeditDependency, AddEditDependencyFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2 se crea el presentador y se le pasa el constructo de la vista crrecpondiente
        addEditDependencyPresenter = new AddEditDependencyPresenter(addeditDependency);
        // 3 asignas presentador
        addeditDependency.setPresenter(addEditDependencyPresenter);

    }

}
