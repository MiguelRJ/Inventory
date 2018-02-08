package com.example.inventory.ui.products.interactor;

import com.example.inventory.data.model.Product;

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
