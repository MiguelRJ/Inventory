package com.example.inventoryFragmentBD.ui.sector.interactor;

import android.text.TextUtils;

import com.example.inventoryFragmentBD.data.db.model.Sector;
import com.example.inventoryFragmentBD.data.db.repository.SectorRepository;

/**
 * Created by Miguel on 03/12/2017.
 */

public class AddEditSectorInteractor implements AddEditSectorInteractorInterface {

    @Override
    public void validateSector(Sector sector, OnAddSectorListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(sector.getName().toString())) {
            listener.onNameEmptyError();
        }else if (TextUtils.isEmpty(sector.getSortName().toString())) {
            listener.onShortNameEmptyError();
        }else if (TextUtils.isEmpty(sector.getDescription().toString())) {
            listener.onDescriptionEmptyError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)

            int id;
            id = SectorRepository.getInstance().getSectorBy(sector.getName().toString(),sector.getSortName().toString());
            //Log.e("interactor","id encontrado "+String.valueOf(id));

            if (id < 0) {

                SectorRepository.getInstance().addSector(sector);

            } else {

                SectorRepository.getInstance().editSectorById(sector);

            }
            listener.onSuccess();
        }
    }
}
