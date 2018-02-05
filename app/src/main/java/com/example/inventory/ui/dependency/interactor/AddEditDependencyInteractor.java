package com.example.inventory.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventory.data.db.model.Dependency;
import com.example.inventory.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractor implements AddEditDependencyInteractorInterface {

    private AddEditDependencyInteractorInterface.OnAddDependencyListener listener;

    public AddEditDependencyInteractor( AddEditDependencyInteractorInterface.OnAddDependencyListener listener){
        this.listener = listener;
    }

    @Override
    public void validateDependency(String name, String shortName, String description, String imageName) {
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
                        new Dependency(DependencyRepository.getInstance().getDependencies().size() + 1, name, shortName, description, imageName),this
                );
            } else {
                Dependency dependency = new Dependency(id,name,shortName,description,imageName);
                //DependencyRepository.getInstance().editDependencyById(id,name,shortName,description);
                DependencyRepository.getInstance().updateDependency(dependency,this);
            }
            listener.onSuccess();
        }
    }

    @Override
    public void onSuccess() {
        listener.onSuccess();
    }

    @Override
    public void onError() {
        listener.onNameEmptyError(); // hay que modificar este error
    }
}
