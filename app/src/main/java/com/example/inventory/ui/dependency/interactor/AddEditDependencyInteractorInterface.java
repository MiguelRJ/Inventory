package com.example.inventory.ui.dependency.interactor;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractorInterface {
    interface OnAddDependencyListener{
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onDescriptionEmptyError();

        void onDuplicatedDependency();

        void onSuccess();
    };
    void validateDependency(String name,String shortName,String description, String imageName);
    void onSuccess();
    void onError();
}
