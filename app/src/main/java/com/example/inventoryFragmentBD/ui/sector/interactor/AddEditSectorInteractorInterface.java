package com.example.inventoryFragmentBD.ui.sector.interactor;

import com.example.inventoryFragmentBD.data.db.model.Sector;

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
    void validateSector(Sector sector, AddEditSectorInteractorInterface.OnAddSectorListener listener);
}
