package com.example.inventoryFragmentBD.ui.products.contract;

import com.example.inventoryFragmentBD.data.db.model.Product;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.base.BaseView;

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
