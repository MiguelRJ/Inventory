package com.example.inventoryFragmentBD.ui.products;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.example.inventoryFragmentBD.R;
import com.example.inventoryFragmentBD.ui.base.BaseActivity;
import com.example.inventoryFragmentBD.ui.products.fragment.ListProductFragment;
import com.example.inventoryFragmentBD.ui.products.presenter.ListProductPresenter;

/**
 * @author Miguel Rodriguez Jimenez
 * @version 17.10.20
 *          ProductsActivity
 *          Activity de alta/edicion de productos
 * @date 17/10/2017
 */

public class ProductsActivity extends BaseActivity implements ListProductFragment.ListProductListener {

    private ListProductFragment listProduct;
    private ListProductPresenter listProductPresenter;
    /*private AddEditProductFragment addeditProduct;
    private AddEditProductPresenter addEditProductPresenter;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_product);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // 1- Se crea la vista
        listProduct = (ListProductFragment) fragmentManager.findFragmentByTag(ListProductFragment.TAG);
        if(listProduct==null) {
            listProduct = (ListProductFragment) ListProductFragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content,listProduct, ListProductFragment.TAG);
            fragmentTransaction.commit();
        }
        // 2- Se crea el presentador, y se le pasa en el constructor la vista correspodiente
        listProductPresenter = new ListProductPresenter(listProduct);

        // 3- Si necesitamos, se asigna el presentador a su fargment
        listProduct.setPresenter(listProductPresenter);
    }

    /**
     * Metodo que se ejecuta cuando se crea una nueva Product
     */
    @Override
    public void addNewProduct(Bundle bundle) {
        /*//Log.d("DA","addnewProduct()");
        FragmentManager fragmentManager = getFragmentManager();
        // 1- Se crea la vista
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addeditProduct = (AddEditProductFragment) fragmentManager.findFragmentByTag(AddEditProductFragment.TAG);
        if (addeditProduct == null) {
            if (bundle != null) {
                addeditProduct = AddEditProductFragment.newInstace(bundle);
            } else {
                addeditProduct = AddEditProductFragment.newInstace(null);
            }
            fragmentTransaction.replace(android.R.id.content, addeditProduct, AddEditProductFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2 se crea el presentador y se le pasa el constructo de la vista crrecpondiente
        addEditProductPresenter = new AddEditProductPresenter(addeditProduct);
        // 3 asignas presentador
        addeditProduct.setPresenter(addEditProductPresenter);*/
    }
}
