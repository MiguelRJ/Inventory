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
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
        count = 0;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode actionMode, int position, long l, boolean checked) {
        if(checked) {
            count++;
            presenter.setNewSelection(position);
        } else {
            count--;
            presenter.removeSelection(position);
        }
        actionMode.setTitle(count + " seleccionados");
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
        switch (menuItem.getItemId()){
            case R.id.action_listdependency_delete:
                presenter.deleteSelection();
                break;
        }
        actionMode.finish();
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {
        count = 0;
        presenter.clearSelection();
    }
}
