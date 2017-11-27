package com.example.inventoryFragment.ui.dependency.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.base.BaseFragment;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyFragment extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyPresenter";
    private AddEditDependencyContract.Presenter presenter;

    private TextInputLayout tilName,tilSortName,tilDescription;
    private FloatingActionButton fab;

    public static AddEditDependencyFragment newInstace(Bundle bundle) {
        AddEditDependencyFragment addEditDependency = new AddEditDependencyFragment();
        if (bundle != null) {
            addEditDependency.setArguments(bundle);
        }
        return addEditDependency;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addedit_dependency,container,false);

        tilName = (TextInputLayout) rootView.findViewById(R.id.tilName);
        tilName.getEditText().addTextChangedListener(new TextWatcher() {
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

        tilSortName = (TextInputLayout) rootView.findViewById(R.id.tilSortName);
        tilSortName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tilSortName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tilDescription = (TextInputLayout) rootView.findViewById(R.id.tilDescription);
        tilDescription.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tilDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                //callback.addNewDependency();
                presenter.validateDependency(tilName.getEditText().getText().toString(),
                        tilSortName.getEditText().getText().toString(),
                        tilDescription.getEditText().getText().toString());
            }
        });

        if (getArguments() == null){

        }
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }

    @Override
    public void showNameEmptyError() {
        tilName.setError(getString(R.string.errorNameEmpty));
    }

    @Override
    public void showShortNameEmptyError() {
        tilSortName.setError(getString(R.string.errorShortNameEmpty));
    }

    @Override
    public void showDescriptionEmptyError() {
        tilDescription.setError(getString(R.string.errorDescripcionEmpty));
    }

    @Override
    public void showDuplicatedDependency() {

    }

    @Override
    public void showOnSucces() {
        showMessage("Guardado");
    }


}
