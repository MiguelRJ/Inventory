package com.example.inventoryFragment.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.ui.base.BaseFragment;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyPresenter";
    private AddEditDependencyListener callback;
    private AddEditDependencyContract.Presenter presenter;
    private TextInputLayout tilName,tilSortName,tilDescription;
    private EditText edtName;

    interface AddEditDependencyListener{
        void addNewDependency();
    }

    public static AddEditDependency newInstace(Bundle bundle) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if (bundle != null) {
            addEditDependency.setArguments(bundle);
        }
        return addEditDependency;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addedit_dependency,container,false);
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        tilName = rootView.findViewById(R.id.tilName);
        edtName = rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tilName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tilSortName = rootView.findViewById(R.id.tilSortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);
        if (getArguments() == null){

        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                //callback.addNewDependency();
                presenter.validateDependency(tilName.getEditText().getText().toString(),tilSortName.getEditText().getText().toString(),tilDescription.getEditText().getText().toString());
            }
        });
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void showNameEmptyError() {
        tilName.setError("error");
    }

    @Override
    public void showShortNameEmptyError() {
        tilSortName.setError("Error");
    }

    @Override
    public void showDescriptionEmptyError() {
        tilDescription.setError("rorre");
    }

    @Override
    public void showDuplicatedDependency() {

    }

    @Override
    public void showOnSucces() {

    }


}
