package com.example.inventory.data.provider.dao;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.example.inventory.data.base.DependencyDao;
import com.example.inventory.data.model.Dependency;
import com.example.inventory.data.provider.InventoryProviderContract;
import com.example.inventory.ui.inventory.InventoryApplication;
import java.util.ArrayList;

/**
 * Created by usuario on 7/02/18.
 */

public class DependencyProviderDaoImpl implements DependencyDao {

    @Override
    public ArrayList<Dependency> loadAll() {

        ArrayList<Dependency> list = new ArrayList<>();

        //1. Array projections (se puede igualar al projection de la clase, en vez de los campos, pero asi lo veremos en internet)
        String[] projections = new String[]{
                InventoryProviderContract.Dependency._ID,
                InventoryProviderContract.Dependency.NAME,
                InventoryProviderContract.Dependency.SHORTNAME,
                InventoryProviderContract.Dependency.DESCRIPTION,
                InventoryProviderContract.Dependency.IMAGENAME
        };

        //2. Hago la consulta al provider con la uri de Dependency
        // Con content provider esta registrado en el sistema
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();//todos los content provider estan getionados por esto
        Cursor cursor = cr.query(
                InventoryProviderContract.Dependency.CONTENT_URI,
                projections,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            do {
                list.add(new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4)
                ));
            }while (cursor.moveToNext());
        }

        return list;
    }

    @Override
    public boolean exists(Dependency dependency) {
        return false;
    }

    @Override
    public long add(Dependency dependency) {
        ContentResolver cr = InventoryApplication.getContext().getContentResolver();
        Uri uri = cr.insert(
                InventoryProviderContract.Dependency.CONTENT_URI,
                CreateContent(dependency)
        );
        if (uri==null){
            return -1;
        }
        return Long.parseLong(uri.getLastPathSegment()); // ha añadido en dependency, el ultimo elemento de la uri es el id, del nuevo insert
    }

    @Override
    public int update(Dependency dependency) {
        return 0;
    }

    @Override
    public int delete(Dependency dependency) {
        return 0;
    }

    @Override
    public ContentValues CreateContent(Dependency dependency) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryProviderContract.Dependency.NAME, dependency.getName());
        contentValues.put(InventoryProviderContract.Dependency.SHORTNAME, dependency.getSortName());
        contentValues.put(InventoryProviderContract.Dependency.DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryProviderContract.Dependency.IMAGENAME, dependency.getImageName());
        return contentValues;
    }
}
