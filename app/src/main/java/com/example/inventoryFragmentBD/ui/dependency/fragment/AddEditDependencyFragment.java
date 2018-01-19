package com.example.inventoryFragmentBD.ui.dependency.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryFragmentBD.R;
import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.ui.base.BaseFragment;
import com.example.inventoryFragmentBD.ui.base.BasePresenter;
import com.example.inventoryFragmentBD.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryFragmentBD.ui.dependency.presenter.AddEditDependencyPresenter;
import com.example.inventoryFragmentBD.ui.utils.AddEdit;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyFragment extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyFragment";
    private AddEditDependencyContract.Presenter presenter;

    private TextInputLayout tilName,tilSortName,tilDescription;
    private FloatingActionButton fab;

    static AddEdit mode;

    public static AddEditDependencyFragment newInstace(Bundle bundle) {
        AddEditDependencyFragment addEditDependency = new AddEditDependencyFragment();
        mode = new AddEdit();
        if (bundle != null) {
            mode.setMode(AddEdit.EDIT_MODE);
            addEditDependency.setArguments(bundle);
        }
        return addEditDependency;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // al poner el presetner en el fragment se puede guardar con setretain
        presenter = new AddEditDependencyPresenter(this);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addedit_dependency,container,false);

        // como el fragment mantiene el estado y solo elimina la vistas
        // se debe reinicialiar el presenter ciando se crea la vista

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

        if (getArguments() != null){
            tilName.getEditText().setText(((Dependency)getArguments().getParcelable(Dependency.TAG)).getName().toString());
            tilName.setEnabled(false);
            tilSortName.getEditText().setText(((Dependency)getArguments().getParcelable(Dependency.TAG)).getSortName().toString());
            tilSortName.setEnabled(false);
            tilDescription.getEditText().setText(((Dependency)getArguments().getParcelable(Dependency.TAG)).getDescription().toString());
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
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.OnDestroy();
    }

}
