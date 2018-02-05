package com.example.inventory.ui.products.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inventory.R;
import com.example.inventory.data.db.model.Product;
import com.example.inventory.data.db.model.ProductInner;
import com.example.inventory.ui.base.BaseFragment;
import com.example.inventory.ui.base.BasePresenter;
import com.example.inventory.ui.products.contract.AddProductContract;
import com.example.inventory.ui.products.presenter.AddProductPresenter;

/**
 * Created by usuario on 2/02/18.
 */

public class AddProductFragment extends BaseFragment implements AddProductContract.View {

    public static final String TAG = "AddProductFragment";
    private AddProductContract.Presenter presenter;

    private EditText edtNombre, edtSerial, edtSeller, edtModel, edtDescription, edtPrice, edtUrl, edtNotes;

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
        edtSerial = rootView.findViewById(R.id.edtSerial);
        edtSeller = rootView.findViewById(R.id.edtSeller);
        edtModel = rootView.findViewById(R.id.edtModel);
        edtDescription = rootView.findViewById(R.id.edtDescription);
        edtPrice = rootView.findViewById(R.id.edtPrice);
        edtUrl = rootView.findViewById(R.id.edtUrl);
        edtNotes = rootView.findViewById(R.id.edtNotes);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            edtNombre.setText( ((Product)getArguments().getParcelable(Product.TAG)).getName() );
            presenter.loadProduct(((Product)getArguments().getParcelable(Product.TAG)).get_id());
        }

    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddProductPresenter) presenter;
    }

    @Override
    public void OnSuccess(ProductInner productInner) {
        Toast.makeText(getActivity(), productInner.getDescription(), Toast.LENGTH_SHORT).show();
        edtSerial.setText(productInner.getSerial().toString());
        edtSeller.setText(productInner.getSeller().toString());
        edtModel.setText(productInner.getModel().toString());
        edtDescription.setText(productInner.getDescription().toString());
        edtPrice.setText(String.valueOf(productInner.getPrice()));
        edtUrl.setText(productInner.getUrl().toString());
        edtNotes.setText(productInner.getNotes().toString());
    }
}
