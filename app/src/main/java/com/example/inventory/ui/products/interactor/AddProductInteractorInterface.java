package com.example.inventory.ui.products.interactor;

import com.example.inventory.data.db.model.ProductInner;

/**
 * Created by usuario on 2/02/18.
 */

public interface AddProductInteractorInterface {

    interface OnAddProductListener{
        void onSuccess(ProductInner productInner);
    };
    void getProductInnerByID(int id, AddProductInteractorInterface.OnAddProductListener listener);
}
