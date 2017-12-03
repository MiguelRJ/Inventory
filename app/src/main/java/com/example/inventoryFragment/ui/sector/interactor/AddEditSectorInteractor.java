package com.example.inventoryFragment.ui.sector.interactor;

import android.text.TextUtils;

import com.example.inventoryFragment.data.db.model.Sector;
import com.example.inventoryFragment.data.db.repository.SectorRepository;

/**
 * Created by Miguel on 03/12/2017.
 */

public class AddEditSectorInteractor implements AddEditSectorInteractorInterface {
    @Override
    public void validateSector(String name, String shortName, String description, AddEditSectorInteractorInterface.OnAddSectorListener listener) {
        //Si el password es vacio
        if(TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        }else if (TextUtils.isEmpty(shortName)) {
            listener.onShortNameEmptyError();
        }else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionEmptyError();
        } else if (true){//UserRepository.getInstance().validateCredentials(user, password)
            int id;
            id = SectorRepository.getInstance().getSectorBy(name,shortName);
            //Log.e("interactor","id encontrado "+String.valueOf(id));
            if (id < 0) {
                SectorRepository.getInstance().addSector(
                        new Sector(SectorRepository.getInstance().getSectors().size() + 1, name, shortName, description,1,false,false));
            } else {
                SectorRepository.getInstance().editDependencyById(id,name,shortName,description);
            }
            listener.onSuccess();
        }
    }
}
