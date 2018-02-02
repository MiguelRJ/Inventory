package com.example.inventoryFragmentBD.ui.products.presenter;

import com.example.inventoryFragmentBD.data.db.model.ProductInner;
import com.example.inventoryFragmentBD.ui.products.contract.AddProductContract;
import com.example.inventoryFragmentBD.ui.products.interactor.AddProductInteractor;
import com.example.inventoryFragmentBD.ui.products.interactor.AddProductInteractorInterface;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductPresenter implements AddProductContract.Presenter, AddProductInteractorInterface.OnAddProductListener {

    private AddProductContract.View view;
    private AddProductInteractorInterface interactor;

    public AddProductPresenter(AddProductContract.View view){
        this.view = view;
        interactor = new AddProductInteractor();
    }

    @Override
    public void OnDestroy() {
        view = null;
        interactor = null;
    }

    @Override
    public void options(int i, Object o) {

    }

    @Override
    public void loadProduct(int id) {
        interactor.getProductInnerByID(id,this);
    }

    @Override
    public void onSuccess(ProductInner productInner) {
        view.OnSuccess(productInner);
    }
}
