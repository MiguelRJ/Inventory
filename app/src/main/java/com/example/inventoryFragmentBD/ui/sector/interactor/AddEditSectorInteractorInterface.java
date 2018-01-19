package com.example.inventoryFragmentBD.ui.sector.interactor;

/**
 * Created by Miguel on 03/12/2017.
 */

public interface AddEditSectorInteractorInterface {
    interface OnAddSectorListener{
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onDescriptionEmptyError();

        void onDuplicatedSector();

        void onSuccess();
    };
    void validateSector(String name,String shortName,String description, AddEditSectorInteractorInterface.OnAddSectorListener listener);
}
