package com.example.inventory.ui.products;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.os.Bundle;
import com.example.inventory.R;
import com.example.inventory.ui.base.BaseActivity;
import com.example.inventory.ui.products.fragment.AddProductFragment;
import com.example.inventory.ui.products.fragment.ListProductFragment;
import com.example.inventory.ui.products.presenter.AddProductPresenter;
import com.example.inventory.ui.products.presenter.ListProductPresenter;

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
    private AddProductFragment addProduct;
    private AddProductPresenter addProductPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
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
        //Log.d("DA","addnewProduct()");
        FragmentManager fragmentManager = getFragmentManager();
        // 1- Se crea la vista
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        addProduct = (AddProductFragment) fragmentManager.findFragmentByTag(AddProductFragment.TAG);
        if (addProduct == null) {
            if (bundle != null) {
                addProduct = AddProductFragment.newInstace(bundle);
            } else {
                addProduct = AddProductFragment.newInstace(null);
            }
            fragmentTransaction.replace(android.R.id.content, addProduct, AddProductFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2 se crea el presentador y se le pasa el constructo de la vista crrecpondiente
        addProductPresenter = new AddProductPresenter(addProduct);
        // 3 asignas presentador
        addProduct.setPresenter(addProductPresenter);
    }
}
