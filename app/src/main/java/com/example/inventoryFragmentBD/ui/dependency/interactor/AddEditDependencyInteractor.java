package com.example.inventoryFragmentBD.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventoryFragmentBD.data.db.model.Dependency;
import com.example.inventoryFragmentBD.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractor implements AddEditDependencyInteractorInterface {

    @Override
    public void validateDependency(String name, String shortName, String description, String imageName, AddEditDependencyInteractorInterface.OnAddDependencyListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        }else if (TextUtils.isEmpty(shortName)) {
            listener.onShortNameEmptyError();
        }else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionEmptyError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            int id;
            id = DependencyRepository.getInstance().getDependencyBy(name,shortName);
            //Log.e("interactor","id encontrado "+String.valueOf(id));
            if (id < 0) {
                DependencyRepository.getInstance().addDependency(
                        new Dependency(DependencyRepository.getInstance().getDependencies().size() + 1, name, shortName, description, imageName));
            } else {
                DependencyRepository.getInstance().editDependencyById(id,name,shortName,description);
            }
            listener.onSuccess();
        }
    }
}
