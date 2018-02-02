package com.example.inventoryFragmentBD.ui.products.interactor;

import com.example.inventoryFragmentBD.data.db.model.ProductInner;
import com.example.inventoryFragmentBD.ui.dependency.interactor.AddEditDependencyInteractorInterface;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductInteractor implements AddProductInteractorInterface {


    @Override
    public void getProductInnerByID(int id, AddProductInteractorInterface.OnAddProductListener listener) {
        //listener.onSuccess(new ProductInner()); // obtener de dao
    }
}
