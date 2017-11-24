package com.example.inventoryFragment.ui.dependency.interactor;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyIntereactorInterface {
    interface OnAddDependencyListener{
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onDescriptionEmptyError();

        void onDuplicatedDependency();

        void onSuccess();
    };
    void validateDependency(String name,String shortName,String description);
}
