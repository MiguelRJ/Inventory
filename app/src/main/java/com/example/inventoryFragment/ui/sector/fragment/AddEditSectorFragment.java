package com.example.inventoryFragment.ui.sector.fragment;

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

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.ui.base.BaseFragment;
import com.example.inventoryFragment.ui.base.BasePresenter;
import com.example.inventoryFragment.ui.sector.contract.AddEditSectorContract;
import com.example.inventoryFragment.ui.sector.presenter.AddEditSectorPresenter;
import com.example.inventoryFragment.ui.utils.AddEdit;

/**
 * Created by Miguel on 03/12/2017.
 */

public class AddEditSectorFragment extends BaseFragment implements AddEditSectorContract.View {

    public static final String TAG = "AddEditSectorFragment";
    private AddEditSectorContract.Presenter presenter;

    private TextInputLayout tilName,tilSortName,tilDescription;
    private FloatingActionButton fab;

    static AddEdit mode;

    public static AddEditSectorFragment newInstace(Bundle bundle) {
        AddEditSectorFragment addEditSector = new AddEditSectorFragment();
        mode = new AddEdit();
        if (bundle != null) {
            mode.setMode(AddEdit.EDIT_MODE);
            addEditSector.setArguments(bundle);
        }
        return addEditSector;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // al poner el presetner en el fragment se puede guardar con setretain
        presenter = new AddEditSectorPresenter(this);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addedit_sector,container,false);

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
                presenter.validateSector(tilName.getEditText().getText().toString(),
                        tilSortName.getEditText().getText().toString(),
                        tilDescription.getEditText().getText().toString());
            }
        });

        if (getArguments() != null){
            tilName.getEditText().setText(((Sector)getArguments().getParcelable(Sector.TAG)).getName().toString());
            tilName.setEnabled(false);
            tilSortName.getEditText().setText(((Sector)getArguments().getParcelable(Sector.TAG)).getSortname().toString());
            tilSortName.setEnabled(false);
            tilDescription.getEditText().setText(((Sector)getArguments().getParcelable(Sector.TAG)).getDescription().toString());
        }
        return rootView;
    }







    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditSectorContract.Presenter)presenter;
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
    public void showDuplicatedSector() {

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
