package com.example.inventoryFragmentBD.ui.products.contract;

import com.example.inventoryFragmentBD.data.db.model.ProductInner;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.base.BaseView;

/**
 * Created by usuario on 2/02/18.
 */

public interface AddProductContract {
    interface View extends BaseView {
        void OnSuccess(ProductInner productInner);
    }
    interface Presenter extends BasePresenter {
        void loadProduct(int id);
    }
}
