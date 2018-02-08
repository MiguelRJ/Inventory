package com.example.inventory.ui.products.presenter;

import com.example.inventory.data.model.Product;
import com.example.inventory.ui.products.contract.ListProductContract;
import com.example.inventory.ui.products.interactor.ListProductInteractor;
import com.example.inventory.ui.products.interactor.ListProductInteractorInterface;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public class ListProductPresenter implements ListProductContract.Presenter, ListProductInteractorInterface.OnLoadFinishedListener {

    ListProductContract.View view;
    private ListProductInteractorInterface interactor;

    public ListProductPresenter(ListProductContract.View view) {
        this.view = view;
        this.interactor = new ListProductInteractor(this);
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
    public void onSucces(List<Product> list) {
        view.showDependency(list);
    }

    @Override
    public void loadProduct() {
        interactor.loadProduct();
    }
}
