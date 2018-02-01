package com.example.inventoryFragmentBD.ui.products.interactor;

import com.example.inventoryFragmentBD.data.db.model.Product;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public interface ListProductInteractorInterface {

    interface OnLoadFinishedListener {
        void onSucces(List<Product> list);
    }

    void loadProduct();
}
