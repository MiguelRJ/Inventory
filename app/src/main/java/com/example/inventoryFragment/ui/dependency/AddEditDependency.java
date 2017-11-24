package com.example.inventoryFragment.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryFragment.ui.dependency.presenter.AddEditDependencyPresenter;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyPresenter";
    private AddEditDependencyListener callback;
    private AddEditDependencyContract.Presenter presenter;

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
        if (getArguments() == null){

        }
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("DA","dentro del onclick");
                //callback.addNewDependency();
            }
        });
        return rootView;
    }

    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
