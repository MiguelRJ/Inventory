package com.example.inventory.ui.products.interactor;

import com.example.inventory.data.db.repository.ProductRepository;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductInteractor implements ListProductInteractorInterface {

    private ListProductInteractorInterface.OnLoadFinishedListener listener;

    public ListProductInteractor( ListProductInteractorInterface.OnLoadFinishedListener listener){
        this.listener = listener;
    }

    @Override
    public void loadProduct() {
        listener.onSucces(ProductRepository.getInstance().getProducts());
    }
}
