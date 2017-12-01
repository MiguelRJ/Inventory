package com.example.inventoryFragment.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.inventoryFragment.R;
import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.ui.base.BasePresenter;

/**
 * Created by usuario on 30/11/17.
 */

public class ComonDialog {

    public static String MESSAGE = "message";
    public static String TITTLE = "tittle";

    public static Dialog showConfirmDialog(final Bundle bundle, Context context, final BasePresenter presenter, final int option){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(ComonDialog.MESSAGE))
                .setTitle(bundle.getString(ComonDialog.TITTLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.options(option,bundle.getParcelable(bundle.getString("TAG")));
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }
}
