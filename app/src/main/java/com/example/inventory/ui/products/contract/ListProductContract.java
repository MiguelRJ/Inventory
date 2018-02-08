package com.example.inventory.ui.products.contract;

import com.example.inventory.data.model.Product;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 1/02/18.
 */

public interface ListProductContract {
    interface View extends BaseView {
        void showDependency(List<Product> list);
    }
    interface Presenter extends BasePresenter {
        void loadProduct();
    }
}
