package com.example.inventoryFragment.ui.dependency.fragment;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryFragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 18/12/17.
 */

class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {

    private ListDependencyContract.Presenter presenter;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {

    }

    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater inflater = actionMode.getMenuInflater();
        inflater.inflate(R.menu.menu_fragment_listdependency_longclick,menu);
        actionMode.setTitle("Inicianco action mdoe");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        // ante de crear la toolbar
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        // cuando se pulsa sobre el elemento
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {

    }
}
