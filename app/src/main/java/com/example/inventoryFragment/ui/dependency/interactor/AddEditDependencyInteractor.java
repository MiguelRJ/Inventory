package com.example.inventoryFragment.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventoryFragment.data.db.model.Dependency;
import com.example.inventoryFragment.data.db.repository.DependencyRepository;
import com.example.inventoryFragment.ui.utils.CommonUtils;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractor implements AddEditDependencyIntereactorInterface {

    @Override
    public void validateDependency(String name, String shortName, String description,AddEditDependencyIntereactorInterface.OnAddDependencyListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        }else if (TextUtils.isEmpty(shortName)) {
            listener.onShortNameEmptyError();
        }else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionEmptyError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            DependencyRepository.getInstance().addDependency(
                    new Dependency(DependencyRepository.getInstance().getDependencies().size()+1,name,shortName,description));
            listener.onSuccess();
        }
    }
}
