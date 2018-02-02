package com.example.inventoryFragmentBD.ui.products.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventoryFragmentBD.R;
import com.example.inventoryFragmentBD.data.db.model.Product;
import com.example.inventoryFragmentBD.data.db.model.ProductInner;
import com.example.inventoryFragmentBD.ui.base.BaseFragment;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.products.contract.AddProductContract;
import com.example.inventoryFragmentBD.ui.products.presenter.AddProductPresenter;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductFragment extends BaseFragment implements AddProductContract.View {

    public static final String TAG = "AddProductFragment";
    private AddProductContract.Presenter presenter;

    private EditText edtNombre;

    public static AddProductFragment newInstace(Bundle bundle) {
        AddProductFragment addProduct = new AddProductFragment();
        if (bundle != null) {
            addProduct.setArguments(bundle);
        }
        return addProduct;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AddProductPresenter(this);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_product, container, false);

        edtNombre = rootView.findViewById(R.id.edtNombre);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            edtNombre.setText( ((Product)getArguments().getParcelable(Product.TAG)).getName() );
            presenter.loadProduct(((Product)getArguments().getParcelable(Product.TAG)).get_id());
            Toast.makeText(getActivity(), String.valueOf(((Product)getArguments().getParcelable(Product.TAG)).get_id()), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddProductPresenter) presenter;
    }

    @Override
    public void OnSuccess(ProductInner productInner) {
        Toast.makeText(getActivity(), productInner.getName(), Toast.LENGTH_SHORT).show();
    }
}
