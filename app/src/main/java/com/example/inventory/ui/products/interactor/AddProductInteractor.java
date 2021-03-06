package com.example.inventory.ui.products.interactor;

import com.example.inventory.data.repository.ProductRepository;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductInteractor implements AddProductInteractorInterface {


    @Override
    public void getProductInnerByID(int id, AddProductInteractorInterface.OnAddProductListener listener) {
        listener.onSuccess(ProductRepository.getInstance().getProductByInt(id)); // obtener de dao
    }
}
