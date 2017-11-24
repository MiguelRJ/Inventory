package com.example.inventoryFragment.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventoryFragment.ui.utils.CommonUtils;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractor {
    public void validateCredentials(String name, String shortName, String description, AddEditDependencyIntereactorInterface.OnAddDependencyListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        }else if (TextUtils.isEmpty(shortName)) {
            listener.onShortNameEmptyError();
        }else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionEmptyError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            listener.onSuccess();
        }

        //Y es correcto
    }
}
