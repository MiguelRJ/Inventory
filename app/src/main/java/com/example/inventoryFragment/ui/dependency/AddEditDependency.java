package com.example.inventoryFragment.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyPresenter";

    AddEditDependencyContract.Presenter presenter;

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
        if (getArguments() == null){

        }
        return rootView;
    }

    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
